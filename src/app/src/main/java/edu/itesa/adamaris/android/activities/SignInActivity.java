package edu.itesa.adamaris.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

import android.view.View.OnClickListener;


import edu.itesa.adamaris.android.GooglePlusSignIn.GooglePlusAuthentication;
import edu.itesa.adamaris.android.R;

public class SignInActivity extends ActionBarActivity implements OnClickListener, ConnectionCallbacks,
        OnConnectionFailedListener{

    GooglePlusAuthentication googlePlusAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_signin);

        SignInButton button = (SignInButton) findViewById(R.id.sign_in_button);
        button.setSize(SignInButton.SIZE_WIDE);

        button.setOnClickListener(this);

        googlePlusAuthentication =
                new GooglePlusAuthentication(this,
                        this,
                        this);
    }

    public void onStart() {
        super.onStart();
        googlePlusAuthentication.connect();
    }

    public void onStop() {
        super.onStop();
        if (googlePlusAuthentication.isConnected()) {

            googlePlusAuthentication.disconnect();
        }

    }

    @Override
    public void onConnected(Bundle bundle) {
        googlePlusAuthentication.onConnected(bundle);
        this.setContentView(R.layout.activity_main);
    }

    @Override
    public void onConnectionSuspended(int i) {
        googlePlusAuthentication.connect();
        this.setContentView(R.layout.activity_main);

    }
    @Override
    public void onResume() {
        super.onResume();

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.hide();


    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        googlePlusAuthentication.onConnectionFailed(connectionResult, this);
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        googlePlusAuthentication.onActivityResult(requestCode,responseCode,intent,RESULT_OK);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                // Signin button clicked
                googlePlusAuthentication.logIn(this);
                break;
        }
    }
}
