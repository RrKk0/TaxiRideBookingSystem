/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxiridebookingsystem_final.newpackage;

/**
 *
 * @author PC
 */
public class Payment {
    private String paymentMethod;
private double amount;
private int paymentId;
private String paymentStatus;

public Payment(){}

public Payment(String paymentMethod, double amount, int paymentId, String paymentStatus){
    this.paymentMethod=paymentMethod;
    this.amount=amount;
    this.paymentId=paymentId;
    this.paymentStatus=paymentStatus;
}

public int getPaymentId() { 
    return paymentId; }

public void setPaymentId(int paymentId) {
     this.paymentId = paymentId; }

public double getAmount() { 
    return amount; }

public void setAmount(double amount) { 
    this.amount = amount; }

public String getPaymentMethod() {
     return paymentMethod; }

public void setPaymentMethod(String paymentMethod) { 
    this.paymentMethod = paymentMethod; }

public String getPaymentStatus() {
     return paymentStatus; }

public void setPaymentStatus(String paymentStatus) {
     this.paymentStatus = paymentStatus;}


public void processPayment(){
    paymentStatus="Paid";
}

public void refundPayment(){
    paymentStatus="Refunded";
}

@Override
public String toString(){
    return "Payment ID: " + paymentId + "Method"+ paymentMethod + "Amount:" + amount + "Status: "+paymentStatus;
}
    
}
