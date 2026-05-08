package taxiridebookingsystem_final.newpackage;

public class Payment {

    private String paymentMethod;
    private double amount;
    private int paymentId;
    private String paymentStatus;

    public Payment() {
    }

    public Payment(String paymentMethod, double amount, int paymentId, String paymentStatus) {
        setPaymentMethod( paymentMethod);
        setAmount( amount);
       setPaymentId(paymentId);
       setPaymentStatus( paymentStatus);

    }

    public int getPaymentId() {
        return paymentId;
    }
    
    public void setPaymentId(int paymentId) {
        if (paymentId > 0) {
            this.paymentId = paymentId;
        } else {
            System.out.println("Invalid payment ID! ID must be a positive number.");
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("Invalid amount! Amount must be greater than 0.");
        }
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod.equals("Cash") || paymentMethod.equals("Credit Card") || paymentMethod.equals("Debit Card")) {
            this.paymentMethod = paymentMethod;
        } else {
            System.out.println("Invalid payment method! Please enter: Cash, Credit Card, or Debit Card.");
        }
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        if (paymentStatus.equals("Pending") || paymentStatus.equals("Completed") || paymentStatus.equals("Refunded")) {
            this.paymentStatus = paymentStatus;
        } else {
            System.out.println("Invalid status! Please enter: Pending, Completed, or Refunded.");
        }}


public void processPayment() {
        paymentStatus = "Paid";
    }

    public void refundPayment() {
        paymentStatus = "Refunded";
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentId + "Method" + paymentMethod + "Amount:" + amount + "Status: " + paymentStatus;
    }

}
