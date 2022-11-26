
package com.SIG.model;


public class Modify {
    private String item;
    private double totalPrice;
    private int count;
    private Invoice invoice;

    public Modify() {
        
    }

    public Modify(String item, double totalPrice, int count) {
        this.item = item;
        this.totalPrice = totalPrice;
        this.count = count;
    }

    public Modify(String item, double totalPrice, int count, Invoice invoice) {
        this.item = item;
        this.totalPrice = totalPrice;
        this.count = count;
        this.invoice = invoice;
    }
    
    public double getLineTotal(){
        return totalPrice*count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Line{" + "invNumber=" + invoice.getInvNum() + ", item=" + item + ", totalPrice=" + totalPrice + ", count=" + count + '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }
        
    public String getSCV() {
        return invoice.getInvNum() + "," + item + "," + totalPrice + "," + count;
    }
    
}
