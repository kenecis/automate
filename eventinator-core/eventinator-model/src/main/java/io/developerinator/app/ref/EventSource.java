package io.developerinator.app.ref;


public enum EventSource {

    GOOGLE_CALENDAR("Google Calendar"),
    MEETUP("Meetup"),
    EVENTINATOR("Eventinator");


    private String label;

    EventSource(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
