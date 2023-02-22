import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int villainId = Integer.parseInt(scanner.nextLine());

        // Get count of Minions by given id of villain
        final PreparedStatement getCountOfMinionsStatement = Utils.getPreparedStatement(SQLQuery.GET_COUNT_OF_MINIONS,
                String.valueOf(villainId));
        ResultSet countOfMinionsSet = getCountOfMinionsStatement.executeQuery();
        countOfMinionsSet.next();
        int countOfMinions = countOfMinionsSet.getInt(1);


        // Get villain name by ID
        final PreparedStatement getVillainNameByIdStatement =
                Utils.getPreparedStatement(SQLQuery.GET_VILLAIN_NAME_BY_ID, String.valueOf(villainId));
        ResultSet villainNameSet = getVillainNameByIdStatement.executeQuery();
        String villainName = null;
        if (villainNameSet.next()) {
            villainName = villainNameSet.getString("name");
            final PreparedStatement deleteMinionsStatement =
                    Utils.getPreparedStatement(SQLQuery.DELETE_FROM_MINIONS_VILLAINS_BY_VILLAIN_ID, String.valueOf(villainId));
            final PreparedStatement deleteVillainStatement = Utils.getPreparedStatement(
                    SQLQuery.DELETE_FROM_VILLAINS_BY_VILLAIN_ID, String.valueOf(villainId));

            deleteMinionsStatement.executeUpdate();
            deleteVillainStatement.executeUpdate();

            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released", countOfMinions);

        } else {
            System.out.println("No such villain was found");
        }

        Utils.closeSQLConnection();
    }
}
