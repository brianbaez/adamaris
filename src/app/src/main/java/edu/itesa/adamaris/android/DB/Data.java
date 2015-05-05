package edu.itesa.adamaris.android.DB;


/**
 * Created by 4to on 4/21/2015.
 */
public class Data {
    public String table_name = "eventos";
    public String id = "id";


    public String event_name = "event_name";
    public String event_description = "event_description";
    public String starting_date = "starting_date";
    public String ending_date = "ending_date";

    public String location = "location";
    public String event_status = "event_status";
    public String event_title = "event_title";


//    public String create_table = "CREATE TABLE Agenda.eventos (id integer primary key autoincrement, event_name text, event_description text, starting_date text, ending_date text, location text, event_status text, event_title text);";


    public String create_table = "create table " + table_name + " (" +
            id + " integer primary key autoincrement," + event_name + " text,"
            + event_description + " text," + starting_date + " text," + ending_date +
            " text," + location + " text,"
            + event_status + " text," + event_title + " text);";

    public String getId() {
        return id;
    }


    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getEnding_date() {
        return ending_date;
    }

    public void setEnding_date(String ending_date) {
        this.ending_date = ending_date;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }
}