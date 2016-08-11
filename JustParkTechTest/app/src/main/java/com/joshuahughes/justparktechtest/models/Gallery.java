package com.joshuahughes.justparktechtest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery implements Parcelable {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("normal")
    @Expose
    private Normal normal;

    /**
     * 
     * @return
     *     The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The normal
     */
    public Normal getNormal() {
        return normal;
    }

    /**
     * 
     * @param normal
     *     The normal
     */
    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.thumbnail, flags);
        dest.writeParcelable(this.normal, flags);
    }

    public Gallery() {
    }

    protected Gallery(Parcel in) {
        this.thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        this.normal = in.readParcelable(Normal.class.getClassLoader());
    }

    public static final Parcelable.Creator<Gallery> CREATOR = new Parcelable.Creator<Gallery>() {
        @Override
        public Gallery createFromParcel(Parcel source) {
            return new Gallery(source);
        }

        @Override
        public Gallery[] newArray(int size) {
            return new Gallery[size];
        }
    };
}
