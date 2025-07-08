//I define all the main methods of the state of a task
public interface StateTask {
    public void next(Task task);
    public String getTaskState();
}
