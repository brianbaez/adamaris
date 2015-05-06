package edu.itesa.adamaris.android;



import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;


import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import edu.itesa.adamaris.android.DB.Data;
import edu.itesa.adamaris.android.DB.DataBaseManager;
import edu.itesa.adamaris.android.DB.DbHelper;

import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.itesa.adamaris.android.GoogleCalendarApi.GoogleCalendarCredential;
import edu.itesa.adamaris.android.GoogleCalendarApi.GoogleCalendarEvent;
import edu.itesa.adamaris.android.activities.Prueba;


import edu.itesa.adamaris.android.DB.Data;
import edu.itesa.adamaris.android.DB.DataBaseManager;
import edu.itesa.adamaris.android.DB.DbHelper;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            DbHelper helper = new DbHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();


            DataBaseManager manager = new DataBaseManager(this);
            Data data = new Data();



            manager.Insert(data);


            String select = "SELECT * FROM Agenda.eventos;";
            Toast toast = Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_LONG);
             TextView text = (TextView) findViewById(R.id.textView);

            db.execSQL(select);
            String datos = select;
            text.setText(datos);


        }
        catch(Exception e)
        {
            TextView text = (TextView) findViewById(R.id.textView);
            text.setText(e.toString());
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
