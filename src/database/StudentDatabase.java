package database;

import model.Student;

import java.util.List;

public class StudentDatabase extends Database<Student>{

    public String getFilename() {
        return "/data/students.txt";
    }

    public List<Student> getAll() {
        return null;
    }

    public void setAll(List<Student> objectList) {

    }

    protected Class<Student> getContainedClass() {
        return Student.class;
    }
}
