import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Conatct c){
        contacts.add(c);
    }

    public void displayConatact(){
        for(Contact c : contacts){
            c.displayInfo();
            System.out.println("-------------");
        }
    }

}
