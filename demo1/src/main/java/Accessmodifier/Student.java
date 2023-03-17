package Accessmodifier;

public class Student {
    private String name = "John";
    private String classes = "C02";
    public Student(){}
    public void setName(String name){
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public static void main(String[] args) {
        Student st1 = new Student();
        st1.setName("Hung");
        st1.setClasses("C01");
        System.out.println("Name: " + st1.name + " Class: " + st1.classes);
    }
}
