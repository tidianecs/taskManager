public interface StateTask {
    public void next(Task task);
    public String getTaskState();
}
