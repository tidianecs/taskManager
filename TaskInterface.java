public interface TaskInterface {
    public void addTask(Task task);
    public void delTask(String delTask);
    public void markAsDone(Task task);
    public void showDoneTask();
    public void showInGoingTask();
}
