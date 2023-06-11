package net.Todo.springboot.repository;

import net.Todo.springboot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
 // add all crud actions here

}

