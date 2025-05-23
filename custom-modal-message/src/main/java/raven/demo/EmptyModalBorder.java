package raven.demo;

import raven.modal.component.Modal;
import raven.modal.component.ModalBorderAction;
import raven.modal.listener.ModalCallback;
import raven.modal.listener.ModalController;

import java.awt.*;

public class EmptyModalBorder extends Modal implements ModalBorderAction {

    protected final Component component;
    protected final ModalCallback callback;

    public EmptyModalBorder(Component component, ModalCallback callback) {
        this.component = component;
        this.callback = callback;
        setLayout(new BorderLayout());
        add(component);
    }

    @Override
    public void doAction(int action) {
        ModalController controller = new ModalController(this) {
            @Override
            public void close() {
                getController().closeModal();
            }
        };
        callback.action(controller, action);
        if (!controller.getConsume()) {
            getController().closeModal();
        }
    }
}
