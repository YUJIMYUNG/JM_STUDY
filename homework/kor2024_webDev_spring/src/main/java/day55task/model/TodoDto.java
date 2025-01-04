package day55task.model;

public class TodoDto {
    private int todoNo;
    private String todoContent;
    private boolean todoState;

    public TodoDto(){};

    public TodoDto(int todoNo, String todoContent, boolean todoState) {
        this.todoNo = todoNo;
        this.todoContent = todoContent;
        this.todoState = todoState;
    }

    public int getTodoNo() {
        return todoNo;
    }

    public void setTodoNo(int todoNo) {
        this.todoNo = todoNo;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public boolean isTodoState() {
        return todoState;
    }

    public void setTodoState(boolean todoState) {
        this.todoState = todoState;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "todoNo=" + todoNo +
                ", todoContent='" + todoContent + '\'' +
                ", todoState=" + todoState +
                '}';
    }
}
