package raven;

import com.formdev.flatlaf.FlatClientProperties;
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

        JPasswordField txtPass = new JPasswordField();
        txtPass.putClientProperty(FlatClientProperties.STYLE, "" +
                "showRevealButton:true;");


        add(txtPass, "width 250");

        add(new JButton("Login") {
            @Override
            public boolean isDefaultButton() {
                return true;
            }
        }, "width 250");
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        FlatDarculaLaf.setup();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}
