package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

import model.Student;
public class StudentDAO{
    public void addStudent(Student student){
        try{
        Connection con=DBConnection.getConnection();
        String sql="INSERT INTO students(name,age) VALUES(?,?)";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,student.getName());
        ps.setInt(2,student.getAge());
        int rows=ps.executeUpdate();
        if(rows>0){
            System.out.println("Student Added Successfully!");
             con.close();
            

        }
        }catch(Exception e){
        e.printStackTrace();
        }
    }
        public void viewStudents(){
            try{
                Connection con=DBConnection.getConnection();
                String sql="SELECT * FROM students";
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    System.out.println("------------------");
                    System.out.println("Id  : "+rs.getInt("id"));
                    System.out.println("Name : "+rs.getString("name"));
                    System.out.println("Age : "+rs.getInt("age"));
                }
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }   
    }
    public void searchStudent(int id){
        try{
            Connection con=DBConnection.getConnection();
            String sql="SELECT * FROM students WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
             if(rs.next()) {
                System.out.println("Id : "+rs.getInt("id"));
                System.out.println("Name : "+rs.getString("name"));
                System.out.println("Age : "+rs.getInt("age"));                
            }else{
                System.out.println("Student not found!");
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        public void updateStudent(int id,String name,int age){
            try{
                Connection con=DBConnection.getConnection();
                String sql="UPDATE students SET name=?, age=? WHERE id=?";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,name);
                ps.setInt(2,age);
                ps.setInt(3,id);
                int row=ps.executeUpdate();
                if(row>0){
                    System.out.println("Student Updated Successfully!"); 
                }else{
                    System.out.println("Student not Found!");
                }
                con.close();
            }catch(Exception e){
                    e.printStackTrace();
                }
        }
        public void deleteStudent(int id){
            try{
                Connection con=DBConnection.getConnection();
                String sql="DELETE FROM students WHERE id=?";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,id);
                int row=ps.executeUpdate();
                if(row>0){
                    System.out.println("Student Deleted Successfully!");
                }else{
                    System.out.println("Student not Found!");
                }
                con.close();

            }catch(Exception e){
                e.printStackTrace();
            }
            

        }
    
    }