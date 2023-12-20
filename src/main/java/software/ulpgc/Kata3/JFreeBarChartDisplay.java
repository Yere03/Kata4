package software.ulpgc.Kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class JFreeBarChartDisplay extends JPanel implements BarChartDisplay{
    @Override
    public void show(Map<Integer, Integer> BarChartData) {add(new ChartPanel(chart(dataset(BarChartData))));}

    public JFreeBarChartDisplay() {setLayout(new BorderLayout());}

    private JFreeChart chart(IntervalXYDataset dataset) {
    return ChartFactory.createXYBarChart("NUMBER OF CPUS PER CORES",
            "CORES",
            false,
            "NUMBER OF CPUS",
            dataset);
    }

    private IntervalXYDataset dataset(Map<Integer,Integer> BarChartData) {
        XYSeries serie = new XYSeries("");
        for(int Key: BarChartData.keySet())
            serie.add(Key,BarChartData.get(Key));
        return new XYSeriesCollection(serie);
    }
}
