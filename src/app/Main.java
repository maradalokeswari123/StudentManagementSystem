package app;
import java.util.Scanner;

import dao.StudentDAO;
import model.Student;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentDAO dao=new StudentDAO();
        
        int choice=0;
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
        System.out.print("Enter your choice: ");
        if(!sc.hasNextInt()){
            System.out.println("Please enter a number");
            sc.nextLine();
            continue;
        }
        
        choice=sc.nextInt();
        if(choice<1 ||  choice>6){
            System.out.println("Invalid choice! please enter 1-6");
            continue;
        }
        
            switch(choice){
            case 1:{
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name=sc.nextLine();
                if(name.trim().isEmpty()){
                    System.out.println("please enter a name.");
                    break;
                }
                if(!name.matches("[a-zA-Z ]+")){
                    System.out.println("Name Should Contain only letters");
                    break;
                }
                
                System.out.print("Enter Age: ");
                
                if(!sc.hasNextInt()){
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                    break;
                }
                int age=sc.nextInt();
                if(age<=0){
                    System.out.println("Age must be greater than 0.");
                    break;
                }
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
                if(!sc.hasNextInt()){
                    System.out.println("please enter a valid ID.");
                    sc.nextLine();
                    break;
                }
                int id=sc.nextInt();
                if(id<=0){
                    System.out.println("Id must be greatre than 0.");
                    break;
                }
                dao.searchStudent(id);
                //System.out.println("search Student selected");
                break;
            }
            case 4:
                {
                    System.out.print("Enter ID: ");
                    if(!sc.hasNextInt()){
                    System.out.println("please enter a valid ID.");
                    sc.nextLine();
                    break;
                }
                int id=sc.nextInt();
                 if(id<=0){
                    System.out.println("Id must be greatre than 0.");
                    break;
                }
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name=sc.nextLine();
                if(name.trim().isEmpty()){
                    System.out.println("Please enter a name.");
                    break;
                }
                if(!name.matches("[a-zA-Z ]+")){
                    System.out.println("Name Should contain only letters");
                    break;
                }
                System.out.print("Enter Age: ");
                 if(!sc.hasNextInt()){
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                    break;
                }
                int age=sc.nextInt();
                if(age<=0){
                    System.out.println("Age must be greater than 0.");
                    break;
                }
                dao.updateStudent(id, name, age);
                //System.out.println("Student update Student ");
                break;
        }
            case 5:{
                System.out.print("Enter ID : ");
                if(!sc.hasNextInt()){
                    System.out.println("please enter a valid ID.");
                    sc.nextLine();
                    break;
                }
                int id=sc.nextInt();
                 if(id<=0){
                    System.out.println("Id must be greatre than 0.");
                    break;
                }
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
