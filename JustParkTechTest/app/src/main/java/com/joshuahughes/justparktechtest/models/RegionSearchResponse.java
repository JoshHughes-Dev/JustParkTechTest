
package com.joshuahughes.justparktechtest.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionSearchResponse {

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

}
