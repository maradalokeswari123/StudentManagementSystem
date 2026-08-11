import java.sql.Connection;
import java.sql.PreparedStatement;
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
       
        

    }