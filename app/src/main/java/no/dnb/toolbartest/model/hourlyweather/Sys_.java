
package no.dnb.toolbartest.model.hourlyweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys_ {

    @SerializedName("pod")
    private String pod;

    /**
     * 
     * @return
     *     The pod
     */
    public String getPod() {
        return pod;
    }

    /**
     * 
     * @param pod
     *     The pod
     */
    public void setPod(String pod) {
        this.pod = pod;
    }

}
