package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.entity.Task;
import task.util.TaskJpaRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskJpaRepository taskJpaRepository;

    @Override
    public void saveTask(Task task) {
        taskJpaRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        taskJpaRepository.save(task);
    }

    @Override
    public Task queryTask(String id) {
        Task task = taskJpaRepository.getOne(id);
        return task;
    }
}
