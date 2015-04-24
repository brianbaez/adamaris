package edu.itesa.adamaris.android.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.common.SignInButton;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import edu.itesa.adamaris.android.GooglePlusSignIn.GooglePlusAuthentication;
import android.view.View.OnClickListener;

import edu.itesa.adamaris.android.MainActivity;
import edu.itesa.adamaris.android.R;
import edu.itesa.adamaris.android.prueba;


public class SignInFragment extends Fragment implements ConnectionCallbacks,
        OnConnectionFailedListener, OnClickListener {

    GooglePlusAuthentication googlePlusAuthentication;

    public SignInFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        SignInButton button = (SignInButton) rootView.findViewById(R.id.sign_in_button);
        button.setSize(SignInButton.SIZE_WIDE);

        button.setOnClickListener(this);

        googlePlusAuthentication = new GooglePlusAuthentication(this.getActivity(),this,this);

        return rootView;
    }

    @Override
    public void onConnected(Bundle bundle) {
        googlePlusAuthentication.onConnected(bundle);
        Intent intent = new Intent(this.getActivity(), prueba.class);
        startActivity(intent);
    }

    @Override
    public void onConnectionSuspended(int i) {
        googlePlusAuthentication.connect();
        Intent intent = new Intent(this.getActivity(), prueba.class);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        googlePlusAuthentication.onConnectionFailed(connectionResult, this.getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                // Signin button clicked
                googlePlusAuthentication.logIn(this.getActivity());
                break;
        }
    }

    public void onStart() {
        super.onStart();
        googlePlusAuthentication.connect();
    }

    public void onStop() {
        super.onStop();
        googlePlusAuthentication.disconnect();
    }




}