package io.proyection.projection.service;

import io.proyection.projection.domain.ProjectTask;
import io.proyection.projection.repository.ProjectTaskRepository;
import io.proyection.projection.utils.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.sql.Types.NULL;


@Service
public class ProjectTaskService implements IProjectTaskService{

    @Autowired
    private ProjectTaskRepository projectTaskRepository;


    public ProjectTask save(ProjectTask projectTask) {

        if(projectTask.getStatus() == NULL){
            projectTask.setStatus(StatusType.TO_DO.getNumVal());
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

    public ProjectTask changeStatus(Long id_task, int new_status){

        ProjectTask projectTask = projectTaskRepository.getById(id_task);
        int status;

        if(new_status == StatusType.TO_DO.getNumVal()){
            status = StatusType.TO_DO.getNumVal();
        }else if(new_status == StatusType.DOING.getNumVal()){
            status = StatusType.DOING.getNumVal();
        }else{
            status = StatusType.DONE.getNumVal();
        }
        projectTask.setStatus(status);
        return projectTaskRepository.save(projectTask);
    }
}
