package org.example;

import java.util.Scanner;

public class ChangeCurrency {
    public static void main(String[] args) {
        double rate = 23000;
        System.out.println("USD: ");
        Scanner scanner = new Scanner(System.in);
        double USD = scanner.nextDouble();
        double VND = USD*rate;
        System.out.println("VND: "+VND);
    }
}
