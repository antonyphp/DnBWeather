package no.dnb.toolbartest.activity;

import android.content.Context;
import android.support.v4.app.Fragment;

import no.dnb.toolbartest.application.WeatherApplication;

/**
 * Created by 778363aypp on 9/4/2016.
 */
public class BaseFragment extends Fragment {

    public Context getContext(){
        return ((WeatherApplication)getActivity().getApplication()).getContext();
    }

    public String getLocation(){
        return ((WeatherApplication)getActivity().getApplication()).getLocation();
    }
}
