package database;

import model.Student;

import java.io.IOException;
import java.util.List;

public class StudentDatabase extends Database<Student>{

    private List<Student> studentList;
    public StudentDatabase() throws IOException, ClassNotFoundException {
        this.studentList= load();
    }
    public String getFilename() {
        return "/data/students.txt";
    }

    public List<Student> getAll() {
        return studentList;
    }

    public void setAll(List<Student> objectList) {
        this.studentList = objectList;
    }

    protected Class<Student> getContainedClass() {
        return Student.class;
    }
}
