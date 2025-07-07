public class OnGoingState implements StateTask {
    public void next(Task task){
        task.setTaskState(new DoneState());
    }
    public String getTaskState(){
        return "In Progress";
    }
}
