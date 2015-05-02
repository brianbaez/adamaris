package edu.itesa.adamaris.android.DB;

import java.util.Date;

/**
 * Created by 4to on 4/21/2015.
 */
public class Data {
    public static  String table_name = "eventos";
    public static  String id = "id";



    public static  String event_name = "event_name";
    public static  String event_description = "event_description";
    public static  String starting_date = "starting_date";
    public static  String ending_date = "ending_date";

    public static  String location = "location";
    public static  String event_status = "event_status";
    public static  String event_title = "event_title";


    public static String create_table = "create table " + table_name + " (" +
            id + " integer primary key autoincrement," + event_name + " text,"
            + event_description + " text," + starting_date + " text," + ending_date +
            " text," + location + " text,"
            + event_status + " text," + event_title + " text);";

    public static String getId() {
        return id;
    }



    public static String getEvent_name() {
        return event_name;
    }

    public static void setEvent_name(String event_name) {
        Data.event_name = event_name;
    }

    public static String getEvent_description() {
        return event_description;
    }

    public static void setEvent_description(String event_description) {
        Data.event_description = event_description;
    }

    public static String getStarting_date() {
        return starting_date;
    }

    public static void setStarting_date(String starting_date) {
        Data.starting_date = starting_date;
    }

    public static String getEnding_date() {
        return ending_date;
    }

    public static void setEnding_date(String ending_date) {
        Data.ending_date = ending_date;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        Data.location = location;
    }

    public static String getEvent_status() {
        return event_status;
    }

    public static void setEvent_status(String event_status) {
        Data.event_status = event_status;
    }

    public static String getEvent_title() {
        return event_title;
    }

    public static void setEvent_title(String event_title) {
        Data.event_title = event_title;
    }

}



