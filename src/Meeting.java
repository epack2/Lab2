import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable{
    //endDateTime = end of meeting
    public LocalDateTime endDateTime;
    public boolean complete = false;
    public String location = "";

    Meeting(String name, LocalDateTime start, LocalDateTime end, String location)
    {
        this.name = name;
        this.endDateTime = end;
        date = start;
        this.location = location;
    }


    public void complete() {
        complete = true;
    }


    public boolean isComplete() {
        return complete;
    }


    public String getName() {
        return name;
    }



    public LocalDateTime getEndDateTime()
    {
        return endDateTime;
    }

    public Duration getDuration()
    {
        return Duration.between(date, endDateTime);
    }

    public String getLocation()
    {
        return location;
    }

    public void setEndDateTime(LocalDateTime end)
    {
        this.endDateTime = end;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }


}