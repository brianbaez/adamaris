package edu.itesa.adamaris.android.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_Name = "Agenda.sqlite";
    private static final int DB_SCHEMA_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_Name, null, DB_SCHEMA_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db)
    {

       db.execSQL(Data.create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
