package raven.combobox;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.icons.FlatCheckBoxIcon;
import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.ComboPopup;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author RAVEN
 * @param <E>
 */
public class ComboBoxMultiSelection<E> extends JComboBox<E> {

    public List<Object> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Object> selectedItems) {
        List<Object> comboItem = new ArrayList<>();
        int count = getItemCount();
        for (int i = 0; i < count; i++) {
            comboItem.add(getItemAt(i));
        }
        for (Object obj : selectedItems) {
            if (comboItem.contains(obj)) {
                addItemObject(obj);
            }
        }
        comboItem.clear();
    }

    public void clearSelectedItems() {
        selectedItems.clear();
        Component editorCom = getEditor().getEditorComponent();
        if (editorCom instanceof JScrollPane) {
            JScrollPane scroll = (JScrollPane) editorCom;
            JPanel panel = (JPanel) scroll.getViewport().getComponent(0);
            panel.removeAll();
            revalidate();
            repaint();
            comboList.repaint();
        }
    }

    private final List<Object> selectedItems = new ArrayList<>();
    private final ComboBoxMultiCellEditor comboBoxMultiCellEditor;
    private Component comboList;

    private void removeItemObject(Object obj) {
        selectedItems.remove(obj);
        comboBoxMultiCellEditor.removeItem(obj);
        if (comboList != null) {
            comboList.repaint();
        }
    }

    private void addItemObject(Object obj) {
        selectedItems.add(obj);
        comboBoxMultiCellEditor.addItem(obj);
        if (comboList != null) {
            comboList.repaint();
        }
    }

    public ComboBoxMultiSelection() {
        setUI(new ComboBoxMultiUI());
        comboBoxMultiCellEditor = new ComboBoxMultiCellEditor();
        setRenderer(new ComboBoxMultiCellRenderer());
        setEditor(comboBoxMultiCellEditor);
        setEditable(true);
        addActionListener((e) -> {
            if (e.getModifiers() == ActionEvent.MOUSE_EVENT_MASK) {
                JComboBox combo = (JComboBox) e.getSource();
                Object obj = combo.getSelectedItem();
                if (selectedItems.contains(obj)) {
                    removeItemObject(obj);
                } else {
                    addItemObject(obj);
                }
            }
        });
    }

    @Override
    public void setPopupVisible(boolean v) {

    }

    private class ComboBoxMultiUI extends FlatComboBoxUI {

        @Override
        protected ComboPopup createPopup() {
            return new MultiComboPopup(comboBox);
        }

        private class MultiComboPopup extends FlatComboPopup {

            public MultiComboPopup(JComboBox combo) {
                super(combo);
            }
        }

        @Override
        protected Dimension getDisplaySize() {
            Dimension size = super.getDefaultSize();
            return new Dimension(0, size.height);
        }
    }

    private class ComboBoxMultiCellRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (comboList != list) {
                comboList = list;
            }
            setIcon(new CheckBoxIcon(selectedItems.contains(value)));
            return this;
        }
    }

    private class ComboBoxMultiCellEditor extends BasicComboBoxEditor {

        protected final JScrollPane scroll;
        protected final JPanel panel;

        protected void addItem(Object obj) {
            Item item = new Item(obj);
            panel.add(item);
            panel.repaint();
            panel.revalidate();
        }

        protected void removeItem(Object obj) {
            int count = panel.getComponentCount();
            for (int i = 0; i < count; i++) {
                Item item = (Item) panel.getComponent(i);
                if (item.getItem() == obj) {
                    panel.remove(i);
                    panel.revalidate();
                    panel.repaint();
                    break;
                }
            }
        }

        public ComboBoxMultiCellEditor() {
            this.panel = new JPanel(new MigLayout("insets 0,filly,gapx 2", "", "fill"));
            this.scroll = new JScrollPane(panel);
            scroll.putClientProperty(FlatClientProperties.STYLE, ""
                    + "border:2,2,2,2;"
                    + "background:$ComboBox.editableBackground");
            panel.putClientProperty(FlatClientProperties.STYLE, ""
                    + "background:$ComboBox.editableBackground");
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            JScrollBar scrollBar = scroll.getHorizontalScrollBar();
            scrollBar.putClientProperty(FlatClientProperties.STYLE, ""
                    + "width:3;"
                    + "thumbInsets:0,0,0,1;"
                    + "hoverTrackColor:null");
            scrollBar.setUnitIncrement(10);

        }

        @Override
        public Component getEditorComponent() {
            return scroll;
        }

    }

    private class CheckBoxIcon extends FlatCheckBoxIcon {

        private final boolean selected;

        public CheckBoxIcon(boolean selected) {
            this.selected = selected;
        }

        @Override
        protected boolean isSelected(Component c) {
            return selected;
        }
    }

    private class Item extends JLabel {

        public Object getItem() {
            return item;
        }

        private final Object item;

        public Item(Object item) {
            super(item.toString());
            this.item = item;
            init();
        }

        private void init() {
            putClientProperty(FlatClientProperties.STYLE, ""
                    + "border:0,5,0,20;"
                    + "background:darken($ComboBox.background,10%)");
            JButton cmd = new JButton(new FlatSVGIcon("raven/combobox/close.svg", 0.6f));
            cmd.putClientProperty(FlatClientProperties.STYLE, ""
                    + "arc:999;"
                    + "margin:1,1,1,1;"
                    + "background:null;"
                    + "focusWidth:0");
            cmd.addActionListener((e) -> {
                removeItemObject(item);
            });
            cmd.setFocusable(false);
            setLayout(new MigLayout("fill"));
            add(cmd, "pos 1al 0.5al 10 10");
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            FlatUIUtils.setRenderingHints(g2);
            int arc = UIScale.scale(10);
            g2.setColor(getBackground());
            FlatUIUtils.paintComponentBackground(g2, 0, 0, getWidth(), getHeight(), 0, arc);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
