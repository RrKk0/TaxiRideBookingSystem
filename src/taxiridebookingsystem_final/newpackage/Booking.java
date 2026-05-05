
package taxiridebookingsystem_final.newpackage;

public class Booking implements Bookable{
private Customer customer;
private Driver driver;
private Payment payment;
private String pickupLocation;
private String destination;
private double fare;
private int bookingId;
private String status;
private Vehicle vehicle;

public Booking(){}

public Booking(Customer customer, Driver driver, Vehicle vehicle, Payment payment,
String pickupLocation, String destination, double fare, int bookingId,String status){

this.customer = customer;
this.driver = driver;
this.vehicle = vehicle;
this.payment = payment;
this.pickupLocation = pickupLocation;
this.destination = destination;
this.fare = fare;
this.bookingId = bookingId;
this.status = status;

}

public Customer getCustomer() {
    return customer; }

public void setCustomer(Customer customer) {
     this.customer = customer; }

public Driver getDriver() {
     return driver; }


public void setDriver(Driver driver) {
    this.driver = driver; }

public Vehicle getVehicle() {
     return vehicle; }

public void setVehicle(Vehicle vehicle) {
     this.vehicle = vehicle; }

public Payment getPayment() {
    return payment; }

public void setPayment(Payment payment) {
     this.payment = payment; }

public String getPickupLocation() {
    return pickupLocation; }


public void setPickupLocation(String pickupLocation) {
     this.pickupLocation = pickupLocation; }

public String getDestination()
{ return destination; }

public void setDestination(String destination) {
     this.destination = destination; }

public double getFare() {
     return fare; }

public void setFare(double fare) {
    this.fare = fare; }

public int getBookingId() {
    return bookingId; }

public void setBookingId(int bookingId) {
    this.bookingId = bookingId; }

public String getStatus() {
     return status; }

public void setStatus(String status) {
    this.status = status; }

@Override
public void book(){
status="Booked";
System.out.println("Booking confirmed");

}

@Override
public void cancel(){
    status="cancelled";
    System.out.println("Booking cancelled");
}

public String getCustomerName(){
    return customer.getName();
}

public String getVehicleModel(){
    return vehicle.getModel();
}

public String getpaymentMethod(){
    return payment.toString();
}

}
