package taxiridebookingsystem_final.newpackage;

public abstract class Person {

    private String name;
    private String phone;
    private int id;

    public Person() {
    }

    public Person(String name, String phone, int id) {
        setName(name);
        setPhone(phone);
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name!");
        } else {
            this.name = name;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        if (phone == null || phone.length() < 10) {
            System.out.println("Invalid phone number!");
        } else {
            this.phone = phone;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if (id <= 0) {
            System.out.println("Invalid ID!");
        } else {
            this.id = id;
        }
    }

    public abstract void displayInfo();
}