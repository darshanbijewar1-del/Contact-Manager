import javax.swing.*;

public class ContactGUI {

    ContactManager manager = new ContactManager();
    
    

    public ContactGUI() {

        JFrame frame = new JFrame();

        frame.setTitle("My Contact System");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JTextField nameField = new JTextField();
        nameField.setBounds(50, 50, 200, 30);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(50, 100, 200, 30);

        JTextField extraField = new JTextField();
        extraField.setBounds(50, 150, 200, 30);

        JButton pbtn = new JButton("ADD Personal");
        pbtn.setBounds(50, 200, 150, 30);

        JButton bbtn = new JButton("ADD Business");
        bbtn.setBounds(50, 240, 150, 30);

        frame.add(nameField);
        frame.add(phoneField);
        frame.add(extraField);
        frame.add(pbtn);
        frame.add(bbtn);

        // Action - Personal
        pbtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String relation = extraField.getText();

            manager.addContact(new PersonalContact(name, phone, relation));
            manager.saveToFile();
            System.out.println("Personal Contact Saved");
        });

        // Action - Business
        bbtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String company = extraField.getText();

            manager.addContact(new BusinessContact(name, phone, company));
            manager.saveToFile();
            System.out.println("Business Contact Added");
        });

        JTextArea area = new JTextArea();
        area.setBounds(50,280,300,100);

        frame.add(area);
        manager.loadFromFile();  // load data from file

        area.setText(manager.getAllContacts());  // show in GUI
        
        JButton displayBtn = new JButton("Display Contact");
        displayBtn.setBounds(220,200,150,30);
        frame.add(displayBtn);

        displayBtn.addActionListener(e ->{
            String data = manager.getAllContacts();
            area.setText(data);
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ContactGUI();
    }
}