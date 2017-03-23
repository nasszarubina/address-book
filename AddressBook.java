package Addressbook;

import java.util.*;
public class AddressBook {
    private final HashMap<String, Address> addressMap = new HashMap<String, Address>();

    public void add(String person, Address address) {
        if (person == null || address == null) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        if (!addressMap.containsKey(person)) {
            addressMap.put(person, address);
        } else {
            System.err.println("Человек с такой фамилией уже присутствует (" + person + ")");
        }
    }
    public void remove(String person) {
        if (!addressMap.containsKey(person)) {
            System.err.println("Человек с такой фамилией отсутствует (" + person + ")");
        } else {
            addressMap.remove(person);
        }
    }
    public Address getAddress(String person) {
        if (!addressMap.containsKey(person)) {
            throw new IllegalArgumentException("Человек с такой фамилией отсутствует (" + person + ")");
        }

        return addressMap.get(person);
    }
    public void change(String person, Address address) {
        if (person == null || address == null) {
            throw new IllegalArgumentException("Некорректные данные");
        }

        if (!addressMap.containsKey(person)) {
            System.err.println("Человек с такой фамилией отсутствует в адресной книге (" + person + ")");
        } else {
            addressMap.put(person, address);
        }
    }

    public ArrayList<String> getList(String street) {
        final ArrayList<String> list = new ArrayList<String>();
        for (String person: addressMap.keySet()) {
            if (addressMap.get(person).getStreet().equals(street)) {
                list.add(person);
            }
        }
        return list;
    }
    public ArrayList<String> getList(String street, int house) {
        final ArrayList<String> list = new ArrayList<String>();
        for (String person: addressMap.keySet()) {
            Address localAddress = addressMap.get(person);
            if (localAddress.getStreet().equals(street) && localAddress.getHouse() == house) {
                list.add(person);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String person: addressMap.keySet()) {
            result.append(person);
            result.append(" - ");
            result.append(addressMap.get(person).toString());
            result.append('\n');
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        return addressMap.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof AddressBook)) return false;
        AddressBook other = (AddressBook) obj;
        return addressMap.equals(other.addressMap);
    }
}
