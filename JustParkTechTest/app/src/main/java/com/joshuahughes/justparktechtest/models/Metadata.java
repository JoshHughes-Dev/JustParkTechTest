
package com.joshuahughes.justparktechtest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata implements Parcelable {

    @SerializedName("location_lat")
    @Expose
    private Double locationLat;
    @SerializedName("location_lng")
    @Expose
    private Double locationLng;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("next")
    @Expose
    private String next;

    /**
     * 
     * @return
     *     The locationLat
     */
    public Double getLocationLat() {
        return locationLat;
    }

    /**
     * 
     * @param locationLat
     *     The location_lat
     */
    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    /**
     * 
     * @return
     *     The locationLng
     */
    public Double getLocationLng() {
        return locationLng;
    }

    /**
     * 
     * @param locationLng
     *     The location_lng
     */
    public void setLocationLng(Double locationLng) {
        this.locationLng = locationLng;
    }

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The perPage
     */
    public Integer getPerPage() {
        return perPage;
    }

    /**
     * 
     * @param perPage
     *     The per_page
     */
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    /**
     * 
     * @return
     *     The previous
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * 
     * @param previous
     *     The previous
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * 
     * @return
     *     The next
     */
    public String getNext() {
        return next;
    }

    /**
     * 
     * @param next
     *     The next
     */
    public void setNext(String next) {
        this.next = next;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.locationLat);
        dest.writeValue(this.locationLng);
        dest.writeValue(this.total);
        dest.writeValue(this.start);
        dest.writeValue(this.perPage);
        dest.writeString(this.previous);
        dest.writeString(this.next);
    }

    public Metadata() {
    }

    protected Metadata(Parcel in) {
        this.locationLat = (Double) in.readValue(Double.class.getClassLoader());
        this.locationLng = (Double) in.readValue(Double.class.getClassLoader());
        this.total = (Integer) in.readValue(Integer.class.getClassLoader());
        this.start = (Integer) in.readValue(Integer.class.getClassLoader());
        this.perPage = (Integer) in.readValue(Integer.class.getClassLoader());
        this.previous = in.readString();
        this.next = in.readString();
    }

    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        @Override
        public Metadata createFromParcel(Parcel source) {
            return new Metadata(source);
        }

        @Override
        public Metadata[] newArray(int size) {
            return new Metadata[size];
        }
    };
}
