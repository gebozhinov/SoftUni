import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionsNames {

    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter villain ID ");
        final int villainId = scanner.nextInt();
        final PreparedStatement villainStatement =
                Utils.getPreparedStatement(SQLQuery.GET_VILLAIN_NAME_BY_ID, String.valueOf(villainId));
        villainStatement.setInt(1, villainId);
        final ResultSet villainSet = villainStatement.executeQuery();
        if (villainSet.next()) {
            System.out.println("Villain: " + villainSet.getString(COLUMN_LABEL_NAME));
        } else {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            Utils.closeSQLConnection();
            return;
        }

        final PreparedStatement minionsStatement =
                Utils.getPreparedStatement(SQLQuery.GET_MINIONS_NAMES, String.valueOf(villainId));
        minionsStatement.setInt(1, villainId);

        final ResultSet minionsSet = minionsStatement.executeQuery();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; minionsSet.next(); i++) {
            sb.append(i).append(". ")
                    .append(minionsSet.getString(COLUMN_LABEL_NAME))
                    .append(" ")
                    .append(minionsSet.getString(COLUMN_LABEL_AGE))
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());

        Utils.closeSQLConnection();
    }
}
