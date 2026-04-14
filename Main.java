import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while(true){
            System.out.println("\n1. ADD PERSONAL CONTACT");
            System.out.println("2. ADD BUSINESS CONTACT");
            System.out.println("3. DISPLAY ALL CONTACT");
            System.out.println("4. Exit");

            int choice = s.nextInt();
            s.nextLine(); // clear buffer

            switch(choice){

                case 1 -> {
                    System.out.println("Enter name");
                    String name = s.nextLine();

                    System.out.println("Enter phone number");
                    String phone = s.nextLine();

                    System.out.println("Enter relation");
                    String relation = s.nextLine();

                    manager.addContact(new PersonalContact(name, phone, relation));
                }

                case 2 -> {
                    System.out.println("Enter name");
                    String name = s.nextLine();

                    System.out.println("Enter phone");
                    String phone = s.nextLine();

                    System.out.println("Enter company name");
                    String company = s.nextLine();

                    manager.addContact(new BusinessContact(name, phone, company));
                }

                case 3 -> {
                    manager.displayAll();
                }

                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }
    }
}