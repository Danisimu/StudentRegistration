package com.example.StudentsRegistration.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventAddStudentHolderListener {

    @EventListener
    public void listen(EventAddStudentHolder holder){
        System.out.println("Успешно добавлен студент: " + holder.getStudent());
    }

}
