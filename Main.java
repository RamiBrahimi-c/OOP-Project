import javax.swing.*; // Import Swing components
import java.awt.event.*; // Import event handling

public class Main {
    public static void main(String[] args) {
        // Create the main window (frame)
        JFrame frame = new JFrame("Real Estate Management");
        frame.setSize(600, 600); // Set size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app when the window is closed

        // Create a panel to hold components
        JPanel panel = new JPanel();
        frame.add(panel); // Add panel to the frame

        // Add components to the panel
        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null); // Disable default layout for custom positioning

        // Create a label
        JLabel userLabel = new JLabel("Welcome to Real Estate App");
        userLabel.setBounds(100, 20, 200, 25); // Set position and size
        panel.add(userLabel);

        // Create a button
        JButton loginButton = new JButton("Click Me");
        loginButton.setBounds(150, 100, 100, 40);
        panel.add(loginButton);
        JButton signButton = new JButton("don't Click Me");
        signButton.setBounds(150, 150, 100, 40);
        panel.add(signButton);

        // Add an action listener for the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog when the button is clicked
                JOptionPane.showMessageDialog(panel, "Hello! Welcome to the Real Estate App.");
            }
        });
        signButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(panel , "haha") ;
        }
        });
    }
}