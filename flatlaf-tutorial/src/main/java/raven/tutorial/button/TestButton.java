package raven.tutorial.button;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class TestButton extends JFrame {

    public TestButton() {
        setTitle("Test Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        add(createComponent());
    }

    protected JPanel createComponent() {
        JPanel panel = new JPanel(new MigLayout("al center center, wrap 3", "[fill,center]"));

        JButton cmdNeutral = new JButton("Neutral Button");
        JButton cmdPrimary = new JButton("Primary Button");
        JButton cmdSecondary = new JButton("Secondary Button");
        JButton cmdInfo = new JButton("Info Button");
        JButton cmdSuccess = new JButton("Success Button");
        JButton cmdWarning = new JButton("Warning Button");
        JButton cmdDanger = new JButton("Danger Button");
        JButton cmdGhost = new JButton("Ghost Button");

        cmdNeutral.putClientProperty(FlatClientProperties.STYLE_CLASS, "neutral");
        cmdPrimary.putClientProperty(FlatClientProperties.STYLE_CLASS, "primary");
        cmdSecondary.putClientProperty(FlatClientProperties.STYLE_CLASS, "secondary");
        cmdInfo.putClientProperty(FlatClientProperties.STYLE_CLASS, "info");
        cmdSuccess.putClientProperty(FlatClientProperties.STYLE_CLASS, "success");
        cmdWarning.putClientProperty(FlatClientProperties.STYLE_CLASS, "warning");
        cmdDanger.putClientProperty(FlatClientProperties.STYLE_CLASS, "danger");
        cmdGhost.putClientProperty(FlatClientProperties.STYLE_CLASS, "ghost");

        panel.add(cmdNeutral);
        panel.add(cmdPrimary);
        panel.add(cmdSecondary);
        panel.add(cmdInfo);
        panel.add(cmdSuccess);
        panel.add(cmdWarning);
        panel.add(cmdDanger);
        panel.add(cmdGhost);

        return panel;
    }

    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("raven.tutorial.themes");
        FlatMacDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new TestButton().setVisible(true));
    }
}
