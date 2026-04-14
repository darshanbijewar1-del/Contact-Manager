import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void displayAll() {
        for (Contact c : contacts) {
            c.displayInfo();
            System.out.println("-------------");
        }
    }
}