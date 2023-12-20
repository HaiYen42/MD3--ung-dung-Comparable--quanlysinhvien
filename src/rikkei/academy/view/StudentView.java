package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.StudentController;
import rikkei.academy.model.Student;

import java.util.List;

public class StudentView {
    StudentController studentController = new StudentController();
    List<Student> studentList = studentController.showListStudent();

    public void showTableStudent(){
        System.out.println("************STUDENT MANAGER*************");
        System.out.println("---ID---NAME---AGE---");
        for (int i = 0; i < studentList.size() ; i++) {
            System.out.println("   "+ studentList.get(i).getId()+"   "+studentList.get(i).getName()+"   "+studentList.get(i).getAge());
        }
    }

    public void createStudentForm(){
        while (true){
            int id = studentList.get(studentList.size()-1).getId() +1;
            System.out.println("Enter the name:  ");
            String name = Config.scanner().nextLine();
            System.out.println("Enter the age:  ");
            int age = Config.scanner().nextInt();
            Student student = new Student(id, name, age);
            studentController.createNewStudent(student);
            System.out.println("Create success !");
            System.out.println("Enter any key to continue or quit to backMenu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
                break;
            }
        }
    }
    public void formDeleteStudent(){
        while (true){
            System.out.println("Enter the id of Student you want to delete ");
            int id = Config.scanner().nextInt();
            Student student = studentController.findById(id);
            if (student == null) {
                System.out.println("Item is not exist ");
            }else {
                studentController.deleteStudent(id);
                System.out.println("Delete successful !");
            }
            System.out.println("Enter any key to continue or quit to backMenu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
                break;
            }
        }

    }

    public void editStudent(){
        System.out.println("Enter the id of Student you want to edit");
        int id = Config.scanner().nextInt();
        Student student = studentController.findById(id);
        if (student == null) {
            System.out.println("Student is not exist ");
        }else{
            System.out.println("Enter the new name of student ");
            String name = Config.scanner().nextLine();
            System.out.println("Enter the new age ");
            int age = Config.scanner().nextInt();
            Student student1 = new Student(id, name, age);
            studentController.createNewStudent(student1);
            System.out.println("Edit successful !");
//            System.out.println("Enter any key to back the menu ");
//            String backMenu = Config.scanner().nextLine();
//            new Main();
        }
    }
    public void sortStudent(){
        studentController.sortStudent(studentList);
        System.out.println("Student List after sorting is : ");
        showTableStudent();
        System.out.println("Enter any key to back menu");
        String backMenu = Config.scanner().nextLine();
        new Main();
    }

}
