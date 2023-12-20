package software.ulpgc.Kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataBaseRegisterLoader implements RegisterLoader{

    private final Connection connection;

    private final String query = "SELECT cpuName, Price, Cores, Category";

    public DataBaseRegisterLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Register> loadAll() {
        try {
            return load(resultSetOf(query));
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    private List<Register> load(ResultSet resultSet) throws SQLException {
        List<Register> result = new ArrayList<>();
        while(resultSet.next()) result.add(RegisterFrom(resultSet));
        return result;
    }

    private Register RegisterFrom(ResultSet resultSet) throws SQLException {
        return new Register(
                resultSet.getString("cpuName"),
                resultSet.getDouble("Price"),
                resultSet.getInt("Cores"),
                resultSet.getString("Category"));
    }

    private ResultSet resultSetOf(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }
}
