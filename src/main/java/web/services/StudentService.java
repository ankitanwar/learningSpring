package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.database.StudentDB;
import web.domain.Student;

import java.util.List;

@Service
public class StudentService implements Services {
    @Autowired  private StudentDB database;

    @Override
    public Student saveStudentDetails(Student student){
        return database.addNewStudent(student);
    }

    @Override
    public List<Student> fetchAllStudents (){
        return database.getAllStudents();
    }

    @Override
    public Student getStudentByID(Integer studentID){
        return database.getStudentByID(studentID);
    }

    @Override
    public Student deleteStudentByID(Integer studentID){
        return database.deleteByID(studentID);
    }


    //practicing authentication
    @Override
    public String testingBasicAUthentication(){
        return "this is very private resource";
    }
}
