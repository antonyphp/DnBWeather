
package no.dnb.toolbartest.model.hourlyweather;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private Float speed;
    @SerializedName("deg")
    private Float deg;

    /**
     * 
     * @return
     *     The speed
     */
    public Float getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    /**
     * 
     * @return
     *     The deg
     */
    public Float getDeg() {
        return deg;
    }

    /**
     * 
     * @param deg
     *     The deg
     */
    public void setDeg(Float deg) {
        this.deg = deg;
    }

}
