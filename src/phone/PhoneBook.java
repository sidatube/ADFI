package phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook extends Phone {
    List<PhoneNumber> phones;

    public PhoneBook() {
        phones = new ArrayList<>();
    }

    @Override
    public void insertPhone(String name, String phone) {
        if (name.isEmpty() || phone.isEmpty()) {
            return;
        }
        PhoneNumber phoneNumber = getPhone(name);
        if (phoneNumber != null) {
            phoneNumber.getPhones().add(phone);
        } else {
            PhoneNumber newP = new PhoneNumber();
            newP.setName(name);
            newP.getPhones().add(phone);
            phones.add(newP);
        }
    }

    @Override
    public void removePhone(String name) {
        phones.removeIf(phoneNumber -> phoneNumber.getName().equals(name));
    }

    @Override
    public void updatePhone(String name, String oldPhone, String newPhone) {
        PhoneNumber phoneNumber = getPhone(name);
        if (phoneNumber == null) {
            return;
        }
        if (!phoneNumber.getPhones().contains(oldPhone)) {
            return;
        }
        for (int i = 0; i < phoneNumber.getPhones().size() ; i++) {
            if (phoneNumber.getPhones().get(i).equals(oldPhone)){
                phoneNumber.getPhones().set(i,newPhone);
            }
        }
    }

    private PhoneNumber getPhone(String name) {
        List<PhoneNumber> collect = phones.stream().filter(e ->
                e.getName().equals(name)
        ).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return null;
        }
        return collect.get(0);
    }

    @Override
    public void searchPhone(String name) {
        PhoneNumber phoneNumber = getPhone(name);
        if (phoneNumber == null) {
            System.out.println("Not Found");;
            return;
        }
        System.out.println("Phone What want to find: "+phoneNumber);
    }

    @Override
    public void sort() {
        phones.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phones=" + phones +
                '}';
    }
}
