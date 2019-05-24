package io.proyection.projection.exception;

public class TaskNotFoundExceptionResponse {

    private String taskNotFound;

    public TaskNotFoundExceptionResponse(String taskNotFound) {
        this.taskNotFound = taskNotFound;
    }

    public String getTaskNotFound() {
        return taskNotFound;
    }

    public void setTaskNotFound(String taskNotFound) {
        this.taskNotFound = taskNotFound;
    }
}
