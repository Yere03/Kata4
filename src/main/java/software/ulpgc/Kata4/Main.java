package software.ulpgc.Kata4;

import software.ulpgc.Kata3.MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/bd_kata4.db")) {
            DataBaseRegisterLoader loader = new DataBaseRegisterLoader(connection);
            List<Register> registers = loader.loadAll();
            Map<Integer, Integer> BarChartData = new DataBaseRegisterProcessor().process(registers);
            MainFrame frame = new MainFrame();
            frame.barChartDisplay().show(BarChartData);
            frame.setVisible(true);
        }
    }
}
