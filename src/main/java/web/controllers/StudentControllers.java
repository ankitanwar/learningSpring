package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.ErrorHandling.ResourceNotFound;
import web.domain.Student;
import web.services.Services;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentControllers {
    @Autowired private Services studentService;

    @PostMapping(path = "/user")
    public Student createNewStudent(@Valid @RequestBody Student student){
        return  studentService.saveStudentDetails(student);
    }

    @GetMapping(path = "/users")
    public List<Student> getAllStudent(){
        return  studentService.fetchAllStudents();
    }
    @GetMapping(path="/user/{studentID}")
    public Student getStudentByID(@PathVariable Integer studentID){
        Student response=studentService.getStudentByID(studentID);
        if (response==null)
            throw new ResourceNotFound("Student not found with studentID->"+studentID);
        return  response;
    }

    @DeleteMapping(path = "/user/{studentID}")
    public Student deleteStudentByID(@PathVariable Integer studentID){
        Student response=studentService.deleteStudentByID(studentID);
        if (response==null){
            throw  new ResourceNotFound("unable to delete the given user with ID ->"+studentID);
        }
        return  response;
    }

    @GetMapping(path="/protected")
    public String accessProtected(){
        return studentService.testingBasicAUthentication();
    }
}
