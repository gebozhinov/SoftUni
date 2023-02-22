import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        final PreparedStatement allMinionNamesStatement = Utils.getPreparedStatement(SQLQuery.GET_ALL_MINION_NAMES);
        ResultSet allMinionNamesSet = allMinionNamesStatement.executeQuery();
        List<String> minionNames = new ArrayList<>();
        while (allMinionNamesSet.next()) {
            minionNames.add(allMinionNamesSet.getString("name"));
        }

        for (int i = 0; i < minionNames.size() / 2; i++) {
            for (int j = i; j <= i; j++) {
                System.out.println(minionNames.get(j));
            }
            for (int j = minionNames.size() - i; j >= minionNames.size() - i; j--) {
                System.out.println(minionNames.get(j - 1));
            }
        }
        Utils.closeSQLConnection();
    }
}
