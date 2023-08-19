package project;

import java.time.LocalDateTime;

public class Reminder implements Runnable{
    private String task;
    private LocalDateTime time;
    private boolean completed;

    public Reminder(String task, LocalDateTime time) {
        this.task = task;
        this.time = time;
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public void run() {
        System.out.println("Напоминание: " + task + " в " + time);
        setCompleted(true);
    }
}
