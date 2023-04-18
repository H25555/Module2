package org.example.view;

import org.example.model.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static LoginView loginview = new LoginView();
    static AdminView adminView = new AdminView();
    static EmployeeView employeeView = new EmployeeView();
    static Scanner scanner = new Scanner(System.in);
    private boolean isLoginned = false;


    public void login(){
//        setisLoginned(loginview.login());
        this.isLoginned = loginview.login();
        if (this.isLoginned == true){
//            System.out.println("oke");
            if (loginview.checkRole().equals("admin")){
//                System.out.println("admin");
                adminView.select();
            } else {
//                System.out.println("user");
                employeeView.select();
            }
        } else {
            System.out.println("Vui lòng nhập lại, tài khoản hoặc mật khẩu sai!");
        }
    }
    public void signup(){
        loginview.signup();
    }
    public void select(){
        do {
            menuMain();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("\t➺ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        login();
                        break;
                    case 2:
                        signup();
                        break;
                    case 3:
                        exitProgram();
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
    public static void menuMain() {
        System.out.println();
        System.out.println("         Coffee Manage App");
        System.out.println();
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
        System.out.println("⚪                              ⚪");
        System.out.println("⚪       1.    Đăng nhập        ⚪");
        System.out.println("⚪       2.    Đăng ký          ⚪");
        System.out.println("⚪       3.    Thoát            ⚪");
        System.out.println("⚪                              ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");

    }
    public static void exitProgram() {

        System.exit(0);
    }
}
