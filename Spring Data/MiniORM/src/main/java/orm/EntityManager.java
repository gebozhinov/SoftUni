package orm;


import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    private static final String CREATE_VALUE_FORMAT = "%s %s";
    private static final String CREATE_QUERY_FORMAT = "CREATE TABLE IF NOT EXISTS %s (id INT PRIMARY KEY AUTO_INCREMENT, %s)";
    private static final String GET_ALL_COLUMN_BY_TABLE_NAME = "SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS`" +
            "WHERE `TABLE_SCHEMA` = 'soft_uni' AND `COLUMN_NAME` != 'id' AND `TABLE_NAME` = ?";

    private static final String ADD_COLUMN_FORMAT = "ADD COLUMN %s %s";

    private static final String ALTER_TABLE_FORMAT = "ALTER TABLE %s %s";


    @Override
    public boolean persist(E entity) throws SQLException, IllegalAccessException {
        String tableName = this.getTableName(entity.getClass());
        String fieldList = this.getDBFieldsWithoutId(entity);
        String valueList = this.getValuesWithoutId(entity);

        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)",
                tableName, fieldList, valueList);

        return this.connection.prepareStatement(sql).execute();

    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, "");
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = this.getTableName(table);

        String sql = String.format("SELECT * FROM %s %s", tableName,
                where.equals("") ? "" : "WHERE " + where);

        ResultSet resultSet = this.connection.prepareStatement(sql).executeQuery();

        List<E> result = new ArrayList<>();

        E entity = this.createEntity(table, resultSet);
        while (entity != null) {
            result.add(entity);
            entity = this.createEntity(table, resultSet);
        }
        return result;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, "");
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = this.getTableName(table);

        String sql = String.format("SELECT * FROM %s %s LIMIT 1", tableName,
                where.equals("") ? "" : "WHERE " + where);

        ResultSet resultSet = this.connection.prepareStatement(sql).executeQuery();


        return this.createEntity(table, resultSet);
    }

    @Override
    public void doCreate(Class<E> entity) throws SQLException {
        String tableName = getTableName(entity);

        List<KeyValuePair> fieldsWithTypes = getAllFieldsAndTypesInKeyValuePairs(entity);

        String fieldsWithTypesFormatted = fieldsWithTypes.stream()
                .map(keyValuePair -> String.format(CREATE_VALUE_FORMAT, keyValuePair.key, keyValuePair.value))
                .collect(Collectors.joining(", "));

        PreparedStatement preparedStatement =
                connection.prepareStatement(String.format(CREATE_QUERY_FORMAT, tableName, fieldsWithTypesFormatted));

        preparedStatement.execute();
    }

    @Override
    public void doAlter(Class<E> entity) throws SQLException {
        String tableName = getTableName(entity);
        String addColumnsStatement = addColumnsStatementForNewFields(entity, tableName);

        String alterQuery = String.format(ALTER_TABLE_FORMAT, tableName, addColumnsStatement);

        PreparedStatement alterStatement = connection.prepareStatement(alterQuery);

        alterStatement.execute();
    }


    private String addColumnsStatementForNewFields(Class<E> entity, String tableName) throws SQLException {
        Set<String> sqlColumns = getSQLColumnNames(entity, tableName);
        List<Field> allFieldsWithoutId = getAllFieldsWithoutId(entity);

        List<String> newFieldStatement = new ArrayList<>();

        for (Field field : allFieldsWithoutId) {
            String fieldName = getSQLColumnName(field);

            if (sqlColumns.contains(fieldName)) {
                continue;
            }
            String sqlType = getSQLType(field.getType());
            String addStatement = String.format(ADD_COLUMN_FORMAT, fieldName, sqlType);
            newFieldStatement.add(addStatement);
        }
        return String.join(", ", newFieldStatement);
    }

    private Set<String> getSQLColumnNames(Class<E> entity, String tableName) throws SQLException {
        Set<String> allFields = new HashSet<>();
        PreparedStatement getAllFieldsStatement = connection.prepareStatement(GET_ALL_COLUMN_BY_TABLE_NAME);
        getAllFieldsStatement.setString(1, tableName);

        ResultSet resultSet = getAllFieldsStatement.executeQuery();

        while (resultSet.next()) {
            allFields.add(resultSet.getString(1));
        }
        return allFields;
    }

    private List<KeyValuePair> getAllFieldsAndTypesInKeyValuePairs(Class<E> entity) {
        return getAllFieldsWithoutId(entity).stream()
                .map(field -> new KeyValuePair(getSQLColumnName(field), getSQLType(field.getType())))
                .toList();

    }

    private String getSQLType(Class<?> type) {
        if (type == Integer.class || type == int.class) {
            return "INT";
        } else if (type == LocalDate.class) {
            return "DATE";
        }

        return "VARCHAR(45)";
    }

    private String getSQLColumnName(Field field) {
        return field.getAnnotationsByType(Column.class)[0].name();
    }

    private List<Field> getAllFieldsWithoutId(Class<E> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(Id.class) &&
                        field.isAnnotationPresent(Column.class))
                .toList();
    }

    private E createEntity(Class<E> table, ResultSet resultSet) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!resultSet.next()) {
            return null;
        }

        E entity = table.getDeclaredConstructor().newInstance();

        Field[] fields = table.getDeclaredFields();
        for (Field field : fields) {

            if (!field.isAnnotationPresent(Column.class) &&
                    !field.isAnnotationPresent(Id.class)) {
                continue;
            }

            Column annotation = field.getAnnotation(Column.class);

            String fieldName = annotation == null ? field.getName() : annotation.name();

            String value = resultSet.getString(fieldName);
            this.fillData(entity, field, value);
        }

        return entity;
    }

    private E fillData(E entity, Field field, String value) throws IllegalAccessException {
        field.setAccessible(true);

        if (field.getType() == long.class || field.getType() == Long.class) {
            field.setLong(entity, Long.parseLong(value));
        } else if (field.getType() == int.class || field.getType() == Integer.class) {
            field.setInt(entity, Integer.parseInt(value));
        } else if (field.getType() == LocalDate.class) {
            field.set(entity, LocalDate.parse(value));
        } else if (field.getType() == String.class) {
            field.set(entity, value);
        } else {
            throw new ORMException("Unsupported type " + field.getType());
        }

        return entity;
    }

    private String getTableName(Class<?> clazz) {
        Entity annotation = clazz.getAnnotation(Entity.class);

        if (annotation == null) {
            throw new ORMException("Provided class does not have Entity annotation");
        }

        return annotation.name();
    }

    private String getDBFieldsWithoutId(E entity) {
        return Arrays.stream(entity.getClass()
                        .getDeclaredFields())
                .filter(f -> f.getAnnotation(Column.class) != null)
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));

    }

    private String getValuesWithoutId(E entity) throws IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();

        for (Field field : fields) {
            if (field.getAnnotation(Column.class) == null) {
                continue;
            }

            field.setAccessible(true);
            Object value = field.get(entity);
            result.add("\"" + value.toString() + "\"");
        }
        return String.join(",", result);
    }

    private List<KeyValuePair> getKeyValuePairs(E entity) {
        Class<?> aClass = entity.getClass();

        return Arrays.stream(aClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class) && f.isAnnotationPresent(Column.class))
                .map(f -> new KeyValuePair(f.getAnnotationsByType(Column.class)[0].name(),
                        mapFieldsToGivenType(f, entity)))
                .collect(Collectors.toList());
    }

    private String mapFieldsToGivenType(Field field, E entity) {
        field.setAccessible(true);

        Object o = null;

        try {
            o = field.get(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return o instanceof String || o instanceof LocalDate
                ? "'" + o + "'"
                : Objects.requireNonNull(o).toString();
    }

    private record KeyValuePair(String key, String value) {

    }
}
