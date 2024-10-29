import javax.swing.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TablePanel extends JPanel {

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

        //create sorter for table
        sorter = new TableRowSorter<>(data);
        table = new JTable();

        //add dataModel to table and sorter
        table.setModel(data);
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
                    filters.add(RowFilter.regexFilter("196[0-9]", 0)); // Column index 1 for Year
                }
                if (seventiesCheckBox.isSelected()) {
                    filters.add(RowFilter.regexFilter("197[0-9]", 0));
                }
                if (eightiesCheckBox.isSelected()) {
                    filters.add(RowFilter.regexFilter("198[0-9]", 0));
                }
                if (ninetiesCheckBox.isSelected()) {
                    filters.add(RowFilter.regexFilter("199[0-9]", 0));
                }
                if (twoKCheckBox.isSelected()) {
                    filters.add(RowFilter.regexFilter("200[0-9]", 0));
                }
                if (tensCheckBox.isSelected()) {
                    filters.add(RowFilter.regexFilter("201[0-9]", 0));
                }
                if (twentiesCheckBox.isSelected()) {
                    filters.add(RowFilter.regexFilter("202[0-9]", 0));
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
        //sum of column values
        int count = 0;
        float sum1 = 0.0f;
        float sum2 = 0.0f;
        float sum3 = 0.0f;
        float sum4 = 0.0f;
        float sum5 = 0.0f;
        float sum6 = 0.0f;
        float sum7 = 0.0f;
        float sum8 = 0.0f;
        float sum9 = 0.0f;
        float sum10 = 0.0f;
        float sum11 = 0.0f;
        float sum12 = 0.0f;
        float sum13 = 0.0f;

        //stores column data into corresponding values
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            int modelRow = sorter.convertRowIndexToModel(rowIndex);
            Object value1 = data.getValueAt(modelRow, 1);
            Object value2 = data.getValueAt(modelRow, 2);
            Object value3 = data.getValueAt(modelRow, 3);
            Object value4 = data.getValueAt(modelRow, 4);
            Object value5 = data.getValueAt(modelRow, 5);
            Object value6 = data.getValueAt(modelRow, 6);
            Object value7 = data.getValueAt(modelRow, 7);
            Object value8 = data.getValueAt(modelRow, 8);
            Object value9 = data.getValueAt(modelRow, 9);
            Object value10 = data.getValueAt(modelRow, 10);
            Object value11 = data.getValueAt(modelRow, 11);
            Object value12 = data.getValueAt(modelRow, 12);

            if (value1 instanceof Number) {
                sum1 += ((Number) value1).floatValue();
            }
            if (value2 instanceof Number) {
                sum2 += ((Number) value2).floatValue();
            }
            if (value3 instanceof Number) {
                sum3 += ((Number) value3).floatValue();
            }
            if (value4 instanceof Number) {
                sum4 += ((Number) value4).floatValue();
            }
            if (value5 instanceof Number) {
                sum5 += ((Number) value5).floatValue();
            }
            if (value6 instanceof Number) {
                sum6 += ((Number) value6).floatValue();
            }
            if (value7 instanceof Number) {
                sum7 += ((Number) value7).floatValue();
            }
            if (value8 instanceof Number) {
                sum8 += ((Number) value8).floatValue();
            }
            if (value9 instanceof Number) {
                sum9 += ((Number) value9).floatValue();
            }
            if (value10 instanceof Number) {
                sum10 += ((Number) value10).floatValue();
            }
            if (value11 instanceof Number) {
                sum11 += ((Number) value11).floatValue();
            }
            if (value12 instanceof Number) {
                sum12 += ((Number) value12).floatValue();
                count++;
            }

        }

        //calculate averages
        double average1 = (count > 0) ? sum1 / count : 0;
        double average2 = (count > 0) ? sum2 / count : 0;
        double average3 = (count > 0) ? sum3 / count : 0;
        double average4 = (count > 0) ? sum4 / count : 0;
        double average5 = (count > 0) ? sum5 / count : 0;
        double average6 = (count > 0) ? sum6 / count : 0;
        double average7 = (count > 0) ? sum7 / count : 0;
        double average8 = (count > 0) ? sum8 / count : 0;
        double average9 = (count > 0) ? sum9 / count : 0;
        double average10 = (count > 0) ? sum10 / count : 0;
        double average11 = (count > 0) ? sum11 / count : 0;
        double average12 = (count > 0) ? sum12 / count : 0;
        double average13 = (count > 0) ? sum13 / count : 0;

        // Update the average in the stats panel
        statsPanel.updateAverage(average1,
                                 average2,
                                 average3,
                                 average4,
                                 average5,
                                 average6,
                                 average7,
                                 average8,
                                 average9,
                                 average10,
                                 average11,
                                 average12,
                                 average13);
    }
}
