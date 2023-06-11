package net.Todo.springboot.controller;

import net.Todo.springboot.exception.ResourceNotFoundException;
import net.Todo.springboot.model.Task;
import net.Todo.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
       return taskRepository.save(task);
    }

    //build update task REST API
    @GetMapping("{id}")
    public ResponseEntity<Task>  getTaskById(@PathVariable long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("task not present with given id"+ id));
        return ResponseEntity.ok(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id,@RequestBody Task taskDetails){
        Task updateTask = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("task not found for given id"+id));

        updateTask.setDescription(taskDetails.getDescription());
        updateTask.setTitle(taskDetails.getTitle());
        updateTask.setTargetDate(taskDetails.getTargetDate());

        taskRepository.save(updateTask);

        return ResponseEntity.ok(updateTask);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("task not present with given id"+ id));

        taskRepository.delete(task);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
