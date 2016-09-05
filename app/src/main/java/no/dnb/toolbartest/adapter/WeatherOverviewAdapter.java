package no.dnb.toolbartest.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.dnb.toolbartest.R;
import no.dnb.toolbartest.model.weatheroverview.WeatherOverviewResponse;
import no.dnb.toolbartest.utilities.Utils;

/**
 * Created by 778363aypp on 9/1/2016.
 */
public class WeatherOverviewAdapter extends RecyclerView.Adapter<WeatherOverviewAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private WeatherOverviewResponse mWeatherOverviewResponse;
    private int[] mDataSetTypes;

    public static final int TEMPERATURE = 0;
    public static final int WEATHER_DETAILS = 1;
    public static final int SUNRISE_SUNSET = 2;
    private Context mContext;
    private int lastPosition = -1;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class TemperatureViewHolder extends ViewHolder {
        @BindView(R.id.temp)TextView temp;
        @BindView(R.id.temp_place)TextView place;
        @BindView(R.id.temp_description)TextView description;
        @BindView(R.id.item_layout_container)CardView container;

        public TemperatureViewHolder(View v) {
            super(v);
        }
    }

    public class WeatherDetailsViewHolder extends ViewHolder {
        @BindView(R.id.feels_like)TextView feelsLike;
        @BindView(R.id.wind)TextView wind;
        @BindView(R.id.humidity)TextView humidity;
        @BindView(R.id.pressure)TextView pressure;
        @BindView(R.id.item_layout_container)CardView container;

        public WeatherDetailsViewHolder(View v) {
            super(v);
        }
    }

    public class SunriseSunsetViewHolder extends ViewHolder {
        @BindView(R.id.sunrise_time)TextView sunriseTime;
        @BindView(R.id.sunset_time)TextView sunsetTime;
        @BindView(R.id.item_layout_container)CardView container;

        public SunriseSunsetViewHolder(View v) {
            super(v);
        }
    }


    public WeatherOverviewAdapter(Context context, WeatherOverviewResponse weatherOverviewResponse, int[] dataSetTypes) {
        mContext = context;
        mWeatherOverviewResponse = weatherOverviewResponse;
        mDataSetTypes = dataSetTypes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == TEMPERATURE) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.temperature_card, viewGroup, false);

            return new TemperatureViewHolder(v);
        } else if (viewType == SUNRISE_SUNSET) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.sunrise_sunset_card, viewGroup, false);
            return new SunriseSunsetViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.weather_details_card, viewGroup, false);
            return new WeatherDetailsViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == TEMPERATURE) {
            TemperatureViewHolder holder = (TemperatureViewHolder) viewHolder;
            holder.temp.setText((String.valueOf(Utils.convertKelvinToCelcius(mWeatherOverviewResponse.getMain().getTemp())) + (char) 0x00B0));
            holder.place.setText(mWeatherOverviewResponse.getName());
            holder.description.setText(mWeatherOverviewResponse.getWeather().get(0).getDescription());
            setAnimation(holder.container, position);
        }
        else if (viewHolder.getItemViewType() == SUNRISE_SUNSET) {
            SunriseSunsetViewHolder holder = (SunriseSunsetViewHolder) viewHolder;
            holder.sunriseTime.setText(Utils.getTimeFromMilliseconds(mWeatherOverviewResponse.getSys().getSunrise()*1000));
            holder.sunsetTime.setText(Utils.getTimeFromMilliseconds(mWeatherOverviewResponse.getSys().getSunset()*1000));
            setAnimation(holder.container,position);
        }
        else {
            WeatherDetailsViewHolder holder = (WeatherDetailsViewHolder) viewHolder;
            holder.feelsLike.setText((String.valueOf(Utils.convertKelvinToCelcius(mWeatherOverviewResponse.getMain().getTemp())) + (char) 0x00B0));
            holder.wind.setText(String.valueOf((int) (mWeatherOverviewResponse.getWind().getSpeed())) + "Km/h " +
                    String.valueOf((int) mWeatherOverviewResponse.getWind().getDeg())+(char) 0x00B0);
            holder.humidity.setText(mWeatherOverviewResponse.getMain().getHumidity() + "%");
            holder.pressure.setText(mWeatherOverviewResponse.getMain().getPressure() + " mbar");
            setAnimation(holder.container,position);
        }

    }
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.card_animator);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
    @Override
    public int getItemCount() {
        return mDataSetTypes.length;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSetTypes[position];
    }
}