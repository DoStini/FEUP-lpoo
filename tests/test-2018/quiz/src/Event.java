import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> people;

    protected int audienceCount;

    public Event(String title) {
        this(title, "", "");
    }

    public Event(String title, String date) {
        this(title, date, "");
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.people = new ArrayList<>();
    }

    public Event(Event e) {
        this(e.title, e.date, e.description);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Event.class)
            return false;
        if (obj == this)
            return true;
        Event evt = (Event) obj;
        return this.title == evt.title && this.date == evt.date && this.description == evt.description;
    }

    public void addPerson(Person p) {
        boolean found = false;
        for (Person prs : people)
            if (prs.getName().equals(p.getName())) {
                found = true;
                break;
            }
        people.add(p);
        if (!found)
            audienceCount++;
    }

    public int getAudienceCount() {
        return audienceCount;
    }
}
