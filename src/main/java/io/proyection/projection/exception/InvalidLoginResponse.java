package io.proyection.projection.exception;

public class InvalidLoginResponse {
    private String email;
    private String password;

    public InvalidLoginResponse() {
        this.email = "Invalid Email";
        this.password = "Invalid Password";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
