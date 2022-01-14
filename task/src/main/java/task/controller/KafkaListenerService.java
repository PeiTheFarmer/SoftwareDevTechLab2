package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import task.entity.Task;
import task.service.TaskService;

@Service
public class KafkaListenerService {
    @Autowired
    TaskService taskService;

    @KafkaListener(topics = {"UserTask"})
    public void listener0(String id) {
        Task task = new Task();
        task.setId(id);
        task.setMessage("nothing to do");
        task.setState("finished");
        taskService.saveTask(task);
    }

    @KafkaListener(topics = {"StaffTask"})
    public void listener1(String id) {
        Task task = new Task();
        task.setId(id);
        task.setState("unfinished");
        task.setMessage("user needs to modify password");
        taskService.updateTask(task);
    }
}
