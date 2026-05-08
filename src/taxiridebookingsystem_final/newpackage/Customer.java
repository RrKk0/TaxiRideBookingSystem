package taxiridebookingsystem_final.newpackage;

public final class Customer extends Person {

    private String email;
    private double rating;

    public Customer() {
    }

    public Customer(String name, String phone, int id, String email, double rating) {

        super(name, phone, id);
        setEmail(email);
        setRating(rating);
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

    @Override
    public void displayInfo() {

        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getId());
        System.out.println("Email: " + email);
        System.out.println("Rating: " + rating);
    }
}