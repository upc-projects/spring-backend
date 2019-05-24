package io.proyection.projection.exception;

public class EmailAlreadyExistResponse {

    private String email;

    public EmailAlreadyExistResponse(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
