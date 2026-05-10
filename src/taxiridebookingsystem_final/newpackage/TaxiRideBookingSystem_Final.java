

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
                System.out.println("9. Pay for booking");
                System.out.println("10. Rate driver");
                System.out.println("11. Open/launch the GUI");
                System.out.println("12. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        if (people.isEmpty()) {
                            System.out.println("No people available.");
                        } else {
                            for (Person person : people) {
                                
                                System.out.println("Type: " + person.getClass().getSimpleName());
                                person.printSystemName();

                                
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
                        pause(input);
                        break;

                    case 2:
                        for (Person person : people) {
                            if (person instanceof Driver) {
                                person.displayInfo();
                                System.out.println("---------------------------------------------");
                            }
                        }
                        pause(input);
                        break;

                    case 3:
                        if (vehicles.isEmpty()) {
                            System.out.println("Add a vehicle before creating a booking.");
                            pause(input);
                            break;
                        }

                        System.out.print("Customer name: ");
                        String customerName = input.nextLine();
                        if (customerName.trim().isEmpty()) {
                            System.out.println("Invalid input, please try again.");
                            pause(input);
                            break;
                        }

                        System.out.print("Customer phone: ");
                        String customerPhone = input.nextLine();
                        if (customerPhone.length() < 10) {
                            System.out.println("Invalid input, please try again.");
                            pause(input);
                            break;
                        }

                        System.out.print("Customer email: ");
                        String email = input.nextLine();
                        if (!email.contains("@")) {
                            System.out.println("Invalid input, please try again.");
                            pause(input);
                            break;
                        }

                        System.out.print("Pickup location: ");
                        String pickup = input.nextLine();
                        if (pickup.trim().isEmpty()) {
                            System.out.println("Invalid input, please try again.");
                            pause(input);
                            break;
                        }

                        System.out.print("Destination: ");
                        String destination = input.nextLine();
                        if (destination.trim().isEmpty()) {
                            System.out.println("Invalid input, please try again.");
                            pause(input);
                            break;
                        }

                        System.out.print("Distance: ");
                        double distance = Double.parseDouble(input.nextLine());
                        if (distance <= 0) {
                            throw new InvalidBookingException("Distance must be greater than 0.");
                            
    
                        }

                        int customerId = (int) (Math.random() * 9000) + 1000;
                        int bookingId = (int) (Math.random() * 9000) + 1000;
                        int paymentId = (int) (Math.random() * 9000) + 1000;
                        double rating = 5;
                        double fare = vehicles.get(0).calculateFare(distance);

                        Customer customer = new Customer(customerName, customerPhone, customerId, email, rating);
                        Driver driver = new Driver("Ahmed", "0550000000", 2, 4, 30);
                        people.add(customer);
                        people.add(driver);
                        Payment payment = new Payment("Cash", fare, paymentId, "Pending");
                        Booking booking = new Booking(customer, driver, vehicles.get(0), payment, pickup, destination, fare, bookingId, "Pending");
                        booking.book();
                        customer.addBooking(booking);
                        system.addBooking(booking);
                        System.out.println("Booking created successfully");
                        System.out.println("Booking ID: " + bookingId);
                        System.out.println("Expected fare: " + fare);
                        pause(input);
                        break;

                    case 4:
                        System.out.print("Enter booking ID to cancel: ");
                        int cancelId = Integer.parseInt(input.nextLine());
                        if (cancelId <= 0) {
                            System.out.println("Booking ID must be greater than 0.");
                            pause(input);
                            break;
                        }

                        boolean bookingFound = false;
                        for (Booking currentBooking : system.getBookings()) {
                            if (currentBooking.getBookingId() == cancelId) {
                                currentBooking.cancel();
                                system.removeBooking(currentBooking);
                                bookingFound = true;
                                break;
                            }
                        }

                        if (!bookingFound) {
                            System.out.println("Booking not found.");
                        }
                        pause(input);
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
                            pause(input);
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
                        pause(input);
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
                        pause(input);
                        break;

                    case 7:
                        readText();
                        pause(input);
                        break;

                    case 8:
                        writeText();
                        pause(input);
                        break;

                    case 9:
                        System.out.print("Enter booking ID to pay: ");
                        int payBookingId = Integer.parseInt(input.nextLine());

                        boolean paymentFound = false;
                        for (Booking currentBooking : system.getBookings()) {
                            if (currentBooking.getBookingId() == payBookingId) {
                                double bookingFare = currentBooking.getFare();
                                double tax = bookingFare * 0.15;
                                double total = bookingFare + tax;
                                System.out.println("Fare: " + bookingFare);
                                System.out.println("Tax: " + tax);
                                System.out.println("Total: " + total);
                                currentBooking.getPayment().processPayment();
                                System.out.println("Payment completed.");
                                paymentFound = true;
                                break;
                            }
                        }

                        if (!paymentFound) {
                            System.out.println("Booking not found.");
                        }
                        pause(input);
                        break;

                    case 10:
                        System.out.print("Enter driver rating (0 to 5): ");
                        double driverRating = Double.parseDouble(input.nextLine());
                        if (driverRating < 0 || driverRating > 5) {
                            System.out.println("Rating must be between 0 and 5.");
                        } else {
                            System.out.println("Driver rating was submitted.");
                        }
                        pause(input);
                        break;

                    case 11:
                       GUI.main(args);
                        pause(input);
                        break;

                    case 12:
                        System.out.println("Goodbye.");
                        
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        pause(input);
                }
                
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input, please try again.");
                pause(input);
            }
            catch (InvalidBookingException ex) {
             System.err.println(ex.getMessage());
             pause(input);
}
            
            catch (Exception ex) {
                System.err.println("Invalid input, please try again.");
                pause(input);
            }
        } while (choice != 12);

        input.close();
    }

    public static void pause(Scanner input) {
        System.out.println("Press Enter to return to the menu...");
        input.nextLine();
    }

    
     //Saves all bookings to the text file.
     
    public static void writeText()throws FileNotFoundException {
        try {
            Formatter output = new Formatter("booking.txt");
            boolean hasBookings = false;

            for (Booking ele : system.getBookings()) {
                output.format(ele.toString() + "\n");
                output.format("\n---------------------------------------------\n");
                hasBookings = true;
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

    // Reads the text file line by line and prints each line.
 
    public static void readText() throws FileNotFoundException {
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
