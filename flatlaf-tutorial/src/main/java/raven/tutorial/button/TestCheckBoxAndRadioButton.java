package raven.tutorial.button;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;
import raven.tutorial.style.StyleIcon;

import javax.swing.*;
import java.awt.*;

public class TestCheckBoxAndRadioButton extends JFrame {

    public TestCheckBoxAndRadioButton() {
        setTitle("Test CheckBox & RadioButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        add(createComponent());
    }

    protected JPanel createComponent() {
        JPanel panel = new JPanel(new MigLayout("al center center, wrap 4", "[fill,center]"));

        JCheckBox chNeutral = new JCheckBox("Neutral CheckBox");
        JCheckBox chPrimary = new JCheckBox("Primary CheckBox");
        JCheckBox chSecondary = new JCheckBox("Secondary CheckBox");
        JCheckBox chInfo = new JCheckBox("Info CheckBox");
        JCheckBox chSuccess = new JCheckBox("Success CheckBox");
        JCheckBox chWarning = new JCheckBox("Warning CheckBox");
        JCheckBox chDanger = new JCheckBox("Danger CheckBox");
        JCheckBox chGhost = new JCheckBox("Ghost CheckBox");

        JRadioButton raNeutral = new JRadioButton("Neutral RadioButton");
        JRadioButton raPrimary = new JRadioButton("Primary RadioButton");
        JRadioButton raSecondary = new JRadioButton("Secondary RadioButton");
        JRadioButton raInfo = new JRadioButton("Info RadioButton");
        JRadioButton raSuccess = new JRadioButton("Success RadioButton");
        JRadioButton raWarning = new JRadioButton("Warning RadioButton");
        JRadioButton raDanger = new JRadioButton("Danger RadioButton");
        JCheckBox raGhost = new JCheckBox("Ghost RadioButton");

        chNeutral.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.NEUTRAL);
        chPrimary.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.PRIMARY);
        chSecondary.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.SECONDARY);
        chInfo.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.INFO);
        chSuccess.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.SUCCESS);
        chWarning.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.WARNING);
        chDanger.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.DANGER);
        chGhost.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.GHOST);

        raNeutral.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.NEUTRAL);
        raPrimary.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.PRIMARY);
        raSecondary.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.SECONDARY);
        raInfo.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.INFO);
        raSuccess.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.SUCCESS);
        raWarning.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.WARNING);
        raDanger.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.DANGER);
        raGhost.putClientProperty(FlatClientProperties.STYLE_CLASS, StyleIcon.GHOST);

        panel.add(chNeutral);
        panel.add(chPrimary);
        panel.add(chSecondary);
        panel.add(chInfo);
        panel.add(chSuccess);
        panel.add(chWarning);
        panel.add(chDanger);
        panel.add(chGhost);

        panel.add(new JSeparator(), "grow,span 4");

        panel.add(raNeutral);
        panel.add(raPrimary);
        panel.add(raSecondary);
        panel.add(raInfo);
        panel.add(raSuccess);
        panel.add(raWarning);
        panel.add(raDanger);
        panel.add(raGhost);

        return panel;
    }

    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("raven.tutorial.themes");
        FlatMacLightLaf.setup();
        SwingUtilities.invokeLater(() -> new TestCheckBoxAndRadioButton().setVisible(true));
    }
}
