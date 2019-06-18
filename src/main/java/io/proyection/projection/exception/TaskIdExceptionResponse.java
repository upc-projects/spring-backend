package io.proyection.projection.exception;

public class TaskIdExceptionResponse {

    private String taskIdentifier;

    public TaskIdExceptionResponse(String taskIdentifier) {
        this.taskIdentifier = taskIdentifier;
    }

    public String getTaskIdentifier() {
        return taskIdentifier;
    }

    public void setPTaskIdentifier(String taskIdentifier) {
        this.taskIdentifier = taskIdentifier;
    }
}