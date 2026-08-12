public class Main {
    public static void main(String args[]){
        StudentDAO dao=new StudentDAO();
        //Student student=new Student(0, "Divya", 17);
        //dao.addStudent(student);
        //dao.viewStudents();
        dao.searchStudent(10);
    }
    
}
