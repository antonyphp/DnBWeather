
package no.dnb.toolbartest.model.dailyweather;

import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("day")
    private Double day;
    @SerializedName("min")
    private Double min;
    @SerializedName("max")
    private Double max;
    @SerializedName("night")
    private Double night;
    @SerializedName("eve")
    private Double eve;
    @SerializedName("morn")
    private Double morn;

    /**
     * 
     * @return
     *     The day
     */
    public Double getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    public void setDay(Double day) {
        this.day = day;
    }

    /**
     * 
     * @return
     *     The min
     */
    public Double getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The min
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The max
     */
    public Double getMax() {
        return max;
    }

    /**
     * 
     * @param max
     *     The max
     */
    public void setMax(Double max) {
        this.max = max;
    }

    /**
     * 
     * @return
     *     The night
     */
    public Double getNight() {
        return night;
    }

    /**
     * 
     * @param night
     *     The night
     */
    public void setNight(Double night) {
        this.night = night;
    }

    /**
     * 
     * @return
     *     The eve
     */
    public Double getEve() {
        return eve;
    }

    /**
     * 
     * @param eve
     *     The eve
     */
    public void setEve(Double eve) {
        this.eve = eve;
    }

    /**
     * 
     * @return
     *     The morn
     */
    public Double getMorn() {
        return morn;
    }

    /**
     * 
     * @param morn
     *     The morn
     */
    public void setMorn(Double morn) {
        this.morn = morn;
    }

}
