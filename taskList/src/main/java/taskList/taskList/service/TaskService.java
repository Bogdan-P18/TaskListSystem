package taskList.taskList.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import taskList.taskList.models.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    List<Task> getTasksByUserId(Long idUser);
    ResponseEntity<Task> getTaskById(Long id);
    ResponseEntity<Task> update(Long id, Task task);
    ResponseEntity<HttpStatus> delete(Long id);
}
