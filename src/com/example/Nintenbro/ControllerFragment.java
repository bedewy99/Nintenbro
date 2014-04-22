package com.example.Nintenbro;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;




/**
 * Created by student on 4/1/14.
 */
public class ControllerFragment extends Fragment {
    public static final String PREF_KEY_IP_ADDRESS = "pref_key_host_ip";
    public static final String PREF_KEY_HOST_PORT = "pref_key_host_port";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //Ensure that the settings contain a port and ip address
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        String ipAddress = prefs.getString(PREF_KEY_IP_ADDRESS, "");
        String port = prefs.getString(PREF_KEY_HOST_PORT, "");
        if (ipAddress.equals("") || port.equals("")) {
            Intent intent = new Intent(activity, PreferenceActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Grab the IP and port from preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        UPDsender1.setPort(Integer.parseInt(prefs.getString(PREF_KEY_HOST_PORT, "2390")));
        UPDsender1.setIpAddress(prefs.getString(PREF_KEY_IP_ADDRESS, "127.0.0.0"));

        View viewTreeRoot = inflater.inflate(R.layout.controller_fragment, container, false);

        // Set callbacks for all buttons



        return null;
    }
}