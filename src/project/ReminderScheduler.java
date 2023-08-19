package project;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReminderScheduler {
    private ScheduledThreadPoolExecutor executor;

    public ReminderScheduler(int poolSize) {
        executor = new ScheduledThreadPoolExecutor(poolSize);
    }

    public void scheduleReminder(Reminder reminder) {
        long delay = reminder.getTime().getSecond() - LocalDateTime.now().getSecond();
        executor.schedule(reminder, delay, TimeUnit.SECONDS);
        System.out.println("Запланировано напоминание: " + reminder.getTask() + " в " + reminder.getTime());
    }

    public void cancelReminder(Reminder reminder) {
        if (!reminder.isCompleted()) {
            executor.remove(reminder);
            System.out.println("Отменено напоминание: " + reminder.getTask() + " в " + reminder.getTime());
        } else {
            System.out.println("Напоминание уже выполнено и не может быть отменено: " + reminder.getTask() + " в " + reminder.getTime());
        }
    }

    public void markReminderAsCompleted(Reminder reminder) {
        if (!reminder.isCompleted()) {
            reminder.setCompleted(true);
            System.out.println("Помечено как завершенное напоминание: " + reminder.getTask() + " в " + reminder.getTime());
        } else {
            System.out.println("Напоминание уже помечено как завершенное: " + reminder.getTask() + " в " + reminder.getTime());
        }
    }
}
