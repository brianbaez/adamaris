package edu.itesa.adamaris.android.DB;

import java.util.Date;

/**
 * Created by 4to on 4/21/2015.
 */
public class Data {
    public  final String table_name = "eventos";
    public  int id;
    public  final String event_name = "_event_name";
    public  final String event_description = "event_description";
    public Date starting_date, ending_date;

    public  final String location = "location";
    public  boolean event_status;
    public  String event_title = "event_title";

    public  String create_table = "create table " + table_name + " (" +
            id + " integer primary key autoincrement," + event_name + " text not null,"
            + event_description + " text not null," + starting_date + " text not null," + location + " text,"
            + event_status + " text," + event_title + " text not null;";

    public  int getId() {

        return id;
    }

    public  String getEvent_name() {
        return event_name;
    }

    public  String getEvent_description() {
        return event_description;
    }


    public  Date getStarting_date() {
        return starting_date;
    }

    public  void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public  Date getEnding_date() {
        return ending_date;
    }

    public  void setEnding_date(Date ending_date) {
        this.ending_date = ending_date;
    }

    public  String getLocation() {
        return location;
    }

    public  boolean isEvent_status() {
        return event_status;
    }

    public  void setEvent_status(boolean event_status) {
        this.event_status = event_status;
    }

    public  String getEvent_title() {
        return event_title;
    }

    public  void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

}
