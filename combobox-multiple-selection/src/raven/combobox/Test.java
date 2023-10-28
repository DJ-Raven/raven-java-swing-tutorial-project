package raven.combobox;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.UIManager;

/**
 *
 * @author Raven
 */
public class Test extends javax.swing.JFrame {

    public Test() {
        initComponents();
        testData(comboBoxMultiSelection1);

        List<Object> list = new ArrayList<>();
        list.add("Mango");
        list.add("Pineapple");
        //comboBoxMultiSelection1.setSelectedItems(list);
    }

    private void testData(JComboBox combo) {
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Blueberry",
            "Kiwi",
            "Mango",
            "Pineapple",
            "Strawberry",
            "Watermelon",
            "Raspberry",
            "Peach",
            "Grapefruit",
            "Lemon",
            "Orange",
            "Apple",
            "Banana",
            "Pear",
            "Cherry",
            "Papaya",
            "Plum",
            "Apricot",
            "Blackberry",
            "Cranberry",
            "Guava",
            "Lime",
            "Lychee",
            "Coconut",
            "Fig",
            "Pomegranate",
            "Avocado",
            "Grape",
            "Cantaloupe",
            "Dragonfruit"
        }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxMultiSelection1 = new raven.combobox.ComboBoxMultiSelection();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(comboBoxMultiSelection1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(comboBoxMultiSelection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(498, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.combobox");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.combobox.ComboBoxMultiSelection comboBoxMultiSelection1;
    // End of variables declaration//GEN-END:variables
}
