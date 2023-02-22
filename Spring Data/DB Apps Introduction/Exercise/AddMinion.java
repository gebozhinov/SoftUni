import java.sql.*;
import java.util.Scanner;

public class AddMinion {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split(" ");
        final String[] villainInfo = scanner.nextLine().split(" ");

        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];
        final String villainName = villainInfo[1];


        final PreparedStatement addTown = Utils.getPreparedStatement(SQLQuery.ADD_TOWN, minionTown);
        if (addTown.executeUpdate() != 0) {
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }

        final PreparedStatement addVillain = Utils.getPreparedStatement(SQLQuery.ADD_VILLAIN, villainName);
        if (addVillain.executeUpdate() != 0) {
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        final int townId = Utils.getId(minionTown, SQLQuery.GET_TOWN_ID);
        final PreparedStatement addMinion = Utils.getPreparedStatement(SQLQuery.ADD_MINION, minionName,
                String.valueOf(minionAge), String.valueOf(townId));
        addMinion.executeUpdate();

        final int minionId = Utils.getId(minionName, SQLQuery.GET_MINION_ID);
        final int villainId = Utils.getId(villainName, SQLQuery.GET_VILLAIN_ID);

        final PreparedStatement insertIntoMinionsVillains = Utils.getPreparedStatement(SQLQuery.INSERT_INTO_MINIONS_VILLAINS,
                String.valueOf(minionId), String.valueOf(villainId));
        insertIntoMinionsVillains.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

        Utils.closeSQLConnection();

    }

}
