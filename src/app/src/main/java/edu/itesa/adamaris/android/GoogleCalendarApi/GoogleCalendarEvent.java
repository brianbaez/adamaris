package edu.itesa.adamaris.android.GoogleCalendarApi;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

import java.io.IOException;

/**
 * Created by Kelfi on 4/23/2015.
 */
public class GoogleCalendarEvent {

    Calendar service;

    public GoogleCalendarEvent (GoogleCalendarCredential googleCalendarCredential,String applicationName)
    {
        Calendar service = new Calendar.Builder(
                googleCalendarCredential.getTransport(),
                googleCalendarCredential.getJsonFactory(),
                googleCalendarCredential.getCredential())
                .setApplicationName(applicationName)
                .build();
        this.setService(service);
    }

//    public Calendar getService() {
//        return service;
//    }

    private void setService(Calendar service) {
        this.service = service;
    }

    public Event getEvent(String eventId, String calendarId) {
        Event event = null;
        try {
            event = service.events().get(calendarId,eventId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return event;
    }

//    public void setEvent(Event event) {
//        this.event = event;
//    }
}
