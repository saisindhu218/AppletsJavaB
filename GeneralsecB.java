import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;

public class GeneralsecB {

    public static void main(String[] args) {
        // create the frame
        Frame frame = new Frame("AWT Example for Layouts");
        frame.setSize(400, 300);
        //frame.setLayout(new FlowLayout());
        frame.setLayout(new BorderLayout()); //demo1
        frame.setLocationRelativeTo(null); // Center the window on screen
        
        // common font
        Font commonFont = new Font("Serif", Font.PLAIN, 18);

        // Top panel with BoxLayout
        Panel topPanel = new Panel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); //demo2
        // welcome heading
        Label welcomeLabel = new Label("Welcome class ");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 25));
        welcomeLabel.setForeground(Color.BLUE);
        Label introLabel = new Label("Enter your name:");
        introLabel.setFont(commonFont);
        // create and add a text field
        TextField nameField = new TextField(10);

        topPanel.add(welcomeLabel);
        topPanel.add(introLabel);
        topPanel.add(nameField);
        
        
        // Center panel with CardLayout
        Panel centerPanel = new Panel();
        CardLayout cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);

        // Card 1: Info Card
        Panel card1 = new Panel();
        //card1.setLayout(new BoxLayout(card1, BoxLayout.Y_AXIS));
        
        Label card1Label = new Label("This is Card 1");
        card1Label.setFont(new Font("Serif", Font.BOLD, 23));

        Label emailLabel = new Label("Email: ");
        emailLabel.setFont(commonFont);
        TextField textField1 = new TextField(20);
        Label passwordLabel = new Label("Password: ");
        passwordLabel.setFont(commonFont);
        TextField textField2 = new TextField(20);

        card1.add(card1Label);
        card1.add(emailLabel);
        card1.add(textField1);
        card1.add(passwordLabel);
        card1.add(textField2);

        // Card 2: Agreement Card
        Panel card2 = new Panel();
        //card2.setLayout(new BoxLayout(card2, BoxLayout.Y_AXIS));

        Label card2Label = new Label("This is Card 2");
        card2Label.setFont(new Font("Serif", Font.BOLD, 25));

        Label termsLabel = new Label("Terms and Conditions ");
        termsLabel.setFont(commonFont);
        Checkbox agreementCheck = new Checkbox("I agree");
        agreementCheck.setFont(commonFont);

        card2.add(card2Label);
        card2.add(termsLabel);
        card2.add(agreementCheck);

        // Add cards to center panel
        centerPanel.add(card1, "Card1");
        centerPanel.add(card2, "Card2");
        

        // Bottom panel with GridBagLayout
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 5, 10);  // padding

        Button prevBtn = new Button("Previous");
        Button nextBtn = new Button("Next");
        Button submitBtn = new Button("Submit");

        // Place Previous button at (0, 0)
        gbc.gridx = 0;
        gbc.gridy = 0; //demo 3
        bottomPanel.add(prevBtn, gbc);

        // Place Next button at (1, 0)
        gbc.gridx = 1;
        //gbc.gridy = 1;  
        bottomPanel.add(nextBtn, gbc);

        // Place Submit button at (2, 0)
        gbc.gridx = 2;
        //gbc.gridy = 2;

        bottomPanel.add(submitBtn, gbc);

        // Add All Panels to Frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        //Button Listeners
        nextBtn.addActionListener(e -> cardLayout.next(centerPanel));
        prevBtn.addActionListener(e -> cardLayout.previous(centerPanel));
        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            System.out.println("Submitted: " + name);
        });

        // Add a window listener to close the window when the user clicks the close button
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                frame.dispose();
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}