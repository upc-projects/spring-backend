package io.proyection.projection.service;

import io.proyection.projection.domain.Project;
import io.proyection.projection.domain.User;
import io.proyection.projection.repository.ProjectRepository;
import io.proyection.projection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private UserRepository userRepository;

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

    public Project addUser(Long user_id, Long project_id) {
        User user = userRepository.getById(user_id);
        Project project = projectRepository.getById(project_id);
        project.getUserList().add(user);
        user.getProjectList().add(project);
        return projectRepository.save(project);
    }

}
