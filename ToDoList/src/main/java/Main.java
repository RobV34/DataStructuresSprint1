import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create users
        System.out.println("Enter number of users:");
        int userCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < userCount; i++) {
            System.out.println("Enter name for user " + (i + 1) + ":");
            String name = scanner.nextLine();
            users.add(new User(name));
        }

        // Main loop
        while (true) {
            System.out.println("1. Add Task\n2. Mark Task as Completed\n3. View Tasks\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter user name:");
                    String userName = scanner.nextLine();
                    User user = findUser(userName);
                    if (user != null) {
                        System.out.println("Enter task description:");
                        String taskDescription = scanner.nextLine();
                        user.addTask(new Task(taskDescription));
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter user name:");
                    userName = scanner.nextLine();
                    user = findUser(userName);
                    if (user != null) {
                        System.out.println("Enter task description to mark as completed:");
                        String taskDescription = scanner.nextLine();
                        user.markTaskAsCompleted(taskDescription);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    for (User u : users) {
                        u.printTasks();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
