import java.util.ArrayList;
import java.util.List;

public class Party extends Event {

    private List<Event> events;

    public Party(String title, String date, String description) {
        super(title, date, description);
        events = new ArrayList<>();
    }

    @Override
    public int getAudienceCount() {
        int count = audienceCount;
        for (Event e : events)
            count += e.audienceCount;
        return count;
    }

    public void addEvent(Event e) {
        events.add(e);
    }
}
