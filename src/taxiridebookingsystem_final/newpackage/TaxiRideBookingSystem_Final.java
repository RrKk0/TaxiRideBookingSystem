

package taxiridebookingsystem_final.newpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaxiRideBookingSystem_Final {

    static BookingManagementSystem system = new BookingManagementSystem();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        // Subclass objects are stored using the superclass type to show polymorphism.
        people.add(new Customer("Sara", "0500000000", 1, "sara@gmail.com", 5));
        people.add(new Driver("Ahmed", "0550000000", 2, 4, 30));
        vehicles.add(new Taxi("Toyota Camry", "TX-100", 4, "White", 2023));
        vehicles.add(new SelfDrivingTaxi("Tesla Model Y", "SD-200", 4, "1.0", "Active"));

        for (Vehicle vehicle : vehicles) {
            system.addVehicle(vehicle);
        }

        int choice = 0;

        do {
            try {
                System.out.println("\n===== Taxi Ride Booking System =====");
                System.out.println("1. Display all people");
                System.out.println("2. Display drivers only");
                System.out.println("3. Create a booking");
                System.out.println("4. Cancel a booking");
                System.out.println("5. Add a vehicle");
                System.out.println("6. Remove a vehicle");
                System.out.println("7. Read from a text file");
                System.out.println("8. Write to a text file");
                System.out.println("9. Open/launch the GUI");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        if (people.isEmpty()) {
                            System.out.println("No people available.");
                        } else {
                            for (Person person : people) {
                                // getClass is a final method inherited from Object.
                                System.out.println("Type: " + person.getClass().getSimpleName());
                                person.printSystemName();

                                // displayInfo is abstract in Person and is implemented by subclasses.
                                person.displayInfo();

                                if (person instanceof Driver) {
                                    Driver driver = (Driver) person;
                                    driver.drive();
                                } else if (person instanceof Customer) {
                                    Customer customer = (Customer) person;
                                    System.out.println("Customer email: " + customer.getEmail());
                                }
                                System.out.println("---------------------------------------------");
                            }
                        }
                        break;

                    case 2:
                        for (Person person : people) {
                            if (person instanceof Driver) {
                                person.displayInfo();
                                System.out.println("---------------------------------------------");
                            }
                        }
                        break;

                    case 3:
                        if (vehicles.isEmpty()) {
                            System.out.println("Add a vehicle before creating a booking.");
                            break;
                        }

                        System.out.print("Customer name: ");
                        String customerName = input.nextLine();
                        System.out.print("Customer phone: ");
                        String customerPhone = input.nextLine();
                        System.out.print("Customer ID: ");
                        int customerId = Integer.parseInt(input.nextLine());
                        if (customerId <= 0) {
                            System.out.println("ID must be greater than 0.");
                            break;
                        }

                        System.out.print("Customer email: ");
                        String email = input.nextLine();
                        System.out.print("Customer rating (0 to 5): ");
                        double rating = Double.parseDouble(input.nextLine());

                        System.out.print("Driver name: ");
                        String driverName = input.nextLine();
                        System.out.print("Driver phone: ");
                        String driverPhone = input.nextLine();
                        System.out.print("Driver ID: ");
                        int driverId = Integer.parseInt(input.nextLine());
                        if (driverId <= 0) {
                            System.out.println("ID must be greater than 0.");
                            break;
                        }

                        System.out.print("Driver experience: ");
                        int experience = Integer.parseInt(input.nextLine());
                        System.out.print("Driver age: ");
                        int age = Integer.parseInt(input.nextLine());

                        System.out.print("Pickup location: ");
                        String pickup = input.nextLine();
                        System.out.print("Destination: ");
                        String destination = input.nextLine();
                        System.out.print("Distance: ");
                        double distance = Double.parseDouble(input.nextLine());
                        if (distance <= 0) {
                            System.out.println("Distance must be greater than 0.");
                            break;
                        }
                        System.out.println("Calculated fare for the first vehicle: " + vehicles.get(0).calculateFare(distance));
                        System.out.print("Fare: ");
                        double fare = Double.parseDouble(input.nextLine());
                        if (fare <= 0) {
                            System.out.println("Fare must be greater than 0.");
                            break;
                        }

                        System.out.print("Booking ID: ");
                        int bookingId = Integer.parseInt(input.nextLine());
                        if (bookingId <= 0) {
                            System.out.println("Booking ID must be greater than 0.");
                            break;
                        }

                        System.out.print("Payment ID: ");
                        int paymentId = Integer.parseInt(input.nextLine());
                        if (paymentId <= 0) {
                            System.out.println("Payment ID must be greater than 0.");
                            break;
                        }

                        Customer customer = new Customer(customerName, customerPhone, customerId, email, rating);
                        Driver driver = new Driver(driverName, driverPhone, driverId, experience, age);
                        people.add(customer);
                        people.add(driver);
                        Payment payment = new Payment("Cash", fare, paymentId, "Pending");
                        Booking booking = new Booking(customer, driver, vehicles.get(0), payment, pickup, destination, fare, bookingId, "Pending");
                        booking.book();
                        system.addBooking(booking);
                        System.out.println("Booking added.");
                        break;

                    case 4:
                        System.out.print("Enter booking ID to cancel: ");
                        int cancelId = Integer.parseInt(input.nextLine());
                        if (cancelId <= 0) {
                            System.out.println("Booking ID must be greater than 0.");
                            break;
                        }

                        boolean bookingFound = false;
                        for (Booking currentBooking : system.getBookings()) {
                            if (currentBooking != null && currentBooking.getBookingId() == cancelId) {
                                currentBooking.cancel();
                                system.removeBooking(currentBooking);
                                bookingFound = true;
                                break;
                            }
                        }

                        if (!bookingFound) {
                            System.out.println("Booking not found.");
                        }
                        break;

                    case 5:
                        System.out.println("1. Taxi");
                        System.out.println("2. Self-driving taxi");
                        System.out.print("Choose vehicle type: ");
                        int vehicleType = Integer.parseInt(input.nextLine());

                        System.out.print("Model: ");
                        String model = input.nextLine();
                        System.out.print("License plate: ");
                        String licensePlate = input.nextLine();
                        System.out.print("Capacity: ");
                        int capacity = Integer.parseInt(input.nextLine());
                        if (capacity <= 0) {
                            System.out.println("Capacity must be greater than 0.");
                            break;
                        }

                        if (vehicleType == 1) {
                            System.out.print("Color: ");
                            String color = input.nextLine();
                            System.out.print("Year: ");
                            int year = Integer.parseInt(input.nextLine());
                            Vehicle taxi = new Taxi(model, licensePlate, capacity, color, year);
                            vehicles.add(taxi);
                            system.addVehicle(taxi);
                            System.out.println("Taxi added.");
                        } else if (vehicleType == 2) {
                            System.out.print("Software version: ");
                            String softwareVersion = input.nextLine();
                            System.out.print("Sensor status: ");
                            String sensorStatus = input.nextLine();
                            Vehicle selfDrivingTaxi = new SelfDrivingTaxi(model, licensePlate, capacity, softwareVersion, sensorStatus);
                            vehicles.add(selfDrivingTaxi);
                            system.addVehicle(selfDrivingTaxi);
                            System.out.println("Self-driving taxi added.");
                        } else {
                            System.out.println("Invalid vehicle type.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter vehicle number to remove (starting from 1): ");
                        int vehicleNumber = Integer.parseInt(input.nextLine());
                        if (vehicleNumber <= 0 || vehicleNumber > vehicles.size()) {
                            System.out.println("Invalid vehicle number.");
                        } else {
                            Vehicle removedVehicle = vehicles.remove(vehicleNumber - 1);
                            system.removeVehicle(removedVehicle);
                            System.out.println("Vehicle removed.");
                        }
                        break;

                    case 7:
                        readText();
                        break;

                    case 8:
                        writeText();
                        break;

                    case 9:
                       GUI.main(args);
                        break;

                    case 10:
                        System.out.println("Goodbye.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception ex) {
                System.err.println("Invalid input. Please try again.");
                System.err.println(ex);
            }
        } while (choice != 10);

        input.close();
    }

    /**
     * Saves all bookings to the text file.
     */
    public static void writeText() {
        try {
            Formatter output = new Formatter("booking.txt");
            boolean hasBookings = false;

            for (Booking ele : system.getBookings()) {
                if (ele != null) {
                    output.format(ele.toString() + "\n");
                    output.format("\n---------------------------------------------\n");
                    hasBookings = true;
                }
            }

            if (hasBookings) {
                System.out.println("All bookings saved to the text file booking.txt");
            } else {
                System.out.println("No bookings yet.");
            }
            output.close();
        } catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");
            System.err.println(ex);
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
            System.err.println(ex);
        }
    }

    /**
     * Reads the text file line by line and prints each line.
     */
    public static void readText() {
        try {
            Scanner fileIn = new Scanner(new File("booking.txt"));
            while (fileIn.hasNextLine()) {
                System.out.println(fileIn.nextLine());
            }
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
            System.err.println(ex);
        } catch (NoSuchElementException ex) {
            System.err.println("File improperly formed.");
            System.err.println(ex);
        } catch (IllegalStateException ex) {
            System.err.println("Error reading from file.");
            System.err.println(ex);
        }
    }
}
