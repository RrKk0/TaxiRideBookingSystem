
package taxiridebookingsystem_final.newpackage;

public class Vehicle {
    private String model;
    private String licensePlate;
    private int capacity;
    protected final static double RatePerKm=3.5;
    
    
    
    public Vehicle(){
    
    this(" "," ",0);
    }

    public Vehicle(String model, String licensePalet, int capacity) {
        this.model = model;
        this.licensePlate = licensePalet;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePalet() {
        return licensePlate;
    }

    public void setLicensePalet(String licensePalet) {
        this.licensePlate = licensePalet;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
      
    public double calculateFare(double distance){
    
    return distance * RatePerKm;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model=" + model + ", licensePlate=" + licensePlate + ", capacity=" + capacity + '}';
    }
    
    
   
    
}
