package edu.itesa.adamaris.android.DB;

import java.util.Date;

/**
 * Created by 4to on 4/21/2015.
 */
public class Data {
    public static  String table_name = "eventos";
    public static  String  id = "id";
    public static String event_name = "event_name";
    public static String event_description = "event_description";
    public static Date starting_date, ending_date;

    public static String location = "location";
    public static String event_status = "event_status";
    public static String event_title = "event_title";

    public static final String create_table = " create table " + table_name + " (" +
                id + " integer primary key autoincrement," + event_name + " text,"
                + event_description + " text," + starting_date + " text," + ending_date +
                " text," + location + " text,"
                + event_status + " text," + event_title + " text;";



    public  String getId() {

        return id;
    }

    public  String getEvent_name() {
        return event_name;
    }

    public  String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
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

    public static String getEvent_status() {
        return event_status;
    }

    public static void setEvent_status(String event_status) {
        Data.event_status = event_status;
    }

    public  String getEvent_title() {
        return event_title;
    }

    public  void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

}
