package edu.itesa.adamaris.android.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    private ContentValues generateContentValues(Data data ){
        ContentValues values = new ContentValues();

        return values;

    }

    public void Insert(Data data){
        ContentValues values = new ContentValues();


        values.put("event_name", data.getEvent_description());
        values.put("event_description", data.getEvent_description());
        values.put("starting_date", data.getStarting_date().toString());
        values.put("ending_date", data.getEnding_date().toString());
        values.put("location", data.getLocation());
        values.put("event_status", data.getEvent_status());
        values.put("event_title", data.getEvent_title());





    }

}


