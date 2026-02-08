package raven.tutorial.loading;

import javax.swing.*;

public class LoadingButton extends JButton implements PromiseIcon.PromiseIconAction {

    private RollingIcon rollingIcon;
    private boolean isLoading;

    private Icon oldIcon;

    public LoadingButton() {
        this(null);
    }

    public LoadingButton(String text) {
        this(text, null);
    }

    public LoadingButton(String text, Icon icon) {
        super(text);
        init(icon);
    }

    private void init(Icon icon) {
        rollingIcon = new RollingIcon(this, 15);
        if (icon != null) {
            setIcon(icon);
        }
    }

    @Override
    public boolean isDone() {
        return false;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading, String text) {
        if (this.isLoading != loading) {
            this.isLoading = loading;
            if (loading) {
                rollingIcon.start();
                setText(text);
                oldIcon = getIcon();
                setIcon(rollingIcon);
            } else {
                setIcon(oldIcon);
                setText(text);
                rollingIcon.stop();
            }
        }
    }
}
