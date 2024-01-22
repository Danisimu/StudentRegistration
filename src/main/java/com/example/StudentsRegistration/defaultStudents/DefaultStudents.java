package com.example.StudentsRegistration.defaultStudents;

import com.example.StudentsRegistration.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:init-application.properties")
public class DefaultStudents {
    private List<Student> students;

    @Value("${file.path}")
    private String path;

    public DefaultStudents() {
        students = new ArrayList<>();
    }
    public List<Student> getDefaultStudents(){
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null){
                String[] array = line.split(" ");
                students.add(new Student(Integer.parseInt((array[0])), array[1], array[2], Integer.parseInt(array[3])));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
