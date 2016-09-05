package no.dnb.toolbartest.webservice;

import no.dnb.toolbartest.model.dailyweather.DailyWeatherResponse;
import no.dnb.toolbartest.model.hourlyweather.HourlyWeatherResponse;
import no.dnb.toolbartest.model.weatheroverview.WeatherOverviewResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 778363aypp on 9/2/2016.
 */
public interface WeatherApiInterface {
    @GET("/data/2.5/weather")
    Call<WeatherOverviewResponse> getWeatherOverviewDetails(@Query("q") String location, @Query("apikey") String apiKey);

    @GET("/data/2.5/forecast/daily")
    Call<DailyWeatherResponse> getDailyWeatherDetails(@Query("q") String location, @Query("apikey") String apiKey);

    @GET("/data/2.5/forecast")
    Call<HourlyWeatherResponse> getHourlyWeatherDetails(@Query("q") String location, @Query("apikey") String apiKey);
}
