package org.example.view;

import org.example.model.User;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private UserService userService = new UserService();
    private List<Integer> idArr = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public void showUserAccount() {
        List<User> listUser = userService.getListUser();
        System.out.println("Thong tin tai khoan he thong");
        for(User user:listUser) {
            System.out.print("Id: " + user.getId()); // sua lai giao dien
            System.out.print("Username: " + user.getUsername());
            System.out.println("Phan quyen: " + user.getRole());
            idArr.add(user.getId());
        }
    }
    public void addUserAccount() {
        List<User> listUser = userService.getListUser();
        int id = listUser.get(listUser.size() - 1).getId() + 1;
        System.out.println("Nhap username: ");
        String username = scanner.nextLine();
        System.out.println("Nhap password: ");
        String password = scanner.nextLine();

        int role;
        String roleName = "";
        do {
            System.out.println("Chon quyen (1: Admin, 2: Employee):  ");
            role = scanner.nextInt();
            switch (role) {
                case 1:
                    roleName = "admin";
                    userService.add(new User(id, username, password, roleName));
                    break;
                case 2:
                    roleName = "employee";
                    userService.add(new User(id, username, password, roleName));
                    break;
                default:
                    System.out.println("Khong hop le, vui long nhap lai");
                    break;
            }
        } while (role > 2 || role == 0);

        System.out.println("them thanh cong");
    }

    public void updateUserAccount() {
        showUserAccount();
        int id;
        do {
            System.out.println("Nhap id tai khoan can chinh sua: ");
            id = scanner.nextInt();
        } while(checkExistId(id) == false);
        String username1 = scanner.nextLine();
        System.out.println("Chinh sua username: ");
        String username = scanner.nextLine();
        System.out.println("Chinh sua password: ");
        String password = scanner.nextLine();
        System.out.println("Chinh sua quyen: ");
        int role;
        String roleName = "";
        do {
            System.out.println("Chon quyen (1: Admin, 2: Employee):  ");
            role = scanner.nextInt();
            switch (role) {
                case 1:
                    roleName = "admin";
                    break;
                case 2:
                    roleName = "employee";
                    break;
                default:
                    System.out.println("Khong hop le, vui long nhap lai");
                    break;
            }
        } while (role > 2 || role == 0);
        if (userService.update(id, new User(id, username, password, roleName))) {
            System.out.println("chinh sua thanh cong");
        } else {
            System.out.println("Loi");
        }

    }

    public void deleteUserAccount() {
        showUserAccount();
        int id;
        do {
            System.out.println("Nhap id tai khoan can xoa: ");
            id = scanner.nextInt();
        } while(checkExistId(id) == false);
        if (userService.delete(id)) {
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Loi");
        }
    }
    public boolean checkExistId(int id) {
        for (int idUser:idArr) {
            if (idUser == id) return true;
        }
        return false;
    }
    public void select(){
        do {
            renderView();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("\t➺ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        showUserAccount();
                        break;
                    case 2:
                        addUserAccount();
                        break;
                    case 3:
//                    exitProgram();
                        deleteUserAccount();
                        break;
                    case 4:
                        updateUserAccount();
                        break;
                    case 5:
                        AdminView.select();
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
    public static void renderView() {
        System.out.println();
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ");
        System.out.println("⚪                                               ⚪");
        System.out.println("⚪       1.    Xem danh sách tài khoản           ⚪");
        System.out.println("⚪       2.    Thêm tài khoản                    ⚪");
        System.out.println("⚪       3.    Xóa tài khoản                     ⚪");
        System.out.println("⚪       4.    Sửa tài khoản                     ⚪");
        System.out.println("⚪       5.    Thoát                             ⚪");
        System.out.println("⚪                                               ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ");
    }
}
