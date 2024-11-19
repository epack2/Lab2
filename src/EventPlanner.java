import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner {

    EventListPanel eventListPanel = new EventListPanel();


    public static  void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.getContentPane().add(, BorderLayout.CENTER);
        frame.setTitle("Event Planner");
        EventListPanel eventListPanel = new EventListPanel();
        frame.getContentPane().add(eventListPanel);
        
        frame.pack();
        frame.setVisible(true);

        /*static void addDefaultEvents(EventListPanel events)
        {
            frame.getContentPane().add();
        }*/
    }



}
