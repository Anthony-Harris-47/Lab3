import ObserverPattern.DataListener;
import StrategyPattern.Filters.*;

import javax.swing.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablePanel extends JPanel implements DataListener {
    JScrollPane scrollPane;
    JTable table;
    JPanel filterPanel;
    ArrayList<JCheckBox> filters;
    DataModel data;
    TableRowSorter<DataModel> sorter;
    StatsPanel statsPanel;
    DetailPanel detailPanel;

    public TablePanel(DataModel data, StatsPanel statsPanel, DetailPanel detailPanel) {
        //set size and bg color
        setBackground(Color.black);
        setPreferredSize(new Dimension(1500, 400));

        //set stats and detail panel
        this.statsPanel = statsPanel;
        this.detailPanel = detailPanel;

        //set filter panel size and bg color
        filterPanel = new JPanel();
        filterPanel.setBackground(Color.gray);
        filterPanel.setPreferredSize(new Dimension(1380, 30));

        filters = new ArrayList<>();
        this.data = data;
        this.data.addListener(this);

        //create sorter for table
        sorter = new TableRowSorter<>(data);
        table = new JTable(data);

        //add dataModel to table and sorter
        table.setRowSorter(sorter);

        //set scroll pane size
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1380, 490));
        table.setFillsViewportHeight(true);

        //add filter panel and scroll pane
        add(filterPanel);
        add(scrollPane);

        //action listener to update detail panel
        table.getSelectionModel().addListSelectionListener(e -> updateDetailPanel());
        this.setVisible(true);
    }

    public void updateDetailPanel(){
        //stores which row is selected
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            //uses selected row as index
            int modelRow = table.convertRowIndexToModel(selectedRow);
            //grabs all rain day values from selected rows and combine them into one value
            int sumOfRainDays = (int) data.getValueAt(modelRow, 1) + (int) data.getValueAt(modelRow, 2) + (int) data.getValueAt(modelRow, 3);
            //grabs all snow day values from selected rows and combine them into one value
            int sumOfSnowDays = (int) data.getValueAt(modelRow, 4) + (int) data.getValueAt(modelRow, 5);
            //grabs all for and storm day values from selected rows and combine them into one value
            int sumOfFogOrStormDays = (int) data.getValueAt(modelRow, 11) + (int) data.getValueAt(modelRow, 12) + (int) data.getValueAt(modelRow, 13);

            //convert sum values into a string
            String rain = String.valueOf(sumOfRainDays);
            String snow = String.valueOf(sumOfSnowDays);
            String fogOrStorm = String.valueOf(sumOfFogOrStormDays);

            //update detail panel with values from selected rows
            detailPanel.updateDetails(rain, snow, fogOrStorm);
        }
    }

    public void setFilters() {
        //create decade checkboxes and add them to filters arrayList
        JCheckBox sixtiesCheckBox = new JCheckBox("60's");
        filters.add(sixtiesCheckBox);
        JCheckBox seventiesCheckBox = new JCheckBox("70's");
        filters.add(seventiesCheckBox);
        JCheckBox eightiesCheckBox = new JCheckBox("80's");
        filters.add(eightiesCheckBox);
        JCheckBox ninetiesCheckBox = new JCheckBox("90's");
        filters.add(ninetiesCheckBox);
        JCheckBox twoKCheckBox = new JCheckBox("00's");
        filters.add(twoKCheckBox);
        JCheckBox tensCheckBox = new JCheckBox("10's");
        filters.add(tensCheckBox);
        JCheckBox twentiesCheckBox = new JCheckBox("20's");
        filters.add(twentiesCheckBox);

        //add filters checkboxes to filter panel
        for (JCheckBox filter : filters) {
            filterPanel.add(filter);
        }

        ActionListener filterActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<RowFilter<Object, Object>> filters = new ArrayList<>();

                //checks if check box is selected, if selected display correct decades
                if (sixtiesCheckBox.isSelected()) {
                    filters.add(new SixtiesFilter().getFilter()); // Column index 1 for Year
                }
                if (seventiesCheckBox.isSelected()) {
                    filters.add(new SeventiesFilter().getFilter());
                }
                if (eightiesCheckBox.isSelected()) {
                    filters.add(new EightiesFilter().getFilter());
                }
                if (ninetiesCheckBox.isSelected()) {
                    filters.add(new NinetiesFilter().getFilter());
                }
                if (twoKCheckBox.isSelected()) {
                    filters.add(new TwoKFilter().getFilter());
                }
                if (tensCheckBox.isSelected()) {
                    filters.add(new TensFilter().getFilter());
                }
                if (twentiesCheckBox.isSelected()) {
                    filters.add(new TwentiesFilter().getFilter());
                }

                //allows filters to work while more than one filter selected
                RowFilter<Object, Object> combinedFilter = filters.isEmpty()
                        ? null
                        : RowFilter.orFilter(filters);
                sorter.setRowFilter(combinedFilter);

                updateStatsPanelAverage();
            }
        };

        //adds action listener to filters
        for (JCheckBox filter : filters) {
            filter.addActionListener(filterActionListener);
        }
    }

    private void updateStatsPanelAverage() {
        int count = 0;

        //stores column data into corresponding values
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            int modelRow = sorter.convertRowIndexToModel(rowIndex);

            List<Object> values = new ArrayList<>();
            float[] sums = new float[13];
            double[] averages = new double[13];

            for (int i = 1; i <= 12; i++) {
                values.add(data.getValueAt(modelRow, i));
            }


            for (int i = 0; i < values.size(); i++) {
                Object value = values.get(i);
                if (value instanceof Number) {
                    sums[i] += ((Number) value).floatValue();
                    if (i == 11) {
                        count++;
                    }
                }
            }

            //Calculate averages
            for (int i = 0; i < sums.length; i++) {
                averages[i] = (count > 0) ? sums[i] / count : 0;
            }

            //Update the average in the stats panel
            statsPanel.updateAverage(averages);
        }
    }

    @Override
    public void dataChange() {
        //React to data change
        table.repaint();
    }
}
