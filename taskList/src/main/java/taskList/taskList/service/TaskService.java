package taskList.taskList.service;

import org.springframework.http.HttpStatus;
import taskList.taskList.models.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    List<Task> getTasksByUserId(Long idUser);
    Task getTaskById(Long id);
    Task update(Long id, Task task);
    HttpStatus delete(Long id);
}
