package rikkei.academy.view;

import rikkei.academy.config.Config;

public class Main {

    StudentView studentView = new StudentView();

    // Tạo Contructor tên là Main
    public Main() {
        System.out.println("***************STUDENT MANAGER**************");
        System.out.println("1. Show List Student ");
        System.out.println("2. Create Student ");
        System.out.println("3. Update Student ");
        System.out.println("4. Delete Student ");
        System.out.println("5. Sort Student By Name ");
        System.out.println("Choose your option ");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu){
            case 1:
                studentView.showTableStudent();
                break;
            case 2:
                studentView.createStudentForm();
                break;
            case 3:
                studentView.editStudent();
                break;
            case 4:
                studentView.formDeleteStudent();
                break;
            case 5:
                studentView.sortStudent();
        }
    }

    public static void main(String[] args) {
        new Main();
    }


}

