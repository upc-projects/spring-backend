package io.proyection.projection.repository;

import io.proyection.projection.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task getById(Long id);
}
