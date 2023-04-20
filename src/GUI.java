import javax.swing.*;
import java.util.List;

public class GUI extends JFrame {
    private JButton loadData;
    private JTable tableData;
    private JScrollPane tablePane;
    private JPanel panel;
    private final JFileChooser jFileChooser;
    private DataTable dataTable;


    public GUI(){
            jFileChooser = new JFileChooser(".");
            tableData = new JTable((dataTable));
            loadData.addActionListener(e-> dataTable.loadData(getFileData()).update());
            setVisible(true);
            setContentPane(panel);
            setSize(500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    public List<Deskovka> getFileData(){
        int result = jFileChooser.showOpenDialog(this);
        if(result == JFileChooser.CANCEL_OPTION || result == JFileChooser.ERROR_OPTION){
            System.out.println("špatná možnost!");
            return null;
        }

        panel.remove(loadData);
        return  Scan.loadData((jFileChooser.getSelectedFile()));
    }

    public static void main(String[] args) {
        new GUI();
    }

    private void createUIComponents(){
        dataTable = new DataTable().addColumn(0, "hra")
                .addColumn(1, "zakoupeno")
                .addColumn(2, "hodnocení");
        tableData = new JTable(dataTable);
        tablePane = new JScrollPane(tableData);
        add(tableData);

    }
}
