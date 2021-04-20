package web.domain;

import javax.validation.constraints.Size;

public class Student {
    private Integer studentID;

    @Size(min = 2,message = "please enter the valid name")
    private String name;

    public Student(Integer studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
