
package no.dnb.toolbartest.model.hourlyweather;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("population")
    private Integer population;

    /**
     * 
     * @return
     *     The population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * 
     * @param population
     *     The population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

}
