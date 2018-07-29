package no.dnb.toolbartest.activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import no.dnb.toolbartest.R;
import no.dnb.toolbartest.adapter.WeatherOverviewAdapter;
import no.dnb.toolbartest.application.WeatherApplication;
import no.dnb.toolbartest.adapter.HourlyWeatherAdapter;
import no.dnb.toolbartest.model.hourlyweather.HourlyWeatherResponse;
import no.dnb.toolbartest.utilities.Constants;
import no.dnb.toolbartest.webservice.WeatherApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HourlyForecastFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private HourlyWeatherAdapter mAdapter;
    @Inject
    WeatherApiInterface weatherApiInterface;


    public HourlyForecastFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((WeatherApplication) getActivity().getApplication()).getWeatherApiComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        fetchDailyWeatherInfo();
    }

    private void fetchDailyWeatherInfo() {

        Call<HourlyWeatherResponse> call = weatherApiInterface.getHourlyWeatherDetails(getLocation(), Constants.API_KEY);
        call.enqueue(new Callback<HourlyWeatherResponse>() {
            @Override
            public void onResponse(Call<HourlyWeatherResponse> call, Response<HourlyWeatherResponse> response) {
                HourlyWeatherResponse hourlyWeatherResponse = response.body();
                if (hourlyWeatherResponse == null) {
                    Toast.makeText(getActivity(), "Oops.. searched city weather is unavailable. Sorry :(", Toast.LENGTH_LONG).show();
                } else {
                    mAdapter = new HourlyWeatherAdapter(getContext(),hourlyWeatherResponse);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<HourlyWeatherResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("Weather Response", t.toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hourly_forecast, container, false);
    }

}
