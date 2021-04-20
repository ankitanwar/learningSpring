package web.services;

import web.domain.Student;

import java.util.List;

public interface Services {
    Student saveStudentDetails(Student student);
    List<Student> fetchAllStudents ();
    Student getStudentByID(Integer studentID);
    Student deleteStudentByID(Integer studentID);
    String testingBasicAUthentication();
}
