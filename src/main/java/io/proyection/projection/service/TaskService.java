package io.proyection.projection.service;

import io.proyection.projection.domain.Task;
import io.proyection.projection.domain.User;
import io.proyection.projection.exception.TaskIdException;
import io.proyection.projection.exception.TaskNotFoundException;
import io.proyection.projection.repository.TaskRepository;
import io.proyection.projection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task saveOrUpdateTask(Task task, String username){

        if(task.getId() != null){
            Task existingtask = taskRepository.getById(task.getId());
            if(existingtask !=null &&(!existingtask.getUsername().equals(username))){
                throw new TaskNotFoundException("task not found in your account");
            }else if(existingtask == null){
                throw new TaskNotFoundException("task with ID: '"+task.getId()+"' cannot be updated because it doesn't exist");
            }
        }
        
        try{
            User user = userRepository.findByUsername(username);
            task.setUsername(user.getUsername());
            task.setUser(user);

            return taskRepository.save(task);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public Task findTaskById(Long taskId, String username){

        //Only want to return the task if the user looking for it is the owner

        Task task = taskRepository.getById(taskId);

        if(task == null){
            throw new TaskIdException("Task ID '"+taskId+"' does not exist");
        }

        if (!task.getUsername().equals(username)) {
            throw new TaskNotFoundException("Task not found in your account");
        }

        return task;
    }

    public Iterable<Task> findAllTask(String username){
        return taskRepository.findAllByUsername(username);
    }


    public boolean deleteTaskByIdentifier(Long taskId, String username){
        try{
            taskRepository.delete(findTaskById(taskId, username));
            return true;
        }catch (Exception e){
            return false;
        }

    }


}
