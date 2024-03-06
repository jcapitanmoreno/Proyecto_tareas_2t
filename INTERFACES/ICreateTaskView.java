package INTERFACES;

import MODEL.Task;

public interface ICreateTaskView {
    String createInformation();
    Task createTask();
    void errorTaskName();
    void errorSameTaskName();
    void errorTaskDates();
    void errorTaskUser();
}
