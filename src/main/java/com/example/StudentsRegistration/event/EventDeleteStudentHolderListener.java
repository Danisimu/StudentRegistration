package com.example.StudentsRegistration.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventDeleteStudentHolderListener {

    @EventListener()
    public void listen1(EventDeleteStudentHolder eventHolder){
        System.out.println("Студент: " + eventHolder.getStudent() + " успешно удален");

    }

}
