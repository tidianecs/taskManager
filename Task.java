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

    Task(String taskName, String taskDate){
        //I use counter because every task must be unique
        this.taskId = ++counter;
        this.taskName = taskName;
        this.taskState = new ToDoState();
        this.taskDate = taskDate;
    }

    //get and set methods for the task attributs
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
        this.taskDate = taskDate.toString();
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

    //method to switch state(thanks to state design pattern)
    public void nextState(){
        this.taskState.next(this);
    }

    //The main methods
    public void addTask(ArrayList<Task> tasks, ArrayList<Task> inGoingTasks,Task task){
        tasks.add(task);
        inGoingTasks.add(task);
        task.setTaskState(new OnGoingState());
    }

    public void delTask(ArrayList<Task> tasks, String taskName){
        tasks.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
    }

    public void showTasks(ArrayList<Task> tasks){
        for (Task task : tasks) {
            System.out.println(task.getTaskName());
        }
    }

    public void markAsDone(ArrayList<Task> DoneTasks, ArrayList<Task> inGoingTasks, ArrayList<Task> tasks, String taskName){
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName) && task.taskState != new DoneState()) {
                DoneTasks.add(task);
                task.delTask(inGoingTasks, task.taskName);
                task.setTaskState(new DoneState());
            }
        }
    }

    public void showInGoingTask(ArrayList<Task> inGoingTasks){
        for (Task task : inGoingTasks) {
            if (task.getStateTask() instanceof OnGoingState) {
                System.out.println(task.getTaskName() + " | " + task.getTaskDate());    
            }
        }
    }

    public void showDoneTask(ArrayList<Task> DoneTasks){
        for (Task task : DoneTasks) {
            if (task.getStateTask() instanceof DoneState) {
                System.out.println(task.getTaskName() + " | " + task.getTaskDate()); 
            }
        }
    }
}
