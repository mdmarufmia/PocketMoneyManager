/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pocketmoneymanager.transactionmanagement;

/**
 *
 * @author MARUF
 */
public class Expense extends MoneyRecord {

    public Expense(double amount, String description, String date) {
        super(amount, description, date);
    }

    @Override
    public String getRecordType() {
        return "Expense";
    }
}
