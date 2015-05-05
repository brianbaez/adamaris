package edu.itesa.adamaris.android.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 4to on 4/21/2015.
 */
public class DataBaseManager {

    private DbHelper helper;
    private SQLiteDatabase db;


    public DataBaseManager(Context context ) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues generateContentValues(String event_name, String event_description, String starting_date, String ending_date, String location, String event_status, String event_title){
        Data data = new Data();
        ContentValues values = new ContentValues();
        values.put("event_name", data.getEvent_name());
        values.put("event_description", data.getEvent_description());
        values.put("starting_date", data.getStarting_date().toString());
        values.put("ending_date", data.getEnding_date().toString());
        values.put("location", data.getLocation());
        values.put("event_status", data.getEvent_status());
        values.put("event_title", data.getEvent_title());

        return values;

    }

    public void Insert(String event_name, String event_description, String starting_date, String ending_date, String location, String event_status, String event_title)
    {
        Data data = new Data();
        db.insert(data.table_name, null, generateContentValues(event_name, event_description, starting_date, ending_date, location, event_status, event_title));

    }

//    public void Remove(Data data)
//      {
////        Delete * FROM eventos where nombre = Data.GetNombre
//             String DeleteQuery = "DELETE * FROM " + data.table_name + " WHERE " + data.event_name + " = " + data.getEvent_name();

//          db.execSQL(DeleteQuery);
//    }



}


