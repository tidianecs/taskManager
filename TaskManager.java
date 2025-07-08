import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        //all the instances that i will use
        Scanner scanner = new Scanner(System.in);
        TaskFactory factory = new TaskFactory();
        //i create taskTest in order to get every time a task in my Task Manager and to use the main methods of task
        Task taskTest = factory.createTestTask();
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Task> inGoingTasks = new ArrayList<>();
        ArrayList<Task> DoneTasks = new ArrayList<>();
        taskTest.addTask(tasks, inGoingTasks, taskTest);
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
                task.addTask(tasks, inGoingTasks, task);
                System.out.println("Successfully added!");
            }else if (modeChoice == 2) {
                scanner.nextLine();
                taskTest.showTasks(tasks);
                System.out.println("Rewrite the task name if you want to delete it\n(To Delete) ->");
                String delTask = scanner.nextLine();
                taskTest.delTask(tasks ,delTask);
                System.out.println("Successfully deleted!");
            }else if (modeChoice == 3) {
                scanner.nextLine();
                taskTest.showTasks(tasks);
                System.out.println("Rewrite the task name if you want to mark as done it\n(To Mark As Done) ->");
                String markAsDoneTask = scanner.nextLine();
                taskTest.markAsDone(DoneTasks, inGoingTasks, tasks, markAsDoneTask);
                System.out.println("Successfully mark as done!");
            }else if (modeChoice == 4) {
                taskTest.showDoneTask(DoneTasks);
            }else if (modeChoice == 5) {
                taskTest.showInGoingTask(inGoingTasks);
            }else if (modeChoice == 6) {
                System.out.println("Have a nice day!");
                repetion++;
            }
        }
    }
}
