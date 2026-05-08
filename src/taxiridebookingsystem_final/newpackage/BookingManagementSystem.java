
package taxiridebookingsystem_final.newpackage;

public class BookingManagementSystem {
    private Booking[] bookings;
    private Vehicle[] vehicles;
    private int totalSystemBooking;
    public BookingManagementSystem() {
        bookings = new Booking[100];
        vehicles = new Vehicle[100];
        totalSystemBooking = 0;
    }
    public BookingManagementSystem(Booking[] bookings, Vehicle[] vehicles, int totalSystemBooking) {
        this.bookings = bookings;
        this.vehicles = vehicles;
        this.totalSystemBooking = totalSystemBooking;
    }
    public void addBooking(Booking booking) {

        for (int i = 0; i < bookings.length; i++) {

            if (bookings[i] == null) {
                bookings[i] = booking;
                totalSystemBooking++;
                break;
            }
        }
    }
    public void removeBooking(Booking booking) {

        for (int i = 0; i < bookings.length; i++) {

            if (bookings[i] == booking) {
                bookings[i] = null;
                totalSystemBooking--;
                break;
            }
        }
    }
    public void displayAllBookings() {

        boolean isEmpty = true;

        for (Booking booking : bookings) {

            if (booking != null) {
                System.out.println(booking);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("No bookings available.");
        }
    }
    public void addVehicle(Vehicle vehicle) {

        for (int i = 0; i < vehicles.length; i++) {

            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                break;
            }
        }
    }
    public void removeVehicle(Vehicle vehicle) {

        for (int i = 0; i < vehicles.length; i++) {

            if (vehicles[i] == vehicle) {
                vehicles[i] = null;
                break;
            }
        }
    }
    public Booking[] getBookings() {
        return bookings;
    }
    public Vehicle[] getVehicles() {
        return vehicles;
    }
    public int getTotalSystemBookings() {
        return totalSystemBooking;
    }

    @Override
    public String toString() {
        return "BookingManagementSystem{" +
                "totalSystemBooking=" + totalSystemBooking +
                '}';
    }
}