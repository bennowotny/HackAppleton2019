import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.security.cert.TrustAnchor;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Runnable {
    //Make a GUI with a frame with a panel. The panel can hold one row and two columns
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel(new GridLayout(1,2));

    public static JFreeChart graph(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i = 0; i < 0; i++){
           // line_chart_dataset.addValue( 15 , "schools" , "1970" );
        }
         JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Total Sales","Month",
                "Sales",
                dataset,PlotOrientation.VERTICAL,
                true,true,false);

        return lineChartObject;

    }

    public static void main(String[] args) {

        //Gets the path of certain database of Transactions
        String path = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "txt", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(panel);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           path = chooser.getSelectedFile().toString();
           System.out.println(path);
        }

        //Add the names of the items to the JList and add a listener that will change the graph
        //when you select a new item
        String[] data = {"Apple","Banana","Chocolate","Dairy","EMP"};
        JList<String> list = new JList<String>(data);
        JScrollPane scroll = new JScrollPane(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selection = list.getSelectedIndex();
                if(selection==2) {
                    panel.remove(1);
                    panel.add(new ChartPanel(graph()));
                    panel.validate();
                }
            }
        });

        //Add the scroll bar with the list of items and a picture of the Kwik Trip logo to the GUI.
        //Then set the size and position of the frame
        panel.add(scroll);
        JLabel pic = new JLabel(new ImageIcon("\\C:\\Users\\kungl\\Pictures\\kwik.png"));
        panel.add(pic);
        frame.setSize(500,500);
        frame.setLocation(800,500);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
