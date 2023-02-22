import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final int[] minionsIds = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int minionsId : minionsIds) {
            final PreparedStatement increaseMinionAgeStatement =
                    Utils.getPreparedStatement(SQLQuery.INCREASE_MINION_AGE, String.valueOf(minionsId));
            increaseMinionAgeStatement.executeQuery();

            final PreparedStatement makeMinionNameLowerCaseStatement =
                    Utils.getPreparedStatement(SQLQuery.MAKE_MINION_NAME_LOWER_CASE, String.valueOf(minionsId));
            makeMinionNameLowerCaseStatement.executeQuery();

        }

        final PreparedStatement getMinionNameAndAge = Utils.getPreparedStatement(SQLQuery.GET_MINION_NAME_AND_AGE);
        ResultSet minionNamesAndAge = getMinionNameAndAge.executeQuery();
        while (minionNamesAndAge.next()) {
            System.out.println(minionNamesAndAge.getString("output"));
        }

        Utils.closeSQLConnection();
    }
}
