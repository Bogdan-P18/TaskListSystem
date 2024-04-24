package taskList.taskList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import taskList.taskList.models.ResourceNotFoundException;
import taskList.taskList.models.User;
import taskList.taskList.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        User found = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " doesn't exist!"));
        found.setUsername(user.getUsername());
        found.setEmail(user.getEmail());
        found.setPassword(user.getPassword());
        userRepository.save(found);
        return found;
    }

    @Override
    public HttpStatus delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " doesn't exist!"));
        userRepository.delete(user);
        return HttpStatus.NO_CONTENT;
    }

    @Override
    public User findByUsername(String username) {
       return userRepository.findByUsername(username);
    }
}
