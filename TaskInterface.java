import java.util.ArrayList;

//I define all the main methods of a task
public interface TaskInterface {
    public void addTask(ArrayList<Task> tasks, ArrayList<Task> inGoingTasks, Task task);
    public void delTask(ArrayList<Task> tasks, String delTask);
    public void markAsDone(ArrayList<Task> DoneTasks, ArrayList<Task> inGoingTasks, ArrayList<Task> tasks, String taskName);
    public void showDoneTask(ArrayList<Task> DoneTasks);
    public void showInGoingTask(ArrayList<Task> inGoingTasks);
    public void showTasks(ArrayList<Task> tasks);
}
