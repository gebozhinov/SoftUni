import java.sql.*;
import java.util.Properties;

public class Utils {


    private static Connection getSQLConnection() throws SQLException {
        final Properties properties = new Properties();
        properties.setProperty(Constants.USER_KEY, Constants.USER_VALUE);
        properties.setProperty(Constants.PASSWORD_KEY, Constants.PASSWORD_VALUE);

        return DriverManager.getConnection(Constants.JDBC_URL, properties);
    }

    static void closeSQLConnection() throws SQLException {
        getSQLConnection().close();
    }

    static PreparedStatement getPreparedStatement(String prepareStatement, String... x) throws SQLException {
        Connection connection = getSQLConnection();

        final PreparedStatement preparedStatement = connection.prepareStatement(prepareStatement);

        switch (prepareStatement) {
            case SQLQuery.ADD_MINION -> {
                preparedStatement.setString(1, x[0]);
                preparedStatement.setInt(2, Integer.parseInt(x[1]));
                preparedStatement.setInt(3, Integer.parseInt(x[2]));
            }
            case SQLQuery.INSERT_INTO_MINIONS_VILLAINS -> {
                preparedStatement.setInt(1, Integer.parseInt(x[0]));
                preparedStatement.setInt(2, Integer.parseInt(x[1]));
            }
            case SQLQuery.CHANGE_TOWN_NAMES,
                    SQLQuery.GET_COUNT_OF_TOWNS,
                    SQLQuery.GET_FORMATTED_TOWN_NAMES -> preparedStatement.setString(1, x[0]);
            case SQLQuery.GET_COUNT_OF_MINIONS,
                    SQLQuery.GET_VILLAIN_NAME_BY_ID,
                    SQLQuery.DELETE_FROM_MINIONS_VILLAINS_BY_VILLAIN_ID,
                    SQLQuery.DELETE_FROM_VILLAINS_BY_VILLAIN_ID,
                    SQLQuery.GET_VILLAINS_NAMES,
                    SQLQuery.GET_MINIONS_NAMES,
                    SQLQuery.INCREASE_MINION_AGE,
                    SQLQuery.MAKE_MINION_NAME_LOWER_CASE,
                    SQLQuery.GET_OLDER,
                    SQLQuery.GET_MINION_NAME_AND_AGE_BY_GIVEN_ID
                    -> preparedStatement.setInt(1, Integer.parseInt(x[0]));
            case SQLQuery.ADD_TOWN,
                    SQLQuery.ADD_VILLAIN -> {
                preparedStatement.setString(1, x[0]);
                preparedStatement.setString(2, x[0]);
            }


        }
        return preparedStatement;
    }

    static int getId(String s, String prepareStatement) throws SQLException {
        Connection connection = getSQLConnection();
        final CallableStatement callableStatement = connection.prepareCall(prepareStatement);
        callableStatement.setString(1, s);
        final ResultSet resultSet = callableStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
}
