
package taxiridebookingsystem_final.newpackage;
import java.util.ArrayList;

public class BookingMangmentSystem {
    
 

    private ArrayList<Booking> bookings;
    private ArrayList<Vehicle> vehicles;
    private int totalSystemBooking;
    public BookingMangmentSystem() {
        bookings = new ArrayList<>();
        vehicles = new ArrayList<>();
        totalSystemBooking = 0;
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
        totalSystemBooking++;
    }

    public void removeBooking(Booking booking) {
        if (bookings.remove(booking)) {
            totalSystemBooking--;
        }
    }

    public void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getTotalSystemBookings() {
        return totalSystemBooking;
    }
}

