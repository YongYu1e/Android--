package com.example.curriculum.javabean;

public class Success {
    private String successid;
    private String successname;
    private String classroom;
    private String teacher;
    private String time;

    public Success()
    {

    }

    public Success(String successid,String successname,String classroom,String teacher,String time)
    {
        this.successid = successid;
        this.successname = successname;
        this.classroom = classroom;
        this.teacher = teacher;
        this.time = time;
    }

    public String getSuccessid() {
        return successid;
    }

    public void setSuccessid(String successid) {
        this.successid = successid;
    }

    public String getSuccessname() {
        return successname;
    }

    public void setSuccessname(String successname) {
        this.successname = successname;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
