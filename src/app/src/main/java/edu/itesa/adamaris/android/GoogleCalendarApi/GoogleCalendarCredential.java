package edu.itesa.adamaris.android.GoogleCalendarApi;

import android.content.Context;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.calendar.CalendarScopes;

import java.util.Arrays;

/**
 * Created by Kelfi on 4/24/2015.
 */
public class GoogleCalendarCredential {

    private GoogleAccountCredential credential;
    private HttpTransport transport;
    private JsonFactory jsonFactory;
    private String[] Scopes;

    public GoogleCalendarCredential(Context context, String accountName)
    {
        GoogleAccountCredential googleAccountCredential;

        this.setJsonFactory(GsonFactory.getDefaultInstance());
        this.setTransport(AndroidHttp.newCompatibleTransport());
        this.setScopes(new String[]{CalendarScopes.CALENDAR_READONLY});

        googleAccountCredential = GoogleAccountCredential.usingOAuth2(
                context,
                Arrays.asList(Scopes))
                .setBackOff(new ExponentialBackOff())
                .setSelectedAccountName(accountName);

        this.setCredential(googleAccountCredential);

    }

    public String[] getScopes() {
        return Scopes;
    }

    private void setScopes(String[] scopes) {
        Scopes = scopes;
    }

    public JsonFactory getJsonFactory() {
        return jsonFactory;
    }

    private void setJsonFactory(JsonFactory jsonFactory) {
        this.jsonFactory = jsonFactory;
    }

    public HttpTransport getTransport() {
        return transport;
    }

    private void setTransport(HttpTransport transport) {
        this.transport = transport;
    }

    public GoogleAccountCredential getCredential() {
        return credential;
    }

    private void setCredential(GoogleAccountCredential credential) {
        this.credential = credential;
    }

}
