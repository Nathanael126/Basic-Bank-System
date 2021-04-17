package com.company;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;
    private String bankName;

    public Bank(String bankName) { this.bankName = bankName; }

    private Customer[] addArray(Customer[] arr, Customer customer, int n){
        Customer[] newarr = new Customer[n+1];
        for (int i = 0; i < n; i++){
            newarr[i] = arr[i];
        }
        newarr[n] = customer;
        return newarr;
    }

    public String getBankName(){ return bankName; }

    public void addCustomer(String f, String l){
        Customer x = new Customer(f,l);
        customers = addArray(customers,x,numberOfCustomers);
        numberOfCustomers++;
    }

    public int getNumberOfCustomers(){ return numberOfCustomers; }

    public Customer getCustomer(int index){ return customers[index-1]; }
}
