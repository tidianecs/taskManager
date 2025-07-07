import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskFactory factory = new TaskFactory();
        Task taskTest = factory.createTestTask();
        taskTest.addTask(taskTest);
        int repetion = 0;

        while (repetion != 1) {
            System.out.println("Welcome to Task Manager!\n1. Add a task 2. Delete a task 3. Mark as done\n4. Show done task 5. Show on going task 6. Quit");
            int modeChoice = scanner.nextInt();
            if (modeChoice < 1 || modeChoice > 6) {
                System.out.println("Error: You should choose between 1-6");
            }else if (modeChoice == 1) {
                scanner.nextLine();
                System.out.print("(Name) -> ");
                String taskName = scanner.nextLine();
                System.out.print("(Date[yyyy-MM-dd]) -> ");
                String taskDate = scanner.nextLine();
                Task task = factory.createTask(taskName, taskDate);
                task.setTaskDate(taskDate);
                task.addTask(task);
                System.out.println("Successfully added!");
            }else if (modeChoice == 2) {
                scanner.nextLine();
                taskTest.showTasks();
                System.out.println("Rewrite the task name if you want delete it\n(To Delete) ->");
                String delTask = scanner.nextLine();
                taskTest.delTask(delTask);
                taskTest.showTasks();
            }else if (modeChoice == 6) {
                System.out.println("Have a nice day!");
                repetion++;
            }
        }
    }
}
