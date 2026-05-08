package taxiridebookingsystem_final.newpackage;

public class Booking implements Bookable {

    private Customer customer;
    private Driver driver;
    private Payment payment;
    private String pickupLocation;
    private String destination;
    private double fare;
    private int bookingId;
    private String status;
    private Vehicle vehicle;
    private static int bookingCount = 0;

    public Booking() {
    }

    public Booking(Customer customer, Driver driver, Vehicle vehicle, Payment payment,
            String pickupLocation, String destination, double fare, int bookingId, String status) {

        setCustomer(customer);
        setDriver(driver);
        setVehicle(vehicle);
        setPayment(payment);
        setPickupLocation(pickupLocation);
        setDestination(destination);
        setFare(fare);
        setBookingId(bookingId);
        setStatus(status);
        bookingCount++;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            this.vehicle = vehicle;
        } else {
            System.out.println("Invalid vehicle! Vehicle cannot be null.");
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setcustomer(Customer customer) {
        if (customer != null) {
            this.customer = customer;
        } else {
            System.out.println("Invalid customer! Customer cannot be null.");
        }
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void book() {
        status = "Booked";
        System.out.println("Booking confirmed");

    }

    @Override
    public void cancel() {
        status = "cancelled";
        System.out.println("Booking cancelled.FEE" + FEE);
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getVehicleModel() {
        return vehicle.getModel();
    }

    public String getpaymentMethod() {
        return payment.toString();
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        } else {
            System.out.println("Invalid payment! Payment cannot be null.");
        }
    }

    public void setPickupLocation(String pickupLocation) {
        if (pickupLocation.isEmpty()) {
            System.out.println("Invalid pickup location! It cannot be empty.");
        } else if (pickupLocation.equals(destination)) {
            System.out.println("Invalid pickup location! It cannot be the same as the destination.");
        } else {
            this.pickupLocation = pickupLocation;
        }
    }

    public void setFare(double fare) {
        if (fare >= 0) {
            this.fare = fare;
        } else {
            System.out.println("Invalid fare! Fare cannot be negative.");
        }
    }

    public void setBookingId(int bookingId) {
        if (bookingId > 0) {
            this.bookingId = bookingId;
        } else {
            System.out.println("Invalid booking ID! ID must be a positive number.");
        }
    }

    public void setStatus(String status) {
        if (status.equals("Pending") || status.equals("Confirmed")
                || status.equals("Cancelled") || status.equals("Completed")) {
            this.status = status;
        } else {
            System.out.println("Invalid status! Please enter: Pending, Confirmed, Cancelled, or Completed.");
        }
    }

}
