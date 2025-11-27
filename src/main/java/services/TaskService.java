package services;

import entities.Task;
import entities.request.TaskRequest;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskRequest request){
        Task task = new Task(request.getName(), request.getDescription(), request.getStatus());
        taskRepository.save(task);
    }
}
