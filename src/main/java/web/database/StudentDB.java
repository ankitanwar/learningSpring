package web.database;

import web.domain.Student;

import java.util.List;

public interface StudentDB {
    Student addNewStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByID(Integer studentID);
    Student deleteByID(Integer studentID);
}
