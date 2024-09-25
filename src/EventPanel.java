import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    Event event;

    public EventPanel(Event event) {
        setPreferredSize(new Dimension(670, 50));
        this.event = event;
        setBackground(new Color(150,150,50));

        JLabel nameLabel = new JLabel("Event: " + event.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(nameLabel);
    }
    




}
