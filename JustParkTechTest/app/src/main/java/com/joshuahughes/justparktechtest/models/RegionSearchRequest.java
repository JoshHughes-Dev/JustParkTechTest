package com.joshuahughes.justparktechtest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegionSearchRequest {

    @SerializedName("near")
    @Expose
    private Near near;

    /**
     *
     * @return
     * The near
     */
    public Near getNear() {
        return near;
    }

    /**
     *
     * @param near
     * The near
     */
    public void setNear(Near near) {
        this.near = near;
    }

}
