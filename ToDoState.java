public class ToDoState implements StateTask {
    public void next(Task task){
        task.setTaskState(new OnGoingState());
    }
    public String getTaskState(){
        return "To do";
    }
}
