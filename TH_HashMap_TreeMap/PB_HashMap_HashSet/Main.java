package PB_HashMap_HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Yasuo",20,"Ionia");
        Student st2 = new Student("Akali",21,"Ionia");
        Student st3 = new Student("Darius",22,"Noxus");

        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1,st1);
        studentMap.put(2,st2);
        studentMap.put(3,st3);
        studentMap.put(4,st1);

        for (Map.Entry<Integer, Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println(".........Set");
        Set<Student> students = new HashSet<Student>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st1);

        for (Student student : students){
            System.out.println(student.toString());
        }

    }
}
