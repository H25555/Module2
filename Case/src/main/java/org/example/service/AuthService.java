package org.example.service;

import org.example.model.User;
import org.example.service.impl.AuthServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AuthService implements AuthServiceImpl {
    private final String filename = "src/data/user.csv";
    @Override
    public void signup(User user) {
        List<Integer> listId = new ArrayList<>();
        List<String> listUser = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = null;

            while ((line = br.readLine()) != null){
                listUser.add(line);
                String[] results = line.split(",");
                listId.add(parseInt( results[0]));
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            int id = listId.get(listId.size() - 1) + 1;
            String res = id + "," + user.getUsername() + "," +user.getPassword() + "," + "employee";
            listUser.add(res);

            PrintWriter print = new PrintWriter(filename);
            for (Object item: listUser) {
                print.println(item);
            }
            print.flush();
            print.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean signin(String username, String password) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = null;

            while ((line = br.readLine()) != null){
                String[] results = line.split(",");
                if (results[1].equals(username) && results[2].equals(password)){
                    return true;
                }
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
