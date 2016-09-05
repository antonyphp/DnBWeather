
package no.dnb.toolbartest.model.hourlyweather;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private Float temp;
    @SerializedName("temp_min")
    private Float tempMin;
    @SerializedName("temp_max")
    private Float tempMax;
    @SerializedName("pressure")
    private Float pressure;
    @SerializedName("sea_level")
    private Float seaLevel;
    @SerializedName("grnd_level")
    private Float grndLevel;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("temp_kf")
    private float tempKf;

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

    /**
     * 
     * @return
     *     The pressure
     */
    public Float getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The seaLevel
     */
    public Float getSeaLevel() {
        return seaLevel;
    }

    /**
     * 
     * @param seaLevel
     *     The sea_level
     */
    public void setSeaLevel(Float seaLevel) {
        this.seaLevel = seaLevel;
    }

    /**
     * 
     * @return
     *     The grndLevel
     */
    public Float getGrndLevel() {
        return grndLevel;
    }

    /**
     * 
     * @param grndLevel
     *     The grnd_level
     */
    public void setGrndLevel(Float grndLevel) {
        this.grndLevel = grndLevel;
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
     *     The tempKf
     */
    public Integer getTempKf() {
        return (int)tempKf;
    }

    /**
     * 
     * @param tempKf
     *     The temp_kf
     */
    public void setTempKf(float tempKf) {
        this.tempKf = tempKf;
    }

}
