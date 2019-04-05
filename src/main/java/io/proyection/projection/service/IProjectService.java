package io.proyection.projection.service;

import io.proyection.projection.domain.Project;
import org.springframework.stereotype.Service;

@Service
public interface IProjectService {

    public Project save(Project project);

    public Iterable<Project> findAll();

    public Project findById(Long id);

    public void delete(Long id);

    public Project addUser(Long user_id, Long project_id);
}
