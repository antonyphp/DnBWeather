
package no.dnb.toolbartest.model.weatheroverview;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private float speed;
    @SerializedName("deg")
    private float deg;

    /**
     * 
     * @return
     *     The speed
     */
    public float getSpeed() {
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
    public Integer getDeg() {
        return (int)deg;
    }

    /**
     * 
     * @param deg
     *     The deg
     */
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

}
