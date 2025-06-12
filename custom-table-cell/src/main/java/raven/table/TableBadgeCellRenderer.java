package raven.table;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableBadgeCellRenderer extends JLabel implements TableCellRenderer {

    private final TableCellRenderer oldCellRenderer;
    private JComponent component;
    private final int fixedWidth;

    private TableBadgeCellRenderer(JTable table) {
        this(table, 0);
    }

    private TableBadgeCellRenderer(JTable table, int fixedWidth) {
        oldCellRenderer = table.getDefaultRenderer(Object.class);
        putClientProperty(FlatClientProperties.STYLE, "" +
                "border:2,5,2,5;");
        this.fixedWidth = fixedWidth;

        if( fixedWidth > 0) {
            // Configure component for better text positioning
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            setHorizontalTextPosition(RIGHT);
            setVerticalTextPosition(CENTER);
            setIconTextGap(UIScale.scale(5));
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent com = (JComponent) oldCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Info) {
            Info info = (Info) value;
            // must fill all info
            setText(info.getText());
            setForeground(info.getColor());
            setIcon(info.getIcon());
            JComponent badge = getComponent();
            badge.setBackground(com.getBackground());
            badge.setBorder(com.getBorder());
            return badge;
        }
        return com;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        if (fixedWidth > 0) {
            size.width = UIScale.scale(fixedWidth);
        }
        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        FlatUIUtils.setRenderingHints(g2);
        Color color = getForeground();
        g2.setColor(color);
        g2.setPaint(new GradientPaint(0, 0, getForeground(), 0, getHeight(), new Color(color.getRed(), color.getGreen(), color.getBlue(), 120)));
        float alpha = getAlpha();
        if (alpha < 1) {
            g2.setComposite(AlphaComposite.SrcOver.derive(getAlpha()));
        }
        float arc = UIScale.scale(getArc());
        FlatUIUtils.paintComponentBackground(g2, 0, 0, getWidth(), getHeight(), 0, arc);
        g2.dispose();
        super.paintComponent(g);
    }

    protected float getArc() {
        return 10f;
    }

    protected float getAlpha() {
        return 0.3f;
    }

    protected LayoutManager getCelLayout() {
        return new MigLayout("insets 0,al center center");
    }

    protected JComponent getComponent() {
        if (component == null) {
            component = new JPanel(getCelLayout());
            component.add(this);
        }
        return component;
    }

    public static void apply(JTable table, Class<?> clazz) {
        table.setDefaultRenderer(clazz, new TableBadgeCellRenderer(table));
    }

    public static void apply(JTable table, Class<?> clazz, int fixedWidth) {
        table.setDefaultRenderer(clazz, new TableBadgeCellRenderer(table, fixedWidth));
    }

    public interface Info {

        String getText();

        Color getColor();

        Icon getIcon();
    }
}