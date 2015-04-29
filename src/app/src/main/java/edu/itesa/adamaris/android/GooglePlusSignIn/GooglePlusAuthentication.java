package edu.itesa.adamaris.android.GooglePlusSignIn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;

/**
 * Created by Kelfi on 4/9/2015.
 */
public class GooglePlusAuthentication {

    private static final int RC_SIGN_IN = 0;
    // Logcat tag
    //private static final String TAG = "MainActivity";
    private GoogleApiClient mGoogleApiClient;
    private boolean signedInUser;
    private boolean mIntentInProgress;
    private ConnectionResult mConnectionResult;

    public GooglePlusAuthentication(Context context, ConnectionCallbacks connectionCallbacks,
                                    OnConnectionFailedListener onConnectionFailedListener) {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addApi(Plus.API, Plus.PlusOptions.builder().build())
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .addConnectionCallbacks(connectionCallbacks)
                .addOnConnectionFailedListener(onConnectionFailedListener)
                .build();
    }

    public void logIn(Activity activity) {
        if(!mGoogleApiClient.isConnecting())
        {
            signedInUser = true;
            resolveSignInError(activity);
        }

    }

    public void logOff() {
        if (mGoogleApiClient.isConnected()) {
            Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
            mGoogleApiClient.disconnect();
            mGoogleApiClient.connect();
        }
    }

    public boolean isConnected() {
        return mGoogleApiClient.isConnected();
    }

    public void connect() {

        mGoogleApiClient.connect();
    }

    public void disconnect() {

        mGoogleApiClient.disconnect();
    }

    private void resolveSignInError(Activity activity) {
        if (mConnectionResult.hasResolution()) {
            try {
                mIntentInProgress = true;
                mConnectionResult.startResolutionForResult(activity, RC_SIGN_IN);
            } catch (SendIntentException e) {
                mIntentInProgress = false;
                mGoogleApiClient.connect();
            }
        }
    }

    public void onConnected(Bundle bundle) {
        signedInUser = false;
    }

    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }


    public void onConnectionFailed(ConnectionResult connectionResult, Activity activity) {
        if (!connectionResult.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(connectionResult.getErrorCode(),
                    activity,
                    0)
                    .show();
            return;
        }
        if (!mIntentInProgress) {
            // store mConnectionResult
            mConnectionResult = connectionResult;
            if (signedInUser) {
                resolveSignInError(activity);
            }

        }
    }
    public void onActivityResult(int requestCode, int responseCode, Intent intent, int RESULT_OK) {

        switch (requestCode) {

            case RC_SIGN_IN:

                if (responseCode == RESULT_OK) {

                    signedInUser = false;
                }

                mIntentInProgress = false;

                if (!mGoogleApiClient.isConnecting()) {

                    mGoogleApiClient.connect();

                }

                break;

        }

    }
}
