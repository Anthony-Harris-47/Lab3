import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class TablePanel extends JPanel {

    JScrollPane scrollPane;
    JTable table;
    JPanel filterPanel;
    JCheckBox[] filters;

    public TablePanel(TableModel data) {
        setBackground(Color.black);
        setPreferredSize(new Dimension(500,800));

        filterPanel = new JPanel();
        filterPanel.setBackground(Color.gray);
        filterPanel.setPreferredSize(new Dimension(1380,80));

        table = new JTable();
        table.setModel(data);

        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1380,490));
        table.setFillsViewportHeight(true);

        add(filterPanel);
        add(scrollPane);

        this.setVisible(true);
    }
}
