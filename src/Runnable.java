import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Runnable {
    //
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel(new GridLayout(1,2));


    public static void main(String[] args) throws IOException {

        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        line_chart_dataset.addValue( 15 , "schools" , "1970" );
        line_chart_dataset.addValue( 30 , "schools" , "1980" );
        line_chart_dataset.addValue( 60 , "schools" , "1990" );
        line_chart_dataset.addValue( 120 , "schools" , "2000" );
        line_chart_dataset.addValue( 240 , "schools" , "2010" );
        line_chart_dataset.addValue( 300 , "schools" , "2014" );

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Schools Vs Years","Year",
                "Schools Count",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */




        String[] data = {"A","B","C","D","E"};
        JList<String> list = new JList<String>(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selection = list.getSelectedIndex();
                System.out.println(selection);
                if(selection==2) {
                    panel.remove(1);
                    panel.add(new ChartPanel(lineChartObject));
                    panel.repaint();
                    panel.validate();
                }
            }
        });


        panel.add(list);
        JLabel pic = new JLabel(new ImageIcon("\\C:\\Users\\kungl\\Pictures\\kwik.png"));
        panel.add(pic);
        frame.setSize(500,500);
        frame.setLocation(800,500);
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
