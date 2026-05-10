package taxiridebookingsystem_final.newpackage;

public class Taxi extends Vehicle implements Bookable{

    private String color;
    private int year;
    
    public Taxi(String color, int year) {
        this.color = color;
        this.year = year;
    }
    
    public Taxi(String model, String licensePalet, int capacity, String color, int year) {
        super(model, licensePalet, capacity);
        setColor(color);
        setYear(year);
    }

    public Taxi() {
        this("","",0,"",0);
    }
    
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        } else {
            this.color = "Unknown";
        }
        
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        
        if (year > 1900) {
            this.year = year;
        } else {
            this.year = 2000;
        }
        
    }
    
    @Override
    public String toString() {
        return super.toString() + "Taxi{" + "color=" + color + ", year=" + year + '}';
    }
//starting the taxi ride
    public void startRide() {
        System.out.println("Taxi ride started.");
    }
    //calculates the taxi ride fare based on distance.
    @Override
    public double calculateFare(double distance) {
        if (distance > 0) {
            return super.calculateFare(distance) + 5;
        }
        return 0;
    }
    
 // This method is implemented from the Bookable interface.

// It is used to confirm booking a taxi ride.
    @Override
public void book(){

System.out.println("Taxi booked");

}
// This method is implemented from the Bookable interface.
// It is used to cancel a taxi ride.
@Override
public void cancel(){

    System.out.println("Taxi booking cancelled.Fee" + FEE);}
}
