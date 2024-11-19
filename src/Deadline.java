import java.time.LocalDateTime;

public class Deadline extends Event implements Completable{

    public boolean complete = false;

    Deadline(String name, LocalDateTime dateTime) {
        this.name = name;
        this.date = dateTime;
    }

    public String getName()
    {
        return name;
    }


    public void complete()
    {
        complete = true;
    }

    public boolean isComplete()
    {
        return complete;
    }
}
