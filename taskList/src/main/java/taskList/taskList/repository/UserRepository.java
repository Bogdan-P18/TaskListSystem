package taskList.taskList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskList.taskList.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value="SELECT * FROM user WHERE username=?",nativeQuery = true)
    User findByUsername(String username);
}
