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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import no.dnb.toolbartest.R;
import no.dnb.toolbartest.model.hourlyweather.HourlyWeatherResponse;
import no.dnb.toolbartest.model.hourlyweather.List;
import no.dnb.toolbartest.utilities.Utils;

/**
 * Created by 778363aypp on 9/4/2016.
 */
public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.ViewHolder>{
    private Context mContext;
    private HourlyWeatherResponse mHourlyWeatherResponse;
    private ArrayList<HashMap> hourlyWeatherList;
    private ArrayList<Long> timestampList = new ArrayList<>();
    private int lastPosition = -1;

    public HourlyWeatherAdapter(Context context, HourlyWeatherResponse hourlyWeatherResponse) {
        mContext = context;
        mHourlyWeatherResponse = hourlyWeatherResponse;
        hourlyWeatherList = generateHourlyWeatherList(mHourlyWeatherResponse);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_graph_card, parent, false);

        return new HourlyWeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if(hourlyWeatherList != null){
            HourlyWeatherViewHolder holder = (HourlyWeatherViewHolder) viewHolder;
            LineDataSet dataset = new LineDataSet(getEntryFromSet(hourlyWeatherList.get(position).values()), "Hourly Temperature");
            LineData data = new LineData(new ArrayList<>(hourlyWeatherList.get(position).keySet()), dataset);
            dataset.setDrawFilled(true);
            holder.lineChart.setData(data);
            holder.dayOfWeek.setText(Utils.getDayOfWeekFromTimeStamp(timestampList.get(position) * 1000));
            holder.lineChart.animateY(500);
            setAnimation(holder.container, position);
        }

    }

    private ArrayList<Entry> getEntryFromSet(Collection valuesList) {
        ArrayList<String> collectionSet = new ArrayList<>(valuesList);
        ArrayList<Entry> entryList = new ArrayList<>();

        for (int i=0; i<collectionSet.size();i++) {
            entryList.add(new Entry(Float.parseFloat(String.valueOf(collectionSet.get(i))),i));
        }
        return entryList;
    }

    private ArrayList<HashMap> generateHourlyWeatherList(HourlyWeatherResponse mHourlyWeatherResponse) {
        ArrayList<HashMap> listOfHourlyData = new ArrayList<>();
        java.util.List<List> list = mHourlyWeatherResponse.getList();
        long previousTimestamp = list.get(0).getDt();
        HashMap perDayMap = new HashMap();

        for(List item : list){
            if(Utils.isTimestapWithinSameDay(item.getDt(), previousTimestamp)){
                previousTimestamp = item.getDt();
                perDayMap.put(Utils.getTimeFromMilliseconds(item.getDt()*1000),Utils.convertKelvinToCelcius(item.getMain().getTemp()));
            }
            else{
                timestampList.add(previousTimestamp);
                previousTimestamp = item.getDt();
                listOfHourlyData.add(new HashMap(perDayMap));
                perDayMap.clear();
                perDayMap.put(Utils.getTimeFromMilliseconds(item.getDt()*1000), Utils.convertKelvinToCelcius(item.getMain().getTemp()));
            }
        }
        return listOfHourlyData;
    }

    @Override
    public int getItemCount() {
        return hourlyWeatherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public class HourlyWeatherViewHolder extends ViewHolder {
        @BindView(R.id.day_of_week)TextView dayOfWeek;
        @BindView(R.id.chart)LineChart lineChart;
        @BindView(R.id.item_layout_container)CardView container;

        public HourlyWeatherViewHolder(View v) {
            super(v);
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
}
