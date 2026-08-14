package app;
import java.util.Scanner;

import dao.StudentDAO;
import model.Student;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentDAO dao=new StudentDAO();
        
        int choice;
        do{
            System.out.println("-----------------------------");
        System.out.println("  STUDENT MANAGEMENT SYSTEM                            ");
        System.out.println("-----------------------------");
        System.out.println("1.Add Student");
        System.out.println("2.View Student");
        System.out.println("3.Serach Student");
        System.out.println("4.Update Student");
        System.out.println("5.Delete Student");
        System.out.println("6.Exit");
        System.out.println("Enter your choice: ");
        
        choice=sc.nextInt();
        
            switch(choice){
            case 1:{
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name=sc.nextLine();
                System.out.print("Enter Age: ");
                int age=sc.nextInt();
                Student student=new Student(0,name,age);
                dao.addStudent(student);
                // System.out.println("Added Student successfully!");
                break;
            }
            case 2:
                dao.viewStudents();
                // System.out.println("view Student selected");
                break;
            case 3:{
                System.out.print("Enter User Id: ");
                int id=sc.nextInt();
                dao.searchStudent(id);
                //System.out.println("search Student selected");
                break;
            }
            case 4:
                {
                    System.out.print("Enter ID: ");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name=sc.nextLine();
                System.out.print("Enter Age: ");
                int age=sc.nextInt();
                dao.updateStudent(id, name, age);
                //System.out.println("Student update Student ");
                break;
        }
            case 5:{
                System.out.print("Enter ID : ");
                int id=sc.nextInt();
                dao.deleteStudent(id);
                break;
            }
                
            case 6:
                System.out.print("Thank You!");
                break;
                default:
                    System.out.print("default choice!");
                    break;
        }
        
        //Student student=new Student(0, "Divya", 17);
        //dao.addStudent(student);
        //dao.viewStudents();
        //dao.searchStudent(10);
        //dao.updateStudent(1, "Lokeswari", 19);
        //dao.deleteStudent(5);
        }while (choice!=6);
        sc.close();
    }
    
}
