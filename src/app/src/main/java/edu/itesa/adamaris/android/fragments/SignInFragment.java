package edu.itesa.adamaris.android.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import edu.itesa.adamaris.android.GooglePlusSignIn.GooglePlusAuthentication;
import edu.itesa.adamaris.android.R;


public class SignInFragment extends Fragment implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    public static GooglePlusAuthentication googlePlusAuthentication;


    public SignInFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        SignInButton button = (SignInButton) rootView.findViewById(R.id.sign_in_button);
        button.setSize(SignInButton.SIZE_WIDE);

        button.setOnClickListener(this);

        googlePlusAuthentication =
                new GooglePlusAuthentication(getActivity(),
                        this,
                        this);




        return rootView;
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
        getActivity().setContentView(R.layout.activity_main);
    }

    @Override
    public void onConnectionSuspended(int i) {
        googlePlusAuthentication.connect();
        getActivity().setContentView(R.layout.activity_main);

    }
    @Override
    public void onResume() {
        super.onResume();

        ActionBar actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        actionBar.hide();


    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        googlePlusAuthentication.onConnectionFailed(connectionResult, getActivity());
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        googlePlusAuthentication.onActivityResult(requestCode,responseCode,intent,getActivity().RESULT_OK);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                // Signin button clicked
                googlePlusAuthentication.logIn(getActivity());
                break;
        }
    }




}