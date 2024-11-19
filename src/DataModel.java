import ObserverPattern.DataListener;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class DataModel extends AbstractTableModel {
    //list of data listeners that will listen to DataModel
    private List<DataListener> listeners = new ArrayList<>();
    int rowCount;
    int columnCount;
    Object[][] data;

    final String[] columnNames = {
            "Date",
            "Days w/ 0.01 Inch Prec",
            "Days w/ 0.10 Inch Prec",
            "Days w/ 1 Inch Prec",
            "Days w/ 1 Inch Snow Depth",
            "Days w/ 1 Inch Snow Fall",
            "Days w/ Min temp > 0",
            "Days w/ Min temp > 32",
            "Days w/ Max temp > 32",
            "Days w/ Max temp > 70",
            "Days w/ Min temp > 90",
            "Days w/ Fog",
            "Days w/ Heavy Fog",
            "Days w/ 1+ Storms"
    };

    //add listener to list of data listeners
    public void addListener(DataListener listener) {
        listeners.add(listener);
    }

    //iterate over all listeners and call dataChange method to notify
    private void notifyListeners() {
        for (DataListener listener : listeners) {
            listener.dataChange();
        }
    }

    //refresh display on data change
    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
        notifyListeners();
    }


    public void setDataArray (Integer[][] dataArray) {
        listeners = new ArrayList<>();
        data = dataArray;
    }

    public void setDataModel () {
        columnCount = columnNames.length;
        rowCount = data.length;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}
