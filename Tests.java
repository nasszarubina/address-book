package Addressbook;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class Tests {
    @Test
    public void checkBook() {
        Address address1 = new Address("ул. Политехническая", 19, 29),
                address2 = new Address("ул. Политехническая", 17, 34),
                address3 = new Address("пр. Науки", 2, 8),
                address4 = new Address("пр. Непокоренных", 8, 123);

        String person1 = "Волков",
                person2 = "Овсов",
                person3 = "Шурыгина",
                person4 = "Иванова",
                person5 = "Петров";

        AddressBook newBook = new AddressBook();
        newBook.add(person1, address1);
        newBook.add(person2, address2);
        newBook.add(person1, address3);
        newBook.add(person3, address3);
        newBook.add(person4, address4);
        newBook.add(person5, address2);

        ArrayList list = new ArrayList<String>();
        list.add(person1);
        list.add(person5);
        list.add(person2);

        assertEquals(list, newBook.getList(address1.getStreet()));
    }
}