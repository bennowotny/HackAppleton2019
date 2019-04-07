import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Runnable {
    //Make a GUI with a frame with a panel. The panel can hold one row and two columns
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel(new GridLayout(1,2));
    static TransactionBook tb = new TransactionBook();


    //This method is used to create a graph for each item
    public static JFreeChart graph(ArrayList<Transaction> tr){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //Looks through the requested array of transactions with a certain item and organizes it by month with sales
        int[] monthlyTotals = new int[12];
        for(int i = 0; i < 12 ; i++){
            for(int j = 0; j < tr.size(); j++) {
                if(tr.get(j).time.month == i+1) monthlyTotals[i]+=tr.get(j).item.quantity;
            }
            dataset.addValue(monthlyTotals[i], "Quantity", (i+1)+"");
        }
        //This creates the graph with labeled X and Y axis
        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Total Sales","Month",
                "Sales",
                dataset,PlotOrientation.VERTICAL,
                true,true,false);

        return lineChartObject;
    }

    public static void main(String[] args) {

        //Gets the path of certain database of Transactions (file1.txt)
        String path = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "txt", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(panel);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            tb.saveTransactions(readFromFile(path));
        }

        //Add the names of the items to the JList that can scroll
        String[] data = tb.getUniqueItems();
        JList<String> list = new JList<String>(data);
        JScrollPane scroll = new JScrollPane(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Creates a listener for each entry that will change the graph to its corresponding picture
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selection = list.getSelectedIndex();
                    panel.remove(1);
                    panel.add(new ChartPanel(graph(tb.getTypedTransactions(data[selection]))));
                    panel.validate();
            }
        });

        //Adds the scroll bar with the list of items and a picture of the Kwik Trip logo to the GUI.
        //Then set the size and position of the frame
        panel.add(scroll);
        JLabel pic = new JLabel(new ImageIcon("\\C:\\Users\\kungl\\IdeaProjects\\HackAppleton2019\\kwik.png"));
        panel.add(pic);
        frame.setSize(800,300);
        frame.setLocation(800,500);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("KwikTrip | KwikStar Product Sales Data Visualization");

    }
    //Reads from the database file
    private static String readFromFile(String filePath){
        String retVal = "";
        try {
            File f = new File(filePath);
            if (!f.exists()) throw new IllegalArgumentException("Not a valid file");
            FileInputStream r = new FileInputStream(f);
            while(r.available() != 0) retVal+=(char)r.read();
            r.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return retVal;
    }

}
