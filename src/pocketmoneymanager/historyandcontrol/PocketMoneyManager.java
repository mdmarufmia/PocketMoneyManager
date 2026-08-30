/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pocketmoneymanager.historyandcontrol;

import pocketmoneymanager.transactionmanagement.MoneyManager;
import pocketmoneymanager.usermanagement.LoginFrame;
import pocketmoneymanager.usermanagement.UserManager;

/**
 *
 * @author MARUF
 */
public class PocketMoneyManager {

    public static UserManager userManager = new UserManager();

    public static MoneyManager moneyManager = new MoneyManager();

    public static void main(String[] args) {

        userManager.loadUsers();

        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
