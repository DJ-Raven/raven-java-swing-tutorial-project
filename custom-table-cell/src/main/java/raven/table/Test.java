package raven.table;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Test extends JFrame {

    public Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        setLayout(new MigLayout("fill,wrap", "[fill]", "[fill]"));

        DefaultTableModel model = new DefaultTableModel(new Object[]{"#", "NAME", "LOCATION", "POSITION", "STATUS"}, 0) {

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return StaffStatus.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        JTable table = new JTable(model);

        table.putClientProperty(FlatClientProperties.STYLE, "" +
                "rowHeight:30;" +
                "showHorizontalLines:true;" +
                "showVerticalLines:true;" +
                "intercellSpacing:1,1;");

        TableBadgeCellRenderer.apply(table, StaffStatus.class);

        add(new JScrollPane(table));

        model.addRow(new Object[]{1, "Hannah Scott", "Washington, D.C.", "Business Analyst", StaffStatus.ON_LEAVE});
        model.addRow(new Object[]{2, "Liam Johnson", "New York, NY", "Software Engineer", StaffStatus.ACTIVE});
        model.addRow(new Object[]{3, "Ava Thompson", "Los Angeles, CA", "UX Designer", StaffStatus.INACTIVE});
        model.addRow(new Object[]{4, "Noah Smith", "Chicago, IL", "Data Scientist", StaffStatus.ACTIVE});
        model.addRow(new Object[]{5, "Olivia Brown", "Miami, FL", "HR Manager", StaffStatus.ON_LEAVE});
        model.addRow(new Object[]{6, "William Davis", "Dallas, TX", "Project Manager", StaffStatus.ACTIVE});
        model.addRow(new Object[]{7, "Sophia Wilson", "Seattle, WA", "QA Tester", StaffStatus.INACTIVE});
        model.addRow(new Object[]{8, "James Martinez", "Austin, TX", "DevOps Engineer", StaffStatus.ACTIVE});
        model.addRow(new Object[]{9, "Isabella Anderson", "Boston, MA", "Marketing Lead", StaffStatus.ON_LEAVE});
        model.addRow(new Object[]{10, "Benjamin Taylor", "San Francisco, CA", "Product Owner", StaffStatus.INACTIVE});
    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new Test().setVisible(true));
    }
}
