import java.io.IOException;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException {
       //read in and store data into usable format
        ReadFile readFile = new ReadFile("src/USC00033821.csv");
        readFile.setCategories();
       List<Integer>[] dataCategories = readFile.getDataCatergories();

       //create frame
       JFrame frame = new JFrame("Weather Stats for Keiser, AR");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
       frame.getContentPane().setBackground(Color.gray);
       frame.setPreferredSize(new Dimension(800, 1600));

       //create background panel
       BackPanel backPanel = new BackPanel();

       //conversion of data from 1d array into 2d array for the table
       Integer[][] newArray = Array2DConverter.convertArrayOfArraysTo2D(dataCategories);

       //create data model
       DataModel dataModel = new DataModel();
       //pass in 2D array into data model
       dataModel.setDataArray(newArray);
       dataModel.setDataModel();

       //add background panel
       frame.getContentPane().add(backPanel);

       //create stats panel and detail panel
       StatsPanel statsPanel = new StatsPanel(newArray);
       DetailPanel detailPanel = new DetailPanel();

       //create table panel
       TablePanel tablePanel = new TablePanel(dataModel, statsPanel, detailPanel);

       //set filters for table
       tablePanel.setFilters();

       //add panels to background panel
       backPanel.add(tablePanel);
       backPanel.add(statsPanel);
       backPanel.add(detailPanel);

       //pack content and make frame visible
       frame.pack();
       frame.setVisible(true);
    }
}