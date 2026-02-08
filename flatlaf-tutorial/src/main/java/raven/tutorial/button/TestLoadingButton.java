package raven.tutorial.button;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import net.miginfocom.swing.MigLayout;
import raven.tutorial.loading.LoadingButton;

import javax.swing.*;
import java.awt.*;

public class TestLoadingButton extends JFrame {

    public TestLoadingButton() {
        setTitle("Test Loading Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        add(createComponent());
    }

    protected JPanel createComponent() {
        JPanel panel = new JPanel(new MigLayout("al center center, wrap 3", "[fill,center]"));

        LoadingButton cmdNeutral = new LoadingButton("Send Request", new FlatSVGIcon("raven/tutorial/icon/send.svg", 0.8f));
        LoadingButton cmdSuccess = new LoadingButton("Send Request", new FlatSVGIcon("raven/tutorial/icon/call.svg", 0.8f));
        LoadingButton cmdDanger = new LoadingButton("Send Request", new FlatSVGIcon("raven/tutorial/icon/fingerprint.svg", 0.8f));

        initEvent(cmdNeutral);
        initEvent(cmdSuccess);
        initEvent(cmdDanger);

        cmdNeutral.putClientProperty(FlatClientProperties.STYLE_CLASS, "neutral");
        cmdSuccess.putClientProperty(FlatClientProperties.STYLE_CLASS, "success");
        cmdDanger.putClientProperty(FlatClientProperties.STYLE_CLASS, "danger");

        panel.add(cmdNeutral);
        panel.add(cmdSuccess);
        panel.add(cmdDanger);

        return panel;
    }

    private void initEvent(LoadingButton button) {
        button.addActionListener(e -> {
            if (button.isLoading()) {
                button.setLoading(false, "Send Request");
            } else {
                button.setLoading(true, "Cancel Request");
            }
        });
    }

    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("raven.tutorial.themes");
        FlatMacDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new TestLoadingButton().setVisible(true));
    }
}
