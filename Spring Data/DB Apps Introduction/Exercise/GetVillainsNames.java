import java.sql.*;
import java.util.Scanner;


public class GetVillainsNames {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Get only the villains who have more than N minions.");
        System.out.print("Enter the number of minions: ");
        int minions = scanner.nextInt();
        final PreparedStatement preparedStatement =
                Utils.getPreparedStatement(SQLQuery.GET_VILLAINS_NAMES, String.valueOf(minions));


        preparedStatement.setInt(1, minions);

        final ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("output"));
        }

        Utils.closeSQLConnection();
    }
}