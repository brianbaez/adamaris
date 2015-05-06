package edu.itesa.adamaris.android.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_Name = "Agenda";
    private static final int DB_SCHEMA_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_Name, null, DB_SCHEMA_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db)
    {


            Data data = new Data();
            db.execSQL(data.create_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
