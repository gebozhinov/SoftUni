import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionsNames {

    private static final String GET_VILLAIN_NAME = "select name from villains" +
            " where id = ?";

    private static final String GET_MINIONS_NAMES = "select m.name, m.age from minions m" +
            " join minions_villains mv on m.id = mv.minion_id" +
            " join villains v on v.id = mv.villain_id" +
            " where v.id = ?";

    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAIN_NAME);

        System.out.print("Enter villain ID ");
        final int villainId = scanner.nextInt();
        villainStatement.setInt(1, villainId);

        final ResultSet villainSet = villainStatement.executeQuery();
        if (villainSet.next()) {
            System.out.println("Villain: " + villainSet.getString(COLUMN_LABEL_NAME));
        } else {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            connection.close();
            return;
        }

        final PreparedStatement minionsStatement = connection.prepareStatement(GET_MINIONS_NAMES);
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

        connection.close();
    }
}
