package orm;


import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

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

        E entity =  this.createEntity(table, resultSet);
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
}
