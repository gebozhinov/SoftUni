import java.sql.*;
import java.util.Scanner;

public class GetVillainsNames {

    private static final String GET_VILLAINS_NAMES = "select concat(name,' ', count(distinct mv.minion_id)) as output from villains" +
            " join minions_villains mv on villains.id = mv.villain_id" +
            " group by villains.name" +
            " having count(distinct mv.minion_id) > ?" +
            " order by count(distinct mv.minion_id) desc";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement preparedStatement =
                connection.prepareStatement(GET_VILLAINS_NAMES);

        System.out.println("Get only the villains who have more than N minions.");
        System.out.print("Enter the number of minions: ");
        int minions = scanner.nextInt();

        preparedStatement.setInt(1, minions);

        final ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("output"));
        }

        connection.close();
    }
}