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

    public void startRide() {
        System.out.println("Taxi ride started.");
    }
    
    @Override
    public double calculateFare(double distance) {
        if (distance > 0) {
            return super.calculateFare(distance) + 5;
        }
        return 0;
    }
    @Override
public void book(){

System.out.println("Taxi booked");

}

@Override
public void cancel(){

    System.out.println("Taxi booking cancelled.Fee" + FEE);}
}
