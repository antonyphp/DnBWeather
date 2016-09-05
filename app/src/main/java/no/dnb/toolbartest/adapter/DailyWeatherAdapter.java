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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.dnb.toolbartest.R;
import no.dnb.toolbartest.model.dailyweather.DailyWeatherResponse;
import no.dnb.toolbartest.model.dailyweather.List;
import no.dnb.toolbartest.utilities.Utils;

/**
 * Created by 778363aypp on 9/3/2016.
 */
public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.ViewHolder> {
    private DailyWeatherResponse dailyWeatherResponse;
    private Context context;
    private int lastPosition = -1;

    public DailyWeatherAdapter( Context context, DailyWeatherResponse dailyWeatherResponse) {
        this.dailyWeatherResponse = dailyWeatherResponse;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daily_weather_card, parent, false);

        return new DailyWeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        List dailyWeatherItem = dailyWeatherResponse.getList().get(position);
        DailyWeatherViewHolder holder = (DailyWeatherViewHolder) viewHolder;
        holder.tvDayOfWeek.setText(Utils.getDayOfWeekFromTimeStamp(dailyWeatherItem.getDt()*1000));
        holder.tvDescription.setText(dailyWeatherItem.getWeather().get(0).getDescription());
        holder.tvLowHighTemperature.setText(String.valueOf(Utils.convertKelvinToCelcius(dailyWeatherItem.getTemp().getMax().floatValue())) + (char) 0x00B0
                +"/" + String.valueOf(Utils.convertKelvinToCelcius(dailyWeatherItem.getTemp().getMin().floatValue())) + (char) 0x00B0);
        holder.tvWindSpeed.setText("Wind Speed : " + dailyWeatherItem.getSpeed().intValue()+"Km/h");
        setAnimation(holder.container, position);

    }

    @Override
    public int getItemCount() {
        return dailyWeatherResponse.getList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
        }
    }

    public class DailyWeatherViewHolder extends ViewHolder{
        @BindView(R.id.day_of_week)TextView tvDayOfWeek;
        @BindView(R.id.temp_description)TextView tvDescription;
        @BindView(R.id.low_high_temp)TextView tvLowHighTemperature;
        @BindView(R.id.wind)TextView tvWindSpeed;
        @BindView(R.id.item_layout_container)CardView container;

        public DailyWeatherViewHolder(View v) {
            super(v);
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.card_animator);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
