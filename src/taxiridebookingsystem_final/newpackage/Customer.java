package taxiridebookingsystem_final.newpackage;

public final class Customer extends Person {

    private String email;
    private double rating;
    private Booking[] bookings;

    public Customer() {
        bookings = new Booking[10];
    }

    public Customer(String name, String phone, int id,
            String email, double rating) {

        super(name, phone, id);
        setEmail(email);
        setRating(rating);

        bookings = new Booking[10];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || !email.contains("@")) {
            System.out.println("Invalid email!");
        } else {
            this.email = email;
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {

        if (rating < 0 || rating > 5) {
            System.out.println("Rating must be between 0 and 5!");
        } else {
            this.rating = rating;
        }
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {

        for (int i = 0; i < bookings.length; i++) {

            if (bookings[i] == null) {
                bookings[i] = booking;
                break;
            }
        }
    }

    @Override
    public void displayInfo() {

        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getId());
        System.out.println("Email: " + email);
        System.out.println("Rating: " + rating);
    }
}