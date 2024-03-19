package taskList.taskList.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    private String description;
    private Date createdAt;
    private boolean checked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Task() {

    }
    public Task(Long id, String description, Date createdAt, boolean checked, User user) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.checked = checked;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && checked == task.checked && Objects.equals(description, task.description) && Objects.equals(createdAt, task.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createdAt, checked);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", id_user" + user.getId() +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", checked=" + checked +
                '}';
    }
}
