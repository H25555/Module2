package org.example.service;

import org.example.model.Product;
import org.example.model.Role;
import org.example.model.User;
import org.example.service.impl.UserServiceImpl;
import org.example.ultis.CSVUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UserService implements UserServiceImpl {
    private List<User> list = new ArrayList<>();
    private String filename = "src/data/user.csv";
    @Override
    public List<User> getListUser() {
        List<User> newUserList = new ArrayList<>();
        List<String> reads = CSVUtils.read(filename);
        for (String read:reads) {
            String[] user = read.split(",");

            newUserList.add(new User(
                    parseInt(user[0]),
                    user[1],
                    user[2],
                    user[3]
            ));
        }
        return newUserList;
    }

    @Override
    public User getUserDetail(int userId) {
        list = getListUser();
        for (User user: list){
            if (user.getId() == userId){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserDetailByUsername(String userName) {
        list = getListUser();
        for (User user: list){
            if (user.getUsername().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User newUser) {
        list = getListUser();
        list.add(newUser);
        try {
            PrintWriter print = new PrintWriter(filename);
            for (User item: list) {
                String res = item.getId() + "," + item.getUsername() + "," +item.getPassword() + "," + item.getRole();
                print.println(res);
            }
            print.flush();
            print.close();
        } catch (IOException e) {

        }

    }

    @Override
    public boolean update(int userId, User updtUser) {
        list = getListUser();
        for (User user: list){
            if (user.getId() == userId){
                user.setUsername(updtUser.getUsername());
                user.setPassword(updtUser.getPassword());
                user.setRole(updtUser.getRole());

            }

        }
        try {
            PrintWriter print = new PrintWriter(filename);
            for (User item: list) {
                String res = item.getId() + "," + item.getUsername() + "," +item.getPassword() + "," + item.getRole();
                print.println(res);
            }
            print.flush();
            print.close();
            return true;
        } catch (IOException e) {

        }
        return false;
    }

    @Override
    public boolean delete(int userId) {
        list = getListUser();
        User user = this.getUserDetail(userId);
        if (user != null) {
            list.remove(user);
            try {
                PrintWriter print = new PrintWriter(filename);
                for (User item: list) {
                    String res = item.getId() + "," + item.getUsername() + "," +item.getPassword() + "," + item.getRole();
                    print.println(res);
                }
                print.flush();
                print.close();
                return true;
            } catch (IOException e) {

            }
            return true;
        }
        return false;
    }
}
