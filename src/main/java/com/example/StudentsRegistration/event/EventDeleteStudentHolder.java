package com.example.StudentsRegistration.event;

import com.example.StudentsRegistration.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class EventDeleteStudentHolder extends ApplicationEvent {

    private Student student;

    private int id;
    public EventDeleteStudentHolder(Object source, Student student) {
        super(source);
        this.student = student;
    }

    

}
