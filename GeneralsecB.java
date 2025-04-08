import java.awt.*;
import java.awt.event.*;

public class GeneralsecB {

    public static void main(String[] args) {
        // Create the frame
        Frame frame = new Frame("AWT Example with Label, TextField, Button, and Checkbox");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null); // Center the window

        // Create and add a label
        Label label = new Label("Welcome class");
        label.setFont(new Font("Serif", Font.BOLD, 16));
        label.setForeground(Color.MAGENTA);
        frame.add(label);

        // Create and add a text field
        TextField textField = new TextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(textField);

        // Create and add a button
        java.awt.Button myButton = new java.awt.Button("Submit");
        myButton.setFont(new Font("Arial", Font.BOLD, 14));
        myButton.setBackground(Color.LIGHT_GRAY);
        myButton.setForeground(Color.BLUE);
        frame.add(myButton);

        // Create and add a checkbox
        Checkbox checkBox = new Checkbox("I agree to the terms");
        checkBox.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(checkBox);

        // Add a window listener to close the frame properly
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
