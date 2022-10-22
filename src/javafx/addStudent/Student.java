package javafx.addStudent;

public class Student {
    private String name;
    private String email;
    private String address;
    private String phone;
    private int age;

    public Student(String name, String email, String address, String phone, int age) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", address='" + address + '\'' +
                        ", phone='" + phone + '\'' +
                        ", age=" + age;
    }
}
