import project.Reminder;
import project.ReminderScheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//todo - Create a program that simulates a simple reminder application.
// The program should allow users to schedule reminders for specific tasks
// at designated times
// Requirements:
//    Create a Reminder class that represents a single reminder. It should have the following properties: task (String), time (Date), and completed (boolean).
//    Implement a ReminderScheduler class that manages the scheduling and execution of reminders using a ScheduledThreadPoolExecutor.
//    The ReminderScheduler class should have the following methods:
//        scheduleReminder(Reminder reminder): Schedules a reminder for execution at the specified time.
//        cancelReminder(Reminder reminder): Cancels a scheduled reminder.
//        markReminderAsCompleted(Reminder reminder): Marks a reminder as completed.
//    The program should provide a simple command-line interface (CLI) for users to interact with the ReminderScheduler. Users should be able to:
//        Schedule a new reminder by providing the task description and the time (in the format "yyyy-MM-dd HH:mm:ss").
//        Cancel a scheduled reminder by specifying the task description.
//        Mark a reminder as completed by specifying the task description.
public class ExecutorServices {
    public static void main(String[] args) {
        ReminderScheduler scheduler = new ReminderScheduler(10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Запланировать новое напоминание");
            System.out.println("2. Отменить запланированное напоминание");
            System.out.println("3. Отметить напоминание как выполненное");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите описание задачи:");
                    scanner.nextLine();
                    String task = scanner.nextLine();

                    System.out.println("Введите время напоминания в формате \"гггг-мм-дд чч:мм:сс\":");
                    String timeString = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime time = LocalDateTime.parse(timeString, formatter);

                    Reminder reminder = new Reminder(task, time);

                    scheduler.scheduleReminder(reminder);

                    break;

                case 2:
                    System.out.println("Введите описание задачи:");
                    scanner.nextLine();
                    task = scanner.nextLine();

                    System.out.println("Введите время напоминания в формате \"гггг-мм-дд чч:мм:сс\":");
                    timeString = scanner.nextLine();

                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    time = LocalDateTime.parse(timeString, formatter);

                    reminder = new Reminder(task, time);

                    scheduler.cancelReminder(reminder);

                    break;

                case 3:
                    System.out.println("Введите описание задачи:");
                    scanner.nextLine();
            }
        }
    }
}