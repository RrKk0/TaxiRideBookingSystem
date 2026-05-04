public class Driver extends Person {
    private int experience;
    private int age;

    public Driver() {
    }

    public Driver(String name, String phone, int id, int experience, int age) {
        super(name, phone, id);
        this.experience = experience;
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void drive() {
        System.out.println("Driver is driving...");
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getId());
        System.out.println("Experience: " + experience);
        System.out.println("Age: " + age);
    }
}
