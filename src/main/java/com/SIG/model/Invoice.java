
package com.SIG.model;

import java.util.ArrayList;

public class Invoice {
    private int invNum;
    private String invDate;
    private String customer;
    private ArrayList<Modify> lines;
    private int invNumLab;
   

    public Invoice(int invNum, String invDate, String customer) {
        this.invNum = invNum;
        this.invDate = invDate;
        this.customer = customer;
    }
    
    public double getInvTotal(){
        double total = 0.0;
        for (Modify line : getLines()){
            total += line.getLineTotal();
        }
    return total;
    
    }
    public ArrayList<Modify> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }


    public Invoice() {
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public String getInvDate() {
        return invDate;
    }

    public void setInvDate(String invDate) {
        this.invDate = invDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invNum=" + invNum + ", invDate=" + invDate + ", customer=" + customer + '}';
    }
    
    public String getSCV() {
        return invNum + "," + invDate + "," + customer;
    }
}
