package taxiridebookingsystem_final.newpackage;

import java.util.ArrayList;

public class BookingManagementSystem {

    private ArrayList<Booking> bookings;
    private ArrayList<Vehicle> vehicles;

    public BookingManagementSystem() {

        bookings = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public BookingManagementSystem(ArrayList<Booking> bookings, ArrayList<Vehicle> vehicles) {

        this.bookings = bookings;
        this.vehicles = vehicles;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public void displayAllBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {

            for (Booking booking : bookings) {
                System.out.println(booking);
            }
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

    @Override
    public String toString() {
        return "BookingManagementSystem{" + "bookings=" + bookings + ", vehicles=" + vehicles + '}';
    }
}