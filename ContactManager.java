import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


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

    public void saveToFile(){
        try{
            FileWriter fw = new FileWriter("contacts.txt");

            for ( Contact c : contacts){
                if(c instanceof PersonalContact){
                    PersonalContact p = (PersonalContact) c;
                    p.getRelation();

                    fw.write("PERSONAL," + p.getName() + "," + p.getPhone() + "," + p.getRelation() + "\n");

                }
                else if(c instanceof BusinessContact){
                    BusinessContact b = (BusinessContact) c;
                    fw.write("BUSINESS," + b.getName() + "," + b.getPhone() + "," + b.getCompany() + "\n");

                }

                
            }


            fw.close();
        }catch(Exception e){
                System.out.println("ERROR Saving File");
            }
    }


        public void loadFromFile(){
            try{
                File file = new File("contacts.txt");

                if(!file.exists()) return;

                Scanner sc = new Scanner(file);

                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    String[] data = line.split(",");

                    if (data[0].equals("PERSONAL")){
                        contacts.add(new PersonalContact(data[1], data[2], data[3]));

                    }else if(data[0].equals("BUSINESS")){
                        contacts.add(new BusinessContact(data[1], data[2], data[3]));

                    }
                }
                sc.close();
            }catch(Exception e){
                System.out.println("ERROR Loading File");
            }
        }

        public String getAllContacts(){
            String result = "";
            for (Contact c : contacts){
                if (c instanceof PersonalContact){
                    PersonalContact p = (PersonalContact) c;
                    
                    result += "Personal : "+ p.getName() + "," + p.getPhone() +"," + p.getRelation() + "\n";
                }
                else if ( c instanceof BusinessContact){
                    BusinessContact b = (BusinessContact) c;
                    result += "Bisiness : " + b.getName() + "," + b.getPhone()+","+ b.getCompany();
                }

                
            }
            return result;
        }

        public void deleteContact(String name){

            contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
            saveToFile();
        }

 public boolean updateContact(String phone, String newName, String newExtra) {

    for (Contact c : contacts) {

        if (c.getPhone().equals(phone)) {

            if (c instanceof PersonalContact) {
                PersonalContact p = (PersonalContact) c;
                p.setName(newName);
                p.setRelation(newExtra);
            }

            else if (c instanceof BusinessContact) {
                BusinessContact b = (BusinessContact) c;
                b.setName(newName);
                b.setCompany(newExtra);
            }

            return true;
        }
    }

    return false;
}
}