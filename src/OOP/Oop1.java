package OOP;

class Student{
    int  rollno;
    String name;
    float marks;
}
public class Oop1 {
    public static void main(String[] args) {
        Student std = new Student();
        std.rollno = 1;
        std.name = "yash";
        std.marks = 44.31f;

        System.out.println(std.rollno);
        System.out.println(std.name);
        System.out.println(std.marks);

        System.out.println(std);
    }
}
