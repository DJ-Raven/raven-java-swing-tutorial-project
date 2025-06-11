package raven.table;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;

public enum StaffStatus implements TableBadgeCellRenderer.Info {
    ACTIVE("Active", new Color(59, 155, 60), "active.svg"),
    ON_LEAVE("On Leave", new Color(255, 164, 75), "leave.svg"),
    INACTIVE("Inactive", new Color(255, 75, 101), "inactive.svg");

    StaffStatus(String text, Color color, String icon) {
        this.text = text;
        this.color = color;
        this.icon = new FlatSVGIcon("raven/icon/" + icon, 0.35f).setColorFilter(new FlatSVGIcon.ColorFilter((component, color1) -> color));
    }

    private final String text;
    private final Color color;
    private final Icon icon;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }
}
