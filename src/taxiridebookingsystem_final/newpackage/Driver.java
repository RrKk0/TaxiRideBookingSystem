package taxiridebookingsystem_final.newpackage;

public final class  Driver extends Person {

    private int experience;
    private int age;

    public Driver() {
    }

    public Driver(String name, String phone, int id, int experience, int age) {

        super(name, phone, id);
        setExperience(experience);
        setAge(age);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {

        if (experience < 0) {
            System.out.println("Invalid experience!");
        } else {
            this.experience = experience;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 18) {
            System.out.println("Driver age must be 18 or more!");
        } else {
            this.age = age;
        }
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