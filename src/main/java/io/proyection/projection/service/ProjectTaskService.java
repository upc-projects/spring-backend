package io.proyection.projection.service;

import io.proyection.projection.domain.ProjectTask;
import io.proyection.projection.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask save(ProjectTask projectTask) {

        if(projectTask.getStatus()== null || projectTask.getStatus()==""){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll() {
            return projectTaskRepository.findAll();
        }

        public ProjectTask findById(Long id){
            return projectTaskRepository.getById(id);
        }

        public void delete(Long id){
            ProjectTask projectTask = findById(id);
            projectTaskRepository.delete(projectTask);
    }
}
