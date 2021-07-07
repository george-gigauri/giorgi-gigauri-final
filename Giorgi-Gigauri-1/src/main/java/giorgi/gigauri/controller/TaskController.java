package giorgi.gigauri.controller;

import giorgi.gigauri.data.dto.AddTaskDto;
import giorgi.gigauri.data.dto.TaskDto;
import giorgi.gigauri.data.dto.TaskResponse;
import giorgi.gigauri.data.entity.Task;
import giorgi.gigauri.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<TaskDto> getAll() {
        List<TaskDto> tasks = new ArrayList<>();
        List<Task> result = taskRepository.findAll();

        result.forEach(it -> tasks.add(
                new TaskDto(
                        it.getId(),
                        it.getTitle(),
                        it.getDescription(),
                        it.getStartDate(),
                        it.getEndDate()
                )
        ));
        return tasks;
    }

    @GetMapping("/task/{id}")
    public TaskResponse getTaskById(@PathVariable("id") int id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            Task result = task.get();
            return new TaskResponse(
                    true,
                    "Task Exists.",
                    new TaskDto(
                            result.getId(),
                            result.getTitle(),
                            result.getDescription(),
                            result.getStartDate(),
                            result.getEndDate()
                    )
            );
        }
        return new TaskResponse(
                false,
                "Task with such id not found.",
                null
        );
    }

    @PostMapping("/task")
    public TaskResponse saveTask(@RequestBody AddTaskDto task) {
        Task toAdd = new Task(
                0,
                task.getTitle(),
                task.getDescription(),
                task.getStartDate(),
                task.getEndDate()
        );

        Task result = taskRepository.save(toAdd);
        TaskResponse response = new TaskResponse(
                true,
                "Successfully Added.",
                new TaskDto(
                        result.getId(),
                        result.getTitle(),
                        result.getDescription(),
                        result.getStartDate(),
                        result.getEndDate()
                )
        );

        return response;
    }

    @DeleteMapping("/all")
    public TaskResponse deleteAll() {
        taskRepository.deleteAll();

        return new TaskResponse(
                true,
                "Successfully Deleted.",
                null
        );
    }

    @DeleteMapping("/task/{id}")
    public TaskResponse delete(@PathVariable("id") int id) {
        taskRepository.deleteById(id);

        return new TaskResponse(
                true,
                "Successfully Deleted.",
                null
        );
    }
}
