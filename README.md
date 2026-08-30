# Pocket Money Manager

A Java-based desktop application for managing pocket money, allowances, expenses, and transactions.

## About the Project

Pocket Money Manager is a desktop application developed using Java and NetBeans.
It provides a simple graphical interface for users to manage their pocket money,
record allowances and expenses, and view and edit transaction history.

## Features

- User Registration
- User Login
- Dashboard
- Add Allowance
- Add Expense
- Transaction History
- Edit Transactions
- Money/Balance Management

## Technologies Used

- Java
- Java Swing
- NetBeans IDE
- GUI Builder
- Object-Oriented Programming (OOP)

## Project Structure

```text
src/
└── pocketmoneymanager/
    ├── dashboardandinput/
    │   ├── AddAllowanceFrame
    │   ├── AddExpenseFrame
    │   └── DashboardFrame
    │
    ├── historyandcontrol/
    │   ├── EditTransactionFrame
    │   ├── HistoryFrame
    │   └── PocketMoneyManager
    │
    ├── transactionmanagement/
    │   ├── Allowance
    │   ├── Expense
    │   ├── MoneyManager
    │   └── MoneyRecord
    │
    └── usermanagement/
        ├── LoginFrame
        ├── RegisterFrame
        ├── User
        └── UserManager
