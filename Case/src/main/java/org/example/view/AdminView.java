package org.example.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {
    static ProductView productView = new ProductView();
    static UserView userView = new UserView();
    static Menu menu = new Menu();
    static Scanner scanner = new Scanner(System.in);

    public static void select(){
        do {
            selectAdminView();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("\t➺ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        userView.select();
                        return;
                    case 2:
                        productView.select();
                        break;
                    case 3:
                        menu.select();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        select();
                        break;
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    public static void selectAdminView() {
        System.out.println();
        System.out.println("                       ADMIN                   ");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
        System.out.println("⚪                                              ⚪");
        System.out.println("⚪                                              ⚪");
        System.out.println("⚪            1.   Quản lý tài khoản            ⚪");
        System.out.println("⚪            2.   Quản lý sản phầm             ⚪");
        System.out.println("⚪            3.   Đăng xuất                    ⚪");
        System.out.println("⚪                                              ⚪");
        System.out.println("⚪                                              ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
    }
}
