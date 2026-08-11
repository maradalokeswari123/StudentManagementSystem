import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection{
    public static Connection getConnection(){
        try{
            Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db",
                "root",
                ""
            );
            return con;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}