package taskList.taskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskList.taskList.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query(value = "SELECT * FROM task WHERE user_id=?", nativeQuery = true)
    List<Task> getTaskByUserId(Long id);
}
