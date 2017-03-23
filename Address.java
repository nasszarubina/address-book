package Addressbook;

/**
 * Created by user on 18.03.2017.
 */
public final class Address {
    private final String street;
    private final int house, apartment;

    public Address (String street, int house, int apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return street + ", " + house + ", " + apartment;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Address)) return false;
        Address other = (Address) obj;
        return toString().equals(other.toString());
    }
}
