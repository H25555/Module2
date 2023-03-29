package QL;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2){
        return o1.getName().compareTo(o2.getName());
    }

    public static void main(String[] args) {
        // a, b, c, d
        String a1 = "aQuang";
        String a2 = "dQuang";
        System.out.println(a1.compareTo(a2));       // -3

        System.out.println(a2.compareTo(a1));       // 3
    }
}
