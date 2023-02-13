package raven.notibutton;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author RAVEN
 */
public class BadgeButton extends JButton {

    public Color getBadgeColor() {
        return badgeColor;
    }

    public void setBadgeColor(Color badgeColor) {
        this.badgeColor = badgeColor;
    }

    private BufferedImage image;
    private Color badgeColor = new Color(220, 67, 67);

    public BadgeButton() {
        setUI(new BadgeButtonUI());
        setOpaque(false);
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(10, 11, 10, 11));
        setHorizontalTextPosition(SwingConstants.CENTER);
    }

    private void createImage() {
        if (getIcon() != null) {
            image = new BufferedImage(getIcon().getIconWidth(), getIcon().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();
            g2.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, null);
            g2.dispose();
        } else {
            image = null;
        }
    }

    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
        createImage();
    }

    private class BadgeButtonUI extends BasicButtonUI {

        @Override
        protected void paintText(Graphics grphcs, JComponent jc, Rectangle rctngl, String string) {

        }

        @Override
        protected void paintIcon(Graphics grphcs, JComponent jc, Rectangle iconRect) {
            if (image != null && !getText().equals("")) {
                //  Custom Badge Icon
                Graphics2D g2 = (Graphics2D) grphcs.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                double size = Math.max(iconRect.getWidth(), iconRect.getHeight()) * 0.8f;
                double x = Math.min(iconRect.getX() + iconRect.getWidth() / 2, jc.getWidth() - size);
                double y = Math.max(iconRect.getY() - size / 2, 0);
                Area area = new Area(iconRect);
                area.subtract(new Area(new Ellipse2D.Double(x, y, size, size)));
                g2.setPaint(new TexturePaint(image, iconRect));
                g2.fill(area);
                String text = getText();
                createText(g2, x, y, size, text);
                g2.dispose();
            } else {
                super.paintIcon(grphcs, jc, iconRect);
            }
        }

        private void createText(Graphics2D g2, double x, double y, double size, String text) {
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D f2d = fm.getStringBounds(text, g2);
            double space = size * 0.08f;
            double width = Math.max(size - space * 2, f2d.getWidth() + 10);
            double height = size - space * 2;
            g2.setColor(badgeColor);
            g2.translate(x, y);
            g2.fill(new RoundRectangle2D.Double(space, space, width, height, height, height));
            double fx = ((width - f2d.getWidth()) / 2) + space;
            double fy = ((height - f2d.getHeight()) / 2) + space;
            g2.setColor(getForeground());
            g2.drawString(text, (int) fx, (int) fy + fm.getAscent());
        }
    }
}
