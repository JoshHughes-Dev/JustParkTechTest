package com.joshuahughes.justparktechtest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IntegrationPartner {

    @SerializedName("is_partner")
    @Expose
    private Boolean isPartner;
    @SerializedName("partner")
    @Expose
    private Object partner;
    @SerializedName("company_name")
    @Expose
    private Object companyName;
    @SerializedName("entry_method")
    @Expose
    private Object entryMethod;

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
    public Object getPartner() {
        return partner;
    }

    /**
     * 
     * @param partner
     *     The partner
     */
    public void setPartner(Object partner) {
        this.partner = partner;
    }

    /**
     * 
     * @return
     *     The companyName
     */
    public Object getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *     The company_name
     */
    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     *     The entryMethod
     */
    public Object getEntryMethod() {
        return entryMethod;
    }

    /**
     * 
     * @param entryMethod
     *     The entry_method
     */
    public void setEntryMethod(Object entryMethod) {
        this.entryMethod = entryMethod;
    }

}
