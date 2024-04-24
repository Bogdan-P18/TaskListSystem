package taskList.taskList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskList.taskList.models.Task;
import taskList.taskList.service.TaskServiceImpl;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping("/{idUser}")
    public List<Task> getTasksByUser(@PathVariable Long idUser) {
        return taskService.getTasksByUserId(idUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.update(id,task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.delete(id));
    }
}
