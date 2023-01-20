package raven.slider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class SliderGradientUI extends BasicSliderUI {

    private SliderGradient sliderGradient;

    public SliderGradientUI(SliderGradient sliderGradient) {
        super(sliderGradient);
        this.sliderGradient = sliderGradient;
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(25, 25);
    }

    @Override
    public void paintThumb(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform tra = g2.getTransform();
        g2.translate(thumbRect.x, thumbRect.y);
        g2.setPaint(new GradientPaint(0, 0, new Color(237, 237, 237), thumbRect.width, thumbRect.height, new Color(205, 205, 205)));
        g2.fill(new Ellipse2D.Double(0, 0, thumbRect.width, thumbRect.height));
        g2.setPaint(new GradientPaint(0, 0, new Color(243, 243, 243), thumbRect.width, thumbRect.height, new Color(210, 210, 210)));
        g2.fill(new Ellipse2D.Double(1, 1, thumbRect.width - 2, thumbRect.height - 2));
        g2.setTransform(tra);
        g2.setPaint(new GradientPaint(trackRect.x, trackRect.y, sliderGradient.getColor1(), trackRect.width, trackRect.height, sliderGradient.getColor2()));
        g2.fill(new Ellipse2D.Double(thumbRect.x + 5, thumbRect.y + 5, thumbRect.width - 10, thumbRect.height - 10));
        g2.dispose();
    }

    @Override
    public void paintTrack(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(new GradientPaint(trackRect.x, trackRect.y, sliderGradient.getColor1(), trackRect.width, trackRect.height, sliderGradient.getColor2()));
        int size = sliderGradient.getTrackSize();
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            int x = 0;
            int y = (trackRect.height - size) / 2;
            g2.fill(new RoundRectangle2D.Double(trackRect.x + x, trackRect.y + y, trackRect.width, size, size, size));
        } else {
            int x = (trackRect.width - size) / 2;
            int y = 0;
            g2.fill(new RoundRectangle2D.Double(trackRect.x + x, trackRect.y + y, size, trackRect.height, size, size));
        }
        g2.dispose();
    }

    @Override
    public void paintTicks(Graphics grphcs) {
        super.paintTicks(new Graphics2DProxy((Graphics2D) grphcs) {
            @Override
            public void setColor(Color c) {
                super.setColor(sliderGradient.getTicksColor());
            }
        });
    }

    @Override
    public void paintFocus(Graphics grphcs) {
    }
}
