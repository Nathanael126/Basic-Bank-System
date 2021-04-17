package com.company;

import java.util.Scanner;

public class Main {

    public static void displayMenu(){
        System.out.println("What would you like to do?\n" +
                "1) Add customer\n" +
                "2) See customers database\n" +
                "3) See customer information\n" +
                "4) Withdraw\n" +
                "5) Deposit\n" +
                "6) Exit\n" +
                "Input: ");
    }
    public static void menu(int selection, Bank bank){
        Scanner scanner = new Scanner(System.in);
        double amt = 0;
        int index = 1;
        switch (selection) {
            case 1:
                System.out.println("Please input");
                System.out.print("First name: ");
                String f = scanner.nextLine();
                System.out.print("Second name: ");
                String l = scanner.nextLine();
                System.out.print("Balance: ");
                amt = scanner.nextDouble();
                if(amt<0){
                    System.out.println("Failed!");
                    break;
                }
                addCustomer(f,l,amt,bank);
                System.out.println("Succes! Customer name: " + bank.getCustomer(bank.getNumberOfCustomers()).getFirstName() + " " + bank.getCustomer(bank.getNumberOfCustomers()).getLastName() + "\nID: " + bank.getNumberOfCustomers() + " Created!");
                break;
            case 2:
                customerDatabase(bank);
                break;
            case 3:
                System.out.print("Input customer id (starting from 1): ");
                index = scanner.nextInt();
                seeCustomerInfo(index,bank);
                break;
            case 4:
                System.out.print("Input customer id: ");
                index = scanner.nextInt();
                System.out.print("Input amount to withdraw: ");
                amt = scanner.nextDouble();
                if (bank.getCustomer(index).getAccount().withdraw(amt)){
                    System.out.println("Success! New balance = " + bank.getCustomer(index).getAccount().getBalance());
                }
                else{
                    System.out.println("Failed to withdraw!");
                }
                break;
            case 5:
                System.out.print("Input customer id: ");
                index = scanner.nextInt();
                System.out.print("Input amount to deposit: ");
                amt = scanner.nextDouble();
                if (bank.getCustomer(index).getAccount().deposit(amt)){
                    System.out.println("Success! New balance = " + bank.getCustomer(index).getAccount().getBalance());
                }
                else{
                    System.out.println("Failed to deposit!");
                }
                break;
            case 6:
                System.out.println("Exiting system");
                System.exit(0);
            default:
                System.out.println("Not an input!");
        }
    }

    public static void addCustomer(String f, String l, double amt, Bank bank){
        bank.addCustomer(f, l);
        bank.getCustomer(bank.getNumberOfCustomers()).setAccount(new Account(amt));
    }

    public static void customerDatabase(Bank bank){
        System.out.println("Number of customers registered in the bank: " + bank.getNumberOfCustomers());
        for (int i = 1; i < bank.getNumberOfCustomers()+1; i++){
            System.out.print(i + ")");
            System.out.println(bank.getCustomer(i).getFirstName() + " " + bank.getCustomer(i).getLastName());
        }
    }

    public static void seeCustomerInfo(int index, Bank bank){
        System.out.println("Name: " + bank.getCustomer(index).getFirstName() + " " + bank.getCustomer(index).getLastName());
        System.out.println("Balance: " + bank.getCustomer(index).getAccount().getBalance() + "$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Bank of BINUS");
        int x = 0;
        while(true){
            displayMenu();
            x = scanner.nextInt();
            menu(x,bank);
        }
    }
}
