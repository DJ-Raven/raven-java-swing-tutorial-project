package raven.demo;

import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;
import net.miginfocom.swing.MigLayout;
import raven.modal.ModalDialog;
import raven.modal.component.SimpleModalBorder;
import raven.modal.option.Option;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    public Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1300, 800));
        setLocationRelativeTo(null);

        setLayout(new MigLayout("al center center"));

        JButton cmd1 = new JButton("Show1");
        JButton cmd2 = new JButton("Show2");
        JButton cmd3 = new JButton("Show3");
        JButton cmd4 = new JButton("Show4");
        cmd1.addActionListener(e -> {
            show(new Color(255, 162, 0));
        });
        cmd2.addActionListener(e -> {
            show(new Color(0, 255, 196));
        });
        cmd3.addActionListener(e -> {
            show(new Color(0, 111, 255));
        });
        cmd4.addActionListener(e -> {
            show(new Color(117, 226, 22));
        });
        add(cmd1);
        add(cmd2);
        add(cmd3);
        add(cmd4);
    }

    public void show(Color color) {
        Option option = ModalDialog.createOption();

        option.getBorderOption()
                .setRound(0)
                .setBorderWidth(1)
                .setShadowSize(new Insets(13, 15, 15, 15))
                .setShadowOpacity(0.3f)
                .setBorderColor(color)
                .setShadowColor(color);

        ModalDialog.showModal(this, new EmptyModalBorder(new SimpleMessage(color), (controller, action) -> {

            // test callback action
            if (action == SimpleModalBorder.OK_OPTION) {
                System.out.println("Click ok");
            }
        }), option);
    }

    public static void main(String[] args) {
        FlatXcodeDarkIJTheme.setup();
        SwingUtilities.invokeLater(() -> new Test().setVisible(true));
    }
}
