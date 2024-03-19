package taskList.taskList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import taskList.taskList.models.ResourceNotFoundException;
import taskList.taskList.models.Task;
import taskList.taskList.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByUserId(Long idUser) {
        return taskRepository.getTaskByUserId(idUser);
    }

    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " does not exist!"));
        return ResponseEntity.ok(task);
    }

    @Override
    public ResponseEntity<Task> update(Long id, Task task) {
        Task updatedTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " does not exist!"));
        updatedTask.setDescription(task.getDescription());
        updatedTask.setChecked(task.isChecked());
        updatedTask.setCreatedAt(task.getCreatedAt());
        return ResponseEntity.ok(updatedTask);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " does not exist!"));
        taskRepository.delete(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
