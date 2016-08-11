
package com.joshuahughes.justparktechtest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionSearchResponse implements Parcelable {

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    /**
     * 
     * @return
     *     The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
        dest.writeParcelable(this.metadata, flags);
    }

    public RegionSearchResponse() {
    }

    protected RegionSearchResponse(Parcel in) {
        this.data = in.createTypedArrayList(Datum.CREATOR);
        this.metadata = in.readParcelable(Metadata.class.getClassLoader());
    }

    public static final Parcelable.Creator<RegionSearchResponse> CREATOR = new Parcelable.Creator<RegionSearchResponse>() {
        @Override
        public RegionSearchResponse createFromParcel(Parcel source) {
            return new RegionSearchResponse(source);
        }

        @Override
        public RegionSearchResponse[] newArray(int size) {
            return new RegionSearchResponse[size];
        }
    };
}
