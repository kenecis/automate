package io.developerinator.app.domain;


public enum EventSource {

    GOOGLE_CALENDAR("Google Calendar"),
    MEETUP("Meetup");


    private String label;

    EventSource(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
