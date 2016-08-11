
package com.joshuahughes.justparktechtest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StreetviewData implements Parcelable {

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
    private Double zoom;

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
    public Double getZoom() {
        return zoom;
    }

    /**
     * 
     * @param zoom
     *     The zoom
     */
    public void setZoom(Double zoom) {
        this.zoom = zoom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.lat);
        dest.writeValue(this.lng);
        dest.writeValue(this.heading);
        dest.writeValue(this.pitch);
        dest.writeValue(this.zoom);
    }

    public StreetviewData() {
    }

    protected StreetviewData(Parcel in) {
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.lng = (Double) in.readValue(Double.class.getClassLoader());
        this.heading = (Double) in.readValue(Double.class.getClassLoader());
        this.pitch = (Double) in.readValue(Double.class.getClassLoader());
        this.zoom = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<StreetviewData> CREATOR = new Parcelable.Creator<StreetviewData>() {
        @Override
        public StreetviewData createFromParcel(Parcel source) {
            return new StreetviewData(source);
        }

        @Override
        public StreetviewData[] newArray(int size) {
            return new StreetviewData[size];
        }
    };
}
