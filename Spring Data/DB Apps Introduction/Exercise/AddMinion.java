import java.sql.*;
import java.util.Scanner;

public class AddMinion {

    private static final String ADD_VILLAIN = "insert into villains (name, evilness_factor)" +
            " select ?, 'evil' from dual" +
            " where not exists(select * from villains" +
            " where name = ?)";

    private static final String ADD_TOWN = "insert into towns (name, country)" +
            " select ?, null from dual" +
            " where not exists(select * from towns" +
            " where name = ?)";

    private static final String ADD_MINION = "insert into minions (name, age, town_id)" +
            " values (?, ?, ?)";

    private static final String INSERT_INTO_MINIONS_VILLAINS = "insert into minions_villains (minion_id, villain_id)" +
            " values (?, ?)";
    private static final String GET_TOWN_ID = "call usp_get_town_id(?)";
    private static final String GET_VILLAIN_ID = "call usp_get_villain_id(?)";
    private static final String GET_MINION_ID = "call usp_get_minion_id(?)";
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split(" ");
        final String[] villainInfo = scanner.nextLine().split(" ");

        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];
        final String villainName = villainInfo[1];

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement addTown = getPreparedStatement(connection, ADD_TOWN, minionTown);
        if (addTown.executeUpdate() != 0) {
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }

        final PreparedStatement addVillain = getPreparedStatement(connection, ADD_VILLAIN, villainName);
        if (addVillain.executeUpdate() != 0) {
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        final int townId = getId(minionTown, GET_TOWN_ID, connection);
        final PreparedStatement addMinion = getPreparedStatement(connection, ADD_MINION, minionName,
                String.valueOf(minionAge), String.valueOf(townId));
        addMinion.executeUpdate();

        final int minionId = getId(minionName, GET_MINION_ID, connection);
        final int villainId = getId(villainName, GET_VILLAIN_ID, connection);

        final PreparedStatement insertIntoMinionsVillains = getPreparedStatement(connection, INSERT_INTO_MINIONS_VILLAINS,
                String.valueOf(minionId), String.valueOf(villainId));
        insertIntoMinionsVillains.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);


    }

    private static int getId(String s, String prepareStatement, Connection connection) throws SQLException {
        final CallableStatement callableStatement = connection.prepareCall(prepareStatement);
        callableStatement.setString(1, s);
        final ResultSet resultSet = callableStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private static PreparedStatement getPreparedStatement(Connection connection,
                                                          String prepareStatement, String... x) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement(prepareStatement);
        if (prepareStatement.equals(ADD_MINION)) {
            preparedStatement.setString(1, x[0]);
            preparedStatement.setInt(2, Integer.parseInt(x[1]));
            preparedStatement.setInt(3, Integer.parseInt(x[2]));
        } else if (prepareStatement.equals(INSERT_INTO_MINIONS_VILLAINS)){
            preparedStatement.setInt(1, Integer.parseInt(x[0]));
            preparedStatement.setInt(2, Integer.parseInt(x[1]));
        } else {
            preparedStatement.setString(1, x[0]);
            preparedStatement.setString(2, x[0]);

        }
        return preparedStatement;
    }
}
