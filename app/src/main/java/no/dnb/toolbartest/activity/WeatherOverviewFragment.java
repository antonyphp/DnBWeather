package no.dnb.toolbartest.activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import no.dnb.toolbartest.R;
import no.dnb.toolbartest.application.WeatherApplication;
import no.dnb.toolbartest.adapter.WeatherOverviewAdapter;
import no.dnb.toolbartest.model.weatheroverview.WeatherOverviewResponse;
import no.dnb.toolbartest.utilities.Constants;
import no.dnb.toolbartest.webservice.WeatherApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherOverviewFragment extends BaseFragment {
    public static final int TEMPERATURE = 0;
    public static final int WEATHER = 1;
    public static final int SURISE_SUNSET = 2;
    private RecyclerView mRecyclerView;
    private WeatherOverviewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int mDatasetTypes[] = {TEMPERATURE, WEATHER, SURISE_SUNSET}; //view types
    @Inject
    WeatherApiInterface weatherApiInterface;

    public WeatherOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((WeatherApplication) getActivity().getApplication()).getWeatherApiComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_overview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Call weather service api
        fetchWeatherInfo();
    }

    private void fetchWeatherInfo() {
//        WeatherApiInterface apiService =
//                ApiClient.getClient().create(WeatherApiInterface.class);

        Call<WeatherOverviewResponse> call = weatherApiInterface.getWeatherOverviewDetails(getLocation(), Constants.API_KEY);
        call.enqueue(new Callback<WeatherOverviewResponse>() {
            @Override
            public void onResponse(Call<WeatherOverviewResponse> call, Response<WeatherOverviewResponse> response) {
                WeatherOverviewResponse weatherOverviewResponse = response.body();
                mAdapter = new WeatherOverviewAdapter(getContext(), weatherOverviewResponse, mDatasetTypes);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<WeatherOverviewResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("Weather Response", t.toString());
            }
        });
    }
}
