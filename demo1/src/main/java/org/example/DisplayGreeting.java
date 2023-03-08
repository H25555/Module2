package org.example;

import java.util.Scanner;

public class DisplayGreeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
    }
}
