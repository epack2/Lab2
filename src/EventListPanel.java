import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventListPanel extends JPanel{
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropDown;
    JCheckBox filterDisplay;
    JButton addEventButton;
    LocalDateTime date = LocalDateTime.of(2024, 10, 7, 16, 0);


    public EventListPanel()
    {
        setPreferredSize(new Dimension(750,750));
        setBackground(Color.black);
        events = new ArrayList<>();

        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700,300));

        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Arial",Font.BOLD,20));
        addEventButton.addActionListener(e -> {
        //addEvent(Event.setDateTime(date));

        });
        controlPanel.add(addEventButton);


    }

    public void addEvent(Event event)
    {
        events.add(event);
        repaint();
    }



}


