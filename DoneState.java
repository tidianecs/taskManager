public class DoneState implements StateTask {
    public void next(Task task){
        task.setTaskState(new DoneState());
    }
    public String getTaskState(){
        return "Already done with it!";
    }
}
