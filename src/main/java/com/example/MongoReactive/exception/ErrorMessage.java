package com.example.MongoReactive.exception;

public class ErrorMessage {
    private String exception;
    private String message;
    private String path;

    public ErrorMessage(Exception e, String path) {
        this.exception = e.getClass().getSimpleName();
        this.message = e.getMessage();
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
