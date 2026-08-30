/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pocketmoneymanager.usermanagement;

import pocketmoneymanager.usermanagement.User;

/**
 *
 * @author MARUF
 */
public class UserManager {

    private User[] users;
    private int userCount;

    public UserManager() {
        users = new User[100];
        userCount = 0;
    }

    public boolean registerUser(User user) {

        if (userCount >= users.length) {
            return false;
        }

        if (findUser(user.getUsername()) != null) {
            return false;
        }

        users[userCount] = user;
        userCount++;

        return true;
    }

    public User findUser(String username) {

        for (int i = 0; i < userCount; i++) {

            if (users[i].getUsername().equals(username)) {
                return users[i];
            }
        }

        return null;
    }

    public User login(String username, String password) {

        User user = findUser(username);

        if (user != null
                && user.getPassword().equals(password)) {

            return user;
        }

        return null;
    }

    public void saveUsers() {

        try (java.io.PrintWriter writer
                = new java.io.PrintWriter("users.txt")) {

            for (int i = 0; i < userCount; i++) {
                writer.println(users[i]);
            }

        } catch (java.io.FileNotFoundException e) {

            System.out.println("Could not save users.");
        }
    }

    public void loadUsers() {

        java.io.File file = new java.io.File("users.txt");

        if (!file.exists()) {
            return;
        }

        try (java.util.Scanner scanner = new java.util.Scanner(file)) {

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] parts = line.split(",");

                if (parts.length == 3) {

                    User user = new User(
                            parts[0],
                            parts[1],
                            parts[2]
                    );

                    if (userCount < users.length) {
                        users[userCount] = user;
                        userCount++;
                    }
                }
            }

        } catch (java.io.FileNotFoundException e) {

            System.out.println("Could not load users.");
        }
    }
}
