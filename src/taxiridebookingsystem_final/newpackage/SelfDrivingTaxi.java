package taxiridebookingsystem_final.newpackage;

public class SelfDrivingTaxi extends Vehicle {

    private String softwareVersion;
    private String sensorStatus;

    public SelfDrivingTaxi(String model, String licensePalet, int capacity, String softwareVersion, String sensorStatus) {
        super(model, licensePalet, capacity);
        setSoftwareVersion(softwareVersion);
        this.sensorStatus = sensorStatus;
    }

    public SelfDrivingTaxi() {
        this("", "", 0, "", "");
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {

        if (softwareVersion != null && !softwareVersion.isEmpty()) {
            this.softwareVersion = softwareVersion;
        } else {
            this.softwareVersion = "Unknown";
        }
    }

    public String getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(String sensorStatus) {

        if (sensorStatus != null && !sensorStatus.isEmpty()) {
            this.sensorStatus = sensorStatus;
        } else {
            this.sensorStatus = "Inactive";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "SelfDrivingTaxi{" + "softwareVersion=" + softwareVersion + ", sensorStatus=" + sensorStatus + '}';
    }

    public void driveAutomatically() {
        System.out.println("The self driving taxi is now driving automatically");

    }

    @Override
    public double calculateFare(double distance) {
        return super.calculateFare(distance) + 10;
    }

}
