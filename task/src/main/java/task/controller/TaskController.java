package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.entity.Task;
import task.service.TaskService;

@RestController
@RequestMapping(value = "task")
public class TaskController{
    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/add/{id}")
    public Task addTask(@PathVariable String id) {
        Task task = new Task();
        task.setId(id);
        task.setState("unfinished");
        task.setMessage("user needs to modify password");
        taskService.saveTask(task);
        return task;
    }

    @PostMapping(value = "/update/{id}")
    public Task updateTask(@PathVariable String id) {
        Task task = new Task();
        task.setId(id);
        task.setMessage("nothing to do");
        task.setState("finished");
        taskService.updateTask(task);
        return task;
    }

    @GetMapping(value = "/search/{id}")
    public Task queryTask(@PathVariable String id) {
        Task task = taskService.queryTask(id);
        return task;
    }
}
