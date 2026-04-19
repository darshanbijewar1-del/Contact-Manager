import javax.swing.*;

public class ContactGUI {

    ContactManager manager = new ContactManager();

    public ContactGUI() {

        JFrame frame = new JFrame();
        frame.setTitle("My Contact System");
        frame.setSize(400, 500);  // FIXED SIZE
        frame.setLayout(null);

        // Fields
        JTextField nameField = new JTextField();
        nameField.setBounds(50, 50, 200, 30);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(50, 100, 200, 30);

        JTextField extraField = new JTextField();
        extraField.setBounds(50, 150, 200, 30);

        // Buttons
        JButton pbtn = new JButton("Add Personal");
        pbtn.setBounds(50, 200, 150, 30);

        JButton bbtn = new JButton("Add Business");
        bbtn.setBounds(50, 240, 150, 30);

        JButton displayBtn = new JButton("Display");
        displayBtn.setBounds(220, 200, 120, 30);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(220, 240, 120, 30);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 280, 120, 30);

        // Text Area
        JTextArea area = new JTextArea();
        area.setBounds(50, 330, 1200, 360);

        // Add components
        frame.add(nameField);
        frame.add(phoneField);
        frame.add(extraField);

        frame.add(pbtn);
        frame.add(bbtn);
        frame.add(displayBtn);
        frame.add(deleteBtn);
        frame.add(updateBtn);
        frame.add(area);

        // Load data on start
        manager.loadFromFile();
        area.setText(manager.getAllContacts());

        // Add Personal
        pbtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String relation = extraField.getText();

            manager.addContact(new PersonalContact(name, phone, relation));
            manager.saveToFile();

            area.setText(manager.getAllContacts());

            nameField.setText("");
            phoneField.setText("");
            extraField.setText("");
        });

        // Add Business
        bbtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String company = extraField.getText();

            manager.addContact(new BusinessContact(name, phone, company));
            manager.saveToFile();

            area.setText(manager.getAllContacts());

            nameField.setText("");
            phoneField.setText("");
            extraField.setText("");
        });

        // Display
        displayBtn.addActionListener(e -> {
            area.setText(manager.getAllContacts());
        });

        // Delete (by phone recommended)
        deleteBtn.addActionListener(e -> {
            String name = nameField.getText();

            manager.deleteContact(name);
            manager.saveToFile();

            area.setText(manager.getAllContacts());
        });

        // Update (by phone)
        updateBtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String extra = extraField.getText();

            boolean result = manager.updateContact(phone, name, extra);

            if (result) {
                JOptionPane.showMessageDialog(null, "Contact Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Contact Not Found");
            }

            manager.saveToFile();
            area.setText(manager.getAllContacts());
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ContactGUI();
    }
}