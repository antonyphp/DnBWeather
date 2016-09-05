
package no.dnb.toolbartest.model.weatheroverview;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private Float temp;
    @SerializedName("pressure")
    private float pressure;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("temp_min")
    private Float tempMin;
    @SerializedName("temp_max")
    private Float tempMax;

    /**
     * 
     * @return
     *     The temp
     */
    public Float getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    public void setTemp(Float temp) {
        this.temp = temp;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public Integer getPressure() {
        return (int)pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(Integer pressure) {
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
     *     The tempMin
     */
    public Float getTempMin() {
        return tempMin;
    }

    /**
     * 
     * @param tempMin
     *     The temp_min
     */
    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * 
     * @return
     *     The tempMax
     */
    public Float getTempMax() {
        return tempMax;
    }

    /**
     * 
     * @param tempMax
     *     The temp_max
     */
    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

}
