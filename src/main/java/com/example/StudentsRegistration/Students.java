package com.example.StudentsRegistration;

import com.example.StudentsRegistration.defaultStudents.DefaultStudents;
import com.example.StudentsRegistration.event.EventAddStudentHolder;
import com.example.StudentsRegistration.event.EventDeleteStudentHolder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ArrayList;
import java.util.List;
@Getter
@ShellComponent
public class Students {

    private final List<Student> studentList;

    private final ApplicationEventPublisher applicationEventPublisher;

    private int id = 0;

    public Students(List<Student> studentList, ApplicationEventPublisher applicationEventPublisher,
                    @Value("${spring.profiles.active}") String profile, DefaultStudents defaultStudents) {
        this.studentList = studentList;
        this.applicationEventPublisher = applicationEventPublisher;

        if (profile.equals("init")){
            studentList.addAll(defaultStudents.getDefaultStudents());
            this.id =studentList.size();
        }
    }

    @ShellMethod(key = "add")
    public void addStudent(String firstName, String lastName, int age){
        studentList.add(new Student(this.id, firstName, lastName, age));
        applicationEventPublisher.publishEvent(new EventAddStudentHolder(this, getStudent(this.id)));
        this.id++;
    }

    @ShellMethod(key = "delete")
    public void deleteStudent(int id){
        if (getStudent(id) == null){
            System.out.println("Студент с таким ID не существует!");
        }
        else {
            applicationEventPublisher.publishEvent(new EventDeleteStudentHolder(this, getStudent(id)));
            studentList.removeIf(c -> c.getId() == id);
        }


    }

    public Student getStudent(int id){

        List<Student> list = new ArrayList<>();
        studentList.forEach(s -> {
            if (s.getId() == id){
                list.add(s);
            }
        });
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @ShellMethod(key = "show")
    public void showAllStudents(){
        for (Student s: studentList){
            System.out.println(s);
        }
    }

    @ShellMethod(key = "clear list")
    public void clear(){
        System.out.println("Список студентов очищен!");
        studentList.clear();
        this.id = 0;
    }


}
