import java.awt.*;
import java.time.LocalDateTime;

abstract class Event implements Comparable<Event> {
    public String name;
    LocalDateTime date;



    public abstract String getName();

    public LocalDateTime getDateTime()
    {
        return date;
    }

    public void setDateTime(LocalDateTime date)
    {
        this.date = date;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int compareTo(Event e)
    {
        if (date.isAfter(e.getDateTime()))
        {
            return 1;
        }
        else if (date.isBefore(e.getDateTime()))
        {
            return -1;
        }
        else
        {
            return 0;
        }

    }

}
