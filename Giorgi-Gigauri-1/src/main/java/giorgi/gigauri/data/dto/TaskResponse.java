package giorgi.gigauri.data.dto;

public class TaskResponse {
    private boolean isSuccess;
    private String message;
    private TaskDto task;

    public TaskResponse(boolean isSuccess, String message, TaskDto taskDto) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.task = taskDto;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TaskDto getTask() {
        return this.task;
    }

    public void setTask(TaskDto taskDto) {
        this.task = taskDto;
    }
}
