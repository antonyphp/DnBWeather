
package no.dnb.toolbartest.model.weatheroverview;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("type")
    private Integer type;
    @SerializedName("id")
    private Integer id;
    @SerializedName("message")
    private Float message;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private long sunrise;
    @SerializedName("sunset")
    private long sunset;

    /**
     * 
     * @return
     *     The type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The message
     */
    public Float getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(Float message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The sunrise
     */
    public long getSunrise() {
        return sunrise;
    }

    /**
     * 
     * @param sunrise
     *     The sunrise
     */
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * 
     * @return
     *     The sunset
     */
    public long getSunset() {
        return sunset;
    }

    /**
     * 
     * @param sunset
     *     The sunset
     */
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}
