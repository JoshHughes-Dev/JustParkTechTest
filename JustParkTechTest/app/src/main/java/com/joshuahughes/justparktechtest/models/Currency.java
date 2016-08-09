
package com.joshuahughes.justparktechtest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("code")
    @Expose
    private String code;

    /**
     * 
     * @return
     *     The symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 
     * @param symbol
     *     The symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

}
