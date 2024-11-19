import java.util.ArrayList;

//This is the concrete observer class. It watches and records the names of the objects that are created.
public class EventCreationListener implements EventListener{


    String newevent = "";



    //This method takes the name of a newly created event and adds it to the names
    //of other recently created events.
    @Override
    public void eventOccurred(String name)
    {
        newevent += name + ", ";
    }

    //This method returns the names of the recently created events.
    public String listOfEvents(){
        return "The following events have been created: " + newevent;
    }

    //This method didn't get used. I planned to implement it with the abstract factory pattern.

    public String eventOccurred2(Event event) {
        return "The event " + event.getName() + " has been created";
    }
}
