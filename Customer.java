public final class Customer extends Person {
    private String email;
    private double rating;

    public Customer() {
    }

    public Customer(String name, String phone, int id, String email, double rating) {
        super(name, phone, id);
        this.email = email;
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
