package org.example.view;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.AuthService;
import org.example.service.UserService;

import java.util.Scanner;

public class LoginView {
    private AuthService authService = new AuthService();
    private UserService userService = new UserService();
    private User user = new User();
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        boolean checkLogin = authService.signin(username, password);
        user = userService.getUserDetailByUsername(username);
        return checkLogin;
    }
    public void signup(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        authService.signup(user);
    }
    public String checkRole(){
        return user.getRole();
    }
}
