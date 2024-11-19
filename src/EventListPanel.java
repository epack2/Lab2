import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;


//I added the observer pattern.
public class EventListPanel extends JPanel {
    //This is the instantiation of the observer pattern.
    EventCreationListener eventCreationListener = new EventCreationListener();

    private JLabel label;


    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox<String> eventComboBox;
    final String[] SORT_OPTIONS = {"Alphabetically", "Reverse Alphabetically", "Date & Time", "Reverse Date & Time"};
    final String[] FILTERS = {"Completed", "Deadline", "Meeting"};
    ArrayList<JCheckBox> filters;
    JButton addEventButton;
    String Deadline1 = "Deadline1";
    String Deadline2 = "Deadline2";
    String Deadline3 = "Deadline3";
    String Meeting1 = "Meeting1";
    String Meeting2 = "Meeting2";
    String Meeting3 = "Meeting3";


    LocalDateTime Deadlinedate1 = LocalDateTime.of(2019, 12, 3, 10, 0);
    LocalDateTime Deadlinedate2 = LocalDateTime.of(2014, 9, 10, 12, 0);
    LocalDateTime Deadlinedate3 = LocalDateTime.of(2004, 3, 22, 14, 0);

    LocalDateTime Meetingdate1Start = LocalDateTime.of(2024, 10, 1, 10, 0);
    LocalDateTime Meetingdate2Start = LocalDateTime.of(2024, 10, 5, 8, 0);
    LocalDateTime Meetingdate3Start = LocalDateTime.of(2024, 10, 6, 13, 0);

    LocalDateTime Meetingdate1End = LocalDateTime.of(2024, 10, 1, 12, 0);
    LocalDateTime Meetingdate2End = LocalDateTime.of(2024, 10, 5, 10, 0);
    LocalDateTime Meetingdate3End = LocalDateTime.of(2024, 10, 6, 14, 0);

    String location1 = "Location1";
    String location2 = "Location2";
    String location3 = "Location3";


    public EventListPanel() {
        setPreferredSize(new Dimension(750, 750));
        setBackground(Color.black);
        events = new ArrayList<>();

        //Control Panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700, 300));

        // Add Event Button. I have the eventCreationListener taking the name of the events and adding it to the list of
        // recently created names.
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Arial", Font.BOLD, 20));
        addEventButton.addActionListener(e -> {
            addEvent(new Deadline(Deadline1, Deadlinedate1));
            this.eventCreationListener.eventOccurred(Deadline1);
            addEvent(new Deadline(Deadline2, Deadlinedate2));
            this.eventCreationListener.eventOccurred(Deadline2);
            addEvent(new Deadline(Deadline3, Deadlinedate3));
            this.eventCreationListener.eventOccurred(Deadline3);
            addEvent(new Meeting(Meeting1, Meetingdate1Start, Meetingdate1End, location1));
            this.eventCreationListener.eventOccurred(Meeting1);
            addEvent(new Meeting(Meeting2, Meetingdate2Start, Meetingdate2End, location2));
            this.eventCreationListener.eventOccurred(Meeting2);
            addEvent(new Meeting(Meeting3, Meetingdate3Start, Meetingdate3End, location3));
            this.eventCreationListener.eventOccurred(Meeting3);
            label = new JLabel(eventCreationListener.listOfEvents());
            label.setFont(new Font("Arial", Font.BOLD, 30));
            controlPanel.add(label);


        });
        controlPanel.add(addEventButton);


        eventComboBox = new JComboBox(SORT_OPTIONS);
        eventComboBox.setFont(new Font("Arial", Font.BOLD, 30));
        eventComboBox.addActionListener(e -> {
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[0]))
                Collections.sort(events);
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[1]))
                Collections.sort(events, Collections.reverseOrder());
            // events.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()) * -1);
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[2]))
                events.sort(Event::compareTo);
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[3]))
                events.sort((a1, a2) -> a1.compareTo(a2) * -1);

            updateDisplay();
        });
        //System.out.println(eventCreationListener.listOfEvents());
        controlPanel.add(eventComboBox);

        filters = new ArrayList<>();

        for (String filter : FILTERS) {
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            filters.add(box);
        }

        for (JCheckBox filter : filters)
            controlPanel.add(filter);
        add(controlPanel);




        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(700, 650));

        add(displayPanel);


    }


    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

    public void updateDisplay() {
        displayPanel.removeAll();

        for (Event event : events) {
            if (!isFiltered(event))
                displayPanel.add(new EventPanel(event));
        }

        revalidate();
        repaint();
    }

    private boolean isFiltered(Event event) {
        for (JCheckBox filter : filters) {
            if (filter.isSelected())
                switch (filter.getText()) {
                    case "Completed":
                        if (event instanceof Completable)
                            return ((Completable) event).isComplete();
                        break;

                    case "Deadline":
                        if (event instanceof Deadline)
                            return true;
                        break;

                    case "Meeting":
                        if (event instanceof Meeting)
                            return true;


                }
        }
        return false;
    }
}


