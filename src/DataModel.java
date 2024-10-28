import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataModel implements TableModel {
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


    public void setDataArray (Integer[][] dataArray) {
        listeners = new ArrayList<>();
        data = dataArray;
    }

    public void setDataModel () {
        columnCount = columnNames.length;
        rowCount = data.length;
    }

    ArrayList<TableModelListener> listeners;
    public void getData(List<Integer> weatherData){

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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}
