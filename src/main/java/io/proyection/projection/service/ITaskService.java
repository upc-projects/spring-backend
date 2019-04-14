package io.proyection.projection.service;

import io.proyection.projection.domain.Task;
import org.springframework.stereotype.Service;

@Service
public interface ITaskService {

    Task save(Task task);

    Iterable<Task> findAll();

    Task findById(Long id);

    void delete(Long id);

    Task changeStatus(Long id_task, int new_status);
}
