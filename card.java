import javax.swing.*;
import java.awt.*;

public class card {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("JTable in Card Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create the CardLayout panel
        JPanel cardPanel = new JPanel(new CardLayout());

        // Card 1: A simple label
        JPanel card1 = new JPanel(new BorderLayout());
        card1.add(new JLabel("This is Card 1"), BorderLayout.CENTER);

        // Card 2: JTable
        JPanel card2 = new JPanel();
        card2.setLayout(null); // Use BorderLayout for positioning

        // Create a JTable
        String[] columnNames = {"ID", "Name", "Type"};
        Object[][] data = {
            {1, "House", "Residential"},
            {2, "Office", "Commercial"},
            {3, "Shop", "Retail"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table); // Add table to scroll pane

        // Add the scroll pane to the center of the card
        card2.add(scrollPane, BorderLayout.CENTER);

        // Optional: Add a label or buttons above/below the table
        JLabel titleLabel = new JLabel("Property List", SwingConstants.CENTER);
        card2.add(titleLabel, BorderLayout.NORTH);

        // Add cards to the card panel
        cardPanel.add(card1, "Card 1");
        cardPanel.add(card2, "Card 2");

        // Add navigation buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnCard1 = new JButton("Show Card 1");
        JButton btnCard2 = new JButton("Show Card 2");

        buttonPanel.add(btnCard1);
        buttonPanel.add(btnCard2);

        // Add ActionListeners for navigation
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        btnCard1.addActionListener(e -> cardLayout.show(cardPanel, "Card 1"));
        btnCard2.addActionListener(e -> cardLayout.show(cardPanel, "Card 2"));

        // Combine everything in the main frame
        frame.setLayout(new BorderLayout());
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
