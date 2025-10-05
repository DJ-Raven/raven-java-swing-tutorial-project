package raven.tutorial;

import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import net.miginfocom.swing.MigLayout;
import raven.extras.pagination.Pagination;
import raven.tutorial.connection.DatabaseConnection;
import raven.tutorial.data.ModelCustomer;
import raven.tutorial.data.ServiceCustomer;
import raven.tutorial.pagination.PaginationAnimation;
import raven.tutorial.pagination.ResponsePageable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;

public class Main extends JFrame {

    private ServiceCustomer serviceCustomer;
    private JTable table;
    private Pagination pagination;
    private JLabel lbTotalRecord;

    public Main() {
        super("Pagination Tutorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        init();

        try {
            DatabaseConnection.getInstance().connectToDatabase();
            serviceCustomer = new ServiceCustomer();
            loadDate(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDate(int page) {
        try {
            ResponsePageable<List<ModelCustomer>> response = serviceCustomer.getAll(page);
            pagination.setPageRange(response.getPage(), response.getPageSize());
            lbTotalRecord.setText(NumberFormat.getNumberInstance().format(response.getTotal()));
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int row = (response.getPage() - 1) * response.getLimit() + 1;
            for (ModelCustomer d : response.getData()) {
                model.addRow(d.toTableRow(row++));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        JPanel panel = new JPanel(new MigLayout("insets 20,fill,wrap 1", "[fill]", "[fill][grow 0]"));
        table = new JTable(new DefaultTableModel(new Object[]{"No", "First Name", "Last Name", "Company", "City", "Country", "Email", "Subscription Date", "Website"}, 0));

        panel.add(new JScrollPane(table));

        // create pagination
        JPanel panelPage = new JPanel(new MigLayout("fillx", "[][]push[]"));

        pagination = new PaginationAnimation(1, 50);

        pagination.addChangeListener(e -> loadDate(pagination.getSelectedPage()));
        lbTotalRecord = new JLabel("0");

        panelPage.add(new JLabel("Total Record:"));
        panelPage.add(lbTotalRecord);
        panelPage.add(pagination);

        panel.add(panelPage);
        add(panel);
    }

    public static void main(String[] args) {
        FlatGruvboxDarkHardIJTheme.setup();
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
