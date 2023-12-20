package software.ulpgc.Kata3;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BarChartDisplay barChartDisplay;
    public MainFrame() throws HeadlessException {
        setTitle("BarChart");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createBarChartDisplay());
    }

    private Component createBarChartDisplay() {
        JFreeBarChartDisplay display = new JFreeBarChartDisplay();
        barChartDisplay = display;
        return display;
    }

    public BarChartDisplay barChartDisplay() {return barChartDisplay;}
}
