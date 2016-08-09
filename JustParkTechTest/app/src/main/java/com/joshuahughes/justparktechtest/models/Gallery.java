package com.joshuahughes.justparktechtest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery {

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

}
