package rikkei.academy.controller;

import rikkei.academy.model.Student;
import rikkei.academy.service.IStudentService;
import rikkei.academy.service.StudentServiceIMPL;

import java.util.List;

public class StudentController {
    IStudentService studentService = new StudentServiceIMPL();
    public List<Student> showListStudent(){
        return studentService.findAll();
    }
    public void createNewStudent(Student student){
        studentService.save(student);
    }
    public Student findById(int id){
        return studentService.findById(id);
    }
    public void deleteStudent(int id){
        studentService.deleteById(id);
    }
    public void sortStudent(List studentList){
        studentService.sortStudent(studentList);
    }
}
