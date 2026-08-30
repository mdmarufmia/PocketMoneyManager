/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pocketmoneymanager.transactionmanagement;

/**
 *
 * @author MARUF
 */
public abstract class MoneyRecord {

    private double amount;
    private String description;
    private String date;

    public MoneyRecord(double amount, String description, String date) {

        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Amount: " + amount
                + ", Description: " + description
                + ", Date: " + date;
    }

    public abstract String getRecordType();

}
