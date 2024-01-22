package com.example.StudentsRegistration.event;

import com.example.StudentsRegistration.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class EventAddStudentHolder extends ApplicationEvent {

    private final Student student;
    public EventAddStudentHolder(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
