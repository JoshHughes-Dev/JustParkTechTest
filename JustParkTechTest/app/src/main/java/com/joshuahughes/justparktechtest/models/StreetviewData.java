
package com.joshuahughes.justparktechtest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StreetviewData {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("heading")
    @Expose
    private Double heading;
    @SerializedName("pitch")
    @Expose
    private Double pitch;
    @SerializedName("zoom")
    @Expose
    private Integer zoom;

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return
     *     The heading
     */
    public Double getHeading() {
        return heading;
    }

    /**
     * 
     * @param heading
     *     The heading
     */
    public void setHeading(Double heading) {
        this.heading = heading;
    }

    /**
     * 
     * @return
     *     The pitch
     */
    public Double getPitch() {
        return pitch;
    }

    /**
     * 
     * @param pitch
     *     The pitch
     */
    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    /**
     * 
     * @return
     *     The zoom
     */
    public Integer getZoom() {
        return zoom;
    }

    /**
     * 
     * @param zoom
     *     The zoom
     */
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

}
