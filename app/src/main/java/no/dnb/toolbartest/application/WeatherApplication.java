package no.dnb.toolbartest.application;

import android.app.Application;
import android.content.Context;

import no.dnb.toolbartest.di.components.DaggerNetComponent;
import no.dnb.toolbartest.di.components.DaggerWeatherApiComponent;
import no.dnb.toolbartest.di.components.NetComponent;
import no.dnb.toolbartest.di.components.WeatherApiComponent;
import no.dnb.toolbartest.di.modules.NetModule;
import no.dnb.toolbartest.di.modules.WeatherApiModule;

/**
 * Created by 778363aypp on 9/4/2016.
 */
public class WeatherApplication extends Application {
    public static Context context;
    public static String location = "Oslo,Norway";
    private NetComponent mNetComponent;
    private WeatherApiComponent mWeatherApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule("http://api.openweathermap.org/"))
                .build();

        mWeatherApiComponent = DaggerWeatherApiComponent.builder()
                .netComponent(mNetComponent)
                .weatherApiModule(new WeatherApiModule())
                .build();

    }
  public Context getContext(){
      return context;
  }

    public String getLocation(){
        return location;
    }
    public void setLocation(String loc){
        location = loc;
    }

    public WeatherApiComponent getWeatherApiComponent() {
        return mWeatherApiComponent;
    }
}
