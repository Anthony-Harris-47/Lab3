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

    public TablePanel(DataModel data) {
        setBackground(Color.black);
        setPreferredSize(new Dimension(1500,400));

        filterPanel = new JPanel();
        filterPanel.setBackground(Color.gray);
        filterPanel.setPreferredSize(new Dimension(1380,80));

        filters = new ArrayList<>();

        sorter = new TableRowSorter<>(data);
        table = new JTable();
        table.setModel(data);
        table.setRowSorter(sorter);

        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1380,490));
        table.setFillsViewportHeight(true);

        add(filterPanel);
        add(scrollPane);

        this.setVisible(true);
    }

    public void setFilters(){

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

        for (JCheckBox filter : filters) {
            filterPanel.add(filter);
        }

        ActionListener filterActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<RowFilter<Object, Object>> filters = new ArrayList<>();

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

                RowFilter<Object, Object> combinedFilter = filters.isEmpty()
                        ? null
                        : RowFilter.orFilter(filters);
                sorter.setRowFilter(combinedFilter);
            }
        };

        for (JCheckBox filter : filters) {
            filter.addActionListener(filterActionListener);
        }
    }
}
