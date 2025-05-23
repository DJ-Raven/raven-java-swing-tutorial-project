package raven.demo;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import raven.modal.component.ModalBorderAction;
import raven.modal.component.SimpleModalBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SimpleMessage extends JComponent {

    public SimpleMessage(Color color) {
        setBackground(color);
        init();
    }

    private void init() {
        setLayout(new MigLayout("nogrid,insets 15,wrap 2,width 600,fillx"));
        add(createLabel("Overall match quality is:", "+5 bold"), "gapx push");
        add(createLabel("Acceptable", "+5 bold", getBackground()), "gapx n push,wrap");
        add(createLabel("Skill Balance:", "+1 bold"), "gapx push");
        add(createLabel("Perfect", "+1 bold", new Color(79, 156, 44)), "gapx n push,wrap");

        add(createPanel(), "grow,wrap,gapy n 10");

        add(createLabel("Decline this match without penalty and queue again:", null), "gapx push");
        JButton cmd = new JButton("QUEUE AGAIN");
        cmd.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:3,10,3,10;" +
                "font:+1;" +
                "focusWidth:1;" +
                "borderWidth:0;" +
                "innerFocusWidth:0;");
        add(cmd, "gapx n push");

        cmd.addActionListener(e -> {
            ModalBorderAction.getModalBorderAction(this).doAction(SimpleModalBorder.OK_OPTION);
        });
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new MigLayout("insets 10,fillx,wrap", "[center][grow 0][center][grow 0][center]"));
        panel.setOpaque(false);
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "border:1,1,1,1,fade($Separator.foreground,30%);");

        panel.add(createLabel("REGION", "bold"));
        panel.add(createSeparator(), "span 1 2,grow");
        panel.add(createLabel("SKILL RANGE", "bold"));
        panel.add(createSeparator(), "span 1 2,grow");
        panel.add(createLabel("BEHAVIOR", "bold"));

        panel.add(createLabel("Europe West - 115ms ping", null));
        panel.add(createLabel("All Players:", null), "split 2");
        panel.add(createLabel("Very Close", "bold", new Color(79, 156, 44)));

        panel.add(createLabel("All Players:", null), "split 2");
        panel.add(createLabel("Disruptive", "bold", new Color(227, 72, 72)));

        return panel;
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator(JSeparator.VERTICAL);
        separator.putClientProperty(FlatClientProperties.STYLE, "" +
                "foreground:fade($Separator.foreground,30%);");
        return separator;
    }

    private JLabel createLabel(String text, String font) {
        return createLabel(text, font, null);
    }

    private JLabel createLabel(String text, String font, Color color) {
        JLabel label = new JLabel(text);
        if (font != null) {
            label.putClientProperty(FlatClientProperties.STYLE, "" +
                    "font:" + font + ";");
        }
        if (color != null) {
            label.setForeground(color);
        }
        return label;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Color color1 = getBackground();

        // create alpha 0 color from color 1
        Color color2 = new Color(color1.getRed(), color1.getGreen(), color1.getBlue(), 0);

        // create gradient height 70%
        g2.setPaint(new GradientPaint(0, 0, color1, 0, getHeight() * 0.7f, color2));
        g2.setComposite(AlphaComposite.SrcOver.derive(0.3f));
        g2.fill(new Rectangle2D.Float(0, 0, getWidth(), getHeight()));
        g2.dispose();
        super.paintComponent(g);
    }
}
