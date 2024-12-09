package raven;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 800));
        setLocationRelativeTo(null);
        setLayout(new MigLayout("al center center,wrap"));
        add(new JPasswordField(), "w 250");
        add(new JButton("Hello") {
            @Override
            public boolean isDefaultButton() {
                return true;
            }
        }, "w 250");
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        FlatDarculaLaf.setup();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 20));
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}
