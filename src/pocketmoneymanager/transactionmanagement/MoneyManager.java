/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pocketmoneymanager.transactionmanagement;

import pocketmoneymanager.transactionmanagement.MoneyRecord;
import pocketmoneymanager.transactionmanagement.Expense;
import pocketmoneymanager.transactionmanagement.Allowance;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author MARUF
 */
public class MoneyManager {

    private MoneyRecord[] records;
    private int recordCount;
    private String currentUsername;

    public MoneyManager() {
        records = new MoneyRecord[100];
        recordCount = 0;
        currentUsername = "";
    }

    public boolean addRecord(MoneyRecord record) {

        if (recordCount >= records.length) {
            return false;
        }

        records[recordCount] = record;
        recordCount++;

        saveRecords();

        return true;
    }

    public double getBalance() {

        double balance = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i] instanceof Allowance) {
                balance += records[i].getAmount();

            } else if (records[i] instanceof Expense) {
                balance -= records[i].getAmount();
            }
        }

        return balance;
    }

    public double getTotalAllowance() {

        double total = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i] instanceof Allowance) {
                total += records[i].getAmount();
            }
        }

        return total;
    }

    public double getTotalExpenses() {

        double total = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i] instanceof Expense) {
                total += records[i].getAmount();
            }
        }

        return total;
    }

    public MoneyRecord[] getRecords() {
        return records;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public boolean deleteRecord(int index) {

        if (index < 0 || index >= recordCount) {
            return false;
        }

        // Move all records after the deleted record one position forward
        for (int i = index; i < recordCount - 1; i++) {
            records[i] = records[i + 1];
        }

        // Remove the last duplicate reference
        records[recordCount - 1] = null;

        recordCount--;

        // Save the updated transactions
        saveRecords();

        return true;
    }

    public boolean updateRecord(
            int index,
            double amount,
            String description,
            String date) {

        if (index < 0 || index >= recordCount) {
            return false;
        }

        MoneyRecord oldRecord = records[index];

        if (oldRecord instanceof Allowance) {

            records[index] = new Allowance(
                    amount,
                    description,
                    date
            );

        } else if (oldRecord instanceof Expense) {

            records[index] = new Expense(
                    amount,
                    description,
                    date
            );

        } else {

            return false;
        }

        saveRecords();

        return true;
    }

    public void setCurrentUser(String username) {

        currentUsername = username;

        // Clear old user's transactions
        records = new MoneyRecord[100];
        recordCount = 0;

        // Load this user's saved transactions
        loadRecords();
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    private String getFileName() {
        return "transactions_" + currentUsername + ".txt";
    }

    private void saveRecords() {

        if (currentUsername == null || currentUsername.isEmpty()) {
            return;
        }

        try (PrintWriter writer
                = new PrintWriter(new File(getFileName()))) {

            for (int i = 0; i < recordCount; i++) {

                MoneyRecord record = records[i];

                writer.println(
                        record.getRecordType() + "|"
                        + record.getAmount() + "|"
                        + record.getDescription() + "|"
                        + record.getDate()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error saving transactions: "
                    + e.getMessage()
            );
        }
    }

    private void loadRecords() {

        if (currentUsername == null || currentUsername.isEmpty()) {
            return;
        }

        File file = new File(getFileName());

        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()
                    && recordCount < records.length) {

                String line = scanner.nextLine();

                String[] parts = line.split("\\|", -1);

                if (parts.length != 4) {
                    continue;
                }

                String type = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String description = parts[2];
                String date = parts[3];

                if (type.equals("Allowance")) {

                    records[recordCount]
                            = new Allowance(
                                    amount,
                                    description,
                                    date
                            );

                    recordCount++;

                } else if (type.equals("Expense")) {

                    records[recordCount]
                            = new Expense(
                                    amount,
                                    description,
                                    date
                            );

                    recordCount++;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error loading transactions: "
                    + e.getMessage()
            );
        }
    }

}
