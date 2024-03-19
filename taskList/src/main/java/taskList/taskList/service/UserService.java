package taskList.taskList.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import taskList.taskList.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAll();
    ResponseEntity<User> update(Long id, User user);
    ResponseEntity<HttpStatus> delete(Long id);
    User findByUsername(String username);
}
