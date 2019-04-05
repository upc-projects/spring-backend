package io.proyection.projection.service;

import io.proyection.projection.domain.ProjectTask;
import org.springframework.stereotype.Service;

@Service
public interface IProjectTaskService {

    public ProjectTask save(ProjectTask projectTask);

    public Iterable<ProjectTask> findAll();

    public ProjectTask findById(Long id);

    public void delete(Long id);
}
