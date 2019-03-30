package io.proyection.projection.service;

import io.proyection.projection.domain.Project;
import io.proyection.projection.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.getById(id);
    }

    public void delete(Long id){
        Project project = findById(id);
        projectRepository.delete(project);
    }
}
