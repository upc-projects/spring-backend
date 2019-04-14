package io.proyection.projection.service;

import io.proyection.projection.domain.Task;
import io.proyection.projection.repository.TaskRepository;
import io.proyection.projection.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.sql.Types.NULL;


@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task save(Task task) {

        if (task.getStatus() == NULL) {
            task.setStatus(StatusType.TO_DO.getNumVal());
        }

        return taskRepository.save(task);
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.getById(id);
    }

    public void delete(Long id) {
        Task task = findById(id);
        taskRepository.delete(task);
    }

    public Task changeStatus(Long id_task, int new_status) {

        Task task = taskRepository.getById(id_task);
        int status;

        if (new_status == StatusType.TO_DO.getNumVal()) {
            status = StatusType.TO_DO.getNumVal();
        } else if (new_status == StatusType.DOING.getNumVal()) {
            status = StatusType.DOING.getNumVal();
        } else {
            status = StatusType.DONE.getNumVal();
        }
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
