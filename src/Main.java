public class Main {
    public static void main(String args[]){
        StudentDAO dao=new StudentDAO();
        Student student=new Student(0, "lokeswari", 19);
        dao.addStudent(student);
    }
    
}
