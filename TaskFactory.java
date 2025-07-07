import java.time.LocalDate;

public class TaskFactory {
    public Task createTask(String taskName, String taskDate){
        return new Task(taskName, taskDate);
    }
    public static Task createTestTask() {
        return new Task("Sample Task", "2025-07-07");
    }
}
