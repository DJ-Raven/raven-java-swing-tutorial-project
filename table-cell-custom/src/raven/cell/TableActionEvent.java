package raven.cell;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onView(int row);
}
