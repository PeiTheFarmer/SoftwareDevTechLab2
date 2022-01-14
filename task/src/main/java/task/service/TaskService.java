package task.service;

import task.entity.Task;

public interface TaskService {
    public void saveTask(Task task);
    public void updateTask(Task task);
    public Task queryTask(String id);
}
