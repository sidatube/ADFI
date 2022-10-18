package phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    private String name;
    private List<String> phones;

    public PhoneNumber() {
        phones=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
