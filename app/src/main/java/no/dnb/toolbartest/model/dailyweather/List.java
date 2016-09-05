
package no.dnb.toolbartest.model.dailyweather;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("dt")
    private Integer dt;
    @SerializedName("temp")
    private Temp temp;
    @SerializedName("pressure")
    private Double pressure;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("weather")
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("speed")
    private Double speed;
    @SerializedName("deg")
    private Integer deg;
    @SerializedName("clouds")
    private Integer clouds;
    @SerializedName("rain")
    private Double rain;

    /**
     * 
     * @return
     *     The dt
     */
    public Integer getDt() {
        return dt;
    }

    /**
     * 
     * @param dt
     *     The dt
     */
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * 
     * @return
     *     The temp
     */
    public Temp getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The weather
     */
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * 
     * @return
     *     The speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 
     * @return
     *     The deg
     */
    public Integer getDeg() {
        return deg;
    }

    /**
     * 
     * @param deg
     *     The deg
     */
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    /**
     *
     * @return
     *     The clouds
     */
    public Integer getClouds() {
        return clouds;
    }

    /**
     *
     * @param clouds
     *     The clouds
     */
    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * @return
     *     The rain
     */
    public Double getRain() {
        return rain;
    }

    /**
     * 
     * @param rain
     *     The rain
     */
    public void setRain(Double rain) {
        this.rain = rain;
    }

}
