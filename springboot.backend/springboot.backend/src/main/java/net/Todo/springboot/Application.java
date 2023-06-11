package net.Todo.springboot;

import net.Todo.springboot.model.Task;
import net.Todo.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
//		Task task1 = new Task();
//		task1.setTitle("meeting prep for AXZ");
//		task1.setDescription("make notes on the meeting");
//		task1.setTargetDate("01/01/2023");
//		taskRepository.save(task1);
//
//		Task task2 = new Task();
//		task2.setTitle("prepare meal");
//		task2.setDescription("make avacado toast");
//		task2.setTargetDate("01/01/2023");
//		taskRepository.save(task2);
	}
}
