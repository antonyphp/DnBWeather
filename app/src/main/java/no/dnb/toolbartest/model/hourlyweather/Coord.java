
package no.dnb.toolbartest.model.hourlyweather;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lon")
    private Float lon;
    @SerializedName("lat")
    private Float lat;

    /**
     * 
     * @return
     *     The lon
     */
    public Float getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(Float lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Float getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Float lat) {
        this.lat = lat;
    }

}
