package web.database;

import org.springframework.stereotype.Repository;
import web.domain.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class Database implements StudentDB{
    private List<Student>students =new ArrayList<>();
    private Integer studentID=1;

    @Override
    public Student addNewStudent(Student student){
        if (student.getStudentID()==null){
            student.setStudentID(++studentID);
        }
        students.add(student);
        return  student;
    }

    @Override
    public List<Student> getAllStudents(){
        return students;
    }

    @Override
    public Student getStudentByID(Integer studentID){
        for(Student student:students){
            if (student.getStudentID()==studentID){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student deleteByID(Integer studentID){
        Iterator<Student>iterator=students.iterator();
        while (iterator.hasNext()){
            Student currentStudent=iterator.next();
            if (currentStudent.getStudentID()==studentID){
                iterator.remove();
                return currentStudent;
            }
        }
        return null;
    }

}
