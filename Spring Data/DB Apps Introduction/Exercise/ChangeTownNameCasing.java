import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangeTownNameCasing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final String country = scanner.nextLine();


        final PreparedStatement changeTownNames = Utils.getPreparedStatement(SQLQuery.CHANGE_TOWN_NAMES, country);

        if (changeTownNames.executeUpdate() == 0) {
            System.out.println("No town names were affected.");
        } else {
            final PreparedStatement getCountOfTowns = Utils.getPreparedStatement(SQLQuery.GET_COUNT_OF_TOWNS, country);
            ResultSet countOfTownsSet = getCountOfTowns.executeQuery();
            countOfTownsSet.next();
            System.out.printf("%d town names were affected.%n",countOfTownsSet.getInt(1));

            final PreparedStatement getTowns = Utils.getPreparedStatement(SQLQuery.GET_FORMATTED_TOWN_NAMES, country);
            ResultSet getTownsSet = getTowns.executeQuery();
            getTownsSet.next();
            System.out.println(getTownsSet.getString("country_name"));

        }

        Utils.closeSQLConnection();
    }
}
