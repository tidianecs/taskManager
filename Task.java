import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Task implements TaskInterface {
    private int taskId;
    private static int counter = 0;
    private String taskName;
    private StateTask taskState;
    private String taskDate;
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> inGoingTasks = new ArrayList<>();
    private ArrayList<Task> DoneTasks = new ArrayList<>();

    Task(String taskName, String taskDate){
        this.taskId = ++counter;
        this.taskName = taskName;
        this.taskState = new OnGoingState();
        this.taskDate = taskDate;
    }

    public int getTaskId(){
        return taskId;
    }

    public String getTaskName(){
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setTaskDate(String dateInput){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate taskDate = LocalDate.parse(dateInput, formatter);
        String date = taskDate.toString();
    }

    public String getTaskDate(){
        return taskDate;
    }

    public void setTaskState(StateTask taskState){
        this.taskState = taskState;
    }
    public StateTask getStateTask(){
        return taskState;
    }

    public void nextState(){
        this.taskState.next(this);
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void delTask(String taskName){
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                tasks.remove(task);
            }
        }
    }

    public void showTasks(){
        for (Task task : tasks) {
            System.out.println(task.getTaskName());
        }
    }

    public void markAsDone(Task task){
        if (task.taskState != new DoneState()) {
            DoneTasks.add(task);
            task.delTask(task.taskName);
        }else{
            System.out.println("Impossible to mark as done");
        }
    }

    public void showInGoingTask(){
        for (Task task : tasks) {
            if (task.getStateTask() instanceof OnGoingState) {
                inGoingTasks.add(task);
                System.out.println(task.getTaskName() + " | " + task.getTaskDate());    
            }
        }
    }

    public void showDoneTask(){
        for (Task task : tasks) {
            if (task.getStateTask() instanceof DoneState) {
                DoneTasks.add(task);
                task.getTaskName();
            }
        }
    }
}
