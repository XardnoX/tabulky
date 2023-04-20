import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTable extends AbstractTableModel {
    private final Map<Integer, String> columnMap = new HashMap<>();
    private List<Deskovka> data;
    public DataTable(){ data = new ArrayList<>();}
    public DataTable addColumn(int columnIndex, String columnName){
        columnMap.put(columnIndex, columnName);
        return this;
    }
    public void update() {
        fireTableDataChanged();
    }

    public DataTable loadData(List<Deskovka> data) {
        if(data == null) return this;
        this.data = data;
        return this;
    }

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnMap.getOrDefault(column, "Error");
    }

    @Override
    public int getColumnCount() {
        return columnMap.keySet().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data == null) {
            return "Test1";
        }
    Deskovka deskovka = data.get(rowIndex);
        if(deskovka == null){
            return "TEST";
        }
        return switch (columnIndex){
            case 0 -> deskovka.toString();
            case 1 -> deskovka.getBought() ? "Yes" : "No";
            case 2 -> deskovka.getRating();
            default ->  throw new IllegalStateException("neočekávaná hodnota: " + columnIndex);
        };
    }

}

