import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IncreaseAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minion ID: ");
        final int minionId = scanner.nextInt();

        final PreparedStatement increaseMinionAge =
                Utils.getPreparedStatement(SQLQuery.GET_OLDER, String.valueOf(minionId));
        increaseMinionAge.executeQuery();

        final PreparedStatement getMinionNameAndAge =
                Utils.getPreparedStatement(SQLQuery.GET_MINION_NAME_AND_AGE_BY_GIVEN_ID, String.valueOf(minionId));
        ResultSet minionNameAndAgeSet = getMinionNameAndAge.executeQuery();
        minionNameAndAgeSet.next();
        System.out.println(minionNameAndAgeSet.getString("output"));

        Utils.closeSQLConnection();

    }
}
