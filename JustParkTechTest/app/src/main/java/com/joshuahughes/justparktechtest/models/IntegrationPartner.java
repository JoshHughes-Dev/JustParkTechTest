package com.joshuahughes.justparktechtest.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IntegrationPartner implements Parcelable {

    @SerializedName("is_partner")
    @Expose
    private Boolean isPartner;
    @SerializedName("partner")
    @Expose
    private String partner;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("entry_method")
    @Expose
    private String entryMethod;

    /**
     * 
     * @return
     *     The isPartner
     */
    public Boolean getIsPartner() {
        return isPartner;
    }

    /**
     * 
     * @param isPartner
     *     The is_partner
     */
    public void setIsPartner(Boolean isPartner) {
        this.isPartner = isPartner;
    }

    /**
     * 
     * @return
     *     The partner
     */
    public String getPartner() {
        return partner;
    }

    /**
     * 
     * @param partner
     *     The partner
     */
    public void setPartner(String partner) {
        this.partner = partner;
    }

    /**
     * 
     * @return
     *     The companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *     The company_name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     *     The entryMethod
     */
    public String getEntryMethod() {
        return entryMethod;
    }

    /**
     * 
     * @param entryMethod
     *     The entry_method
     */
    public void setEntryMethod(String entryMethod) {
        this.entryMethod = entryMethod;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.isPartner);
        dest.writeString(this.partner);
        dest.writeString(this.companyName);
        dest.writeString(this.entryMethod);
    }

    public IntegrationPartner() {
    }

    protected IntegrationPartner(Parcel in) {
        this.isPartner = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.partner = in.readString();
        this.companyName = in.readString();
        this.entryMethod = in.readString();
    }

    public static final Parcelable.Creator<IntegrationPartner> CREATOR = new Parcelable.Creator<IntegrationPartner>() {
        @Override
        public IntegrationPartner createFromParcel(Parcel source) {
            return new IntegrationPartner(source);
        }

        @Override
        public IntegrationPartner[] newArray(int size) {
            return new IntegrationPartner[size];
        }
    };
}
