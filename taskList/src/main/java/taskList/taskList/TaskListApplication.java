package taskList.taskList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class TaskListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskListApplication.class, args);
	}
}
