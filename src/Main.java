import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile("src/USC00033821.csv");
        readFile.setCategories();
       List<Integer>[] dataCategories = readFile.getDataCatergories();

       //create frame
       JFrame frame = new JFrame("Weather Stats for Keiser, AR");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
       frame.getContentPane().setBackground(Color.gray);
       frame.setPreferredSize(new Dimension(800, 1600));

       //create back panel
       BackPanel backPanel = new BackPanel();

       //set default size and stuff
       backPanel.setConfig();

       //conversion from 1d array into 2d array for the table
       Integer[][] newArray = Array2DConverter.convertArrayOfArraysTo2D(dataCategories);

        //create data model
       DataModel dataModel = new DataModel();
       dataModel.setDataArray(newArray);
       dataModel.setDataModel();




       //add background panel
       frame.getContentPane().add(backPanel);
       StatsPanel statsPanel = new StatsPanel(newArray);
       DetailPanel detailPanel = new DetailPanel();

       TablePanel tablePanel = new TablePanel(dataModel, statsPanel, detailPanel);
       tablePanel.setFilters();
       backPanel.add(tablePanel);

       backPanel.add(statsPanel);

       //DetailPanel details = new DetailPanel();
       backPanel.add(detailPanel);

        //pack content and make frame visible
       frame.pack();
       frame.setVisible(true);
    }
}