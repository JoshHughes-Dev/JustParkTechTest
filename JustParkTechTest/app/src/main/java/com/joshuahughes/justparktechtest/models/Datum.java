
package com.joshuahughes.justparktechtest.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("custom_title")
    @Expose
    private String customTitle;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("price_hour")
    @Expose
    private Double priceHour;
    @SerializedName("price_day")
    @Expose
    private Integer priceDay;
    @SerializedName("price_week")
    @Expose
    private Integer priceWeek;
    @SerializedName("price_month")
    @Expose
    private Integer priceMonth;
    @SerializedName("address_lat")
    @Expose
    private Double addressLat;
    @SerializedName("address_lng")
    @Expose
    private Double addressLng;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("review_average")
    @Expose
    private Double reviewAverage;
    @SerializedName("address_1")
    @Expose
    private String address1;
    @SerializedName("address_2")
    @Expose
    private String address2;
    @SerializedName("address_3")
    @Expose
    private String address3;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("cancellation_policy")
    @Expose
    private String cancellationPolicy;
    @SerializedName("cancellation_policy_type")
    @Expose
    private String cancellationPolicyType;
    @SerializedName("facilities")
    @Expose
    private List<Facility> facilities = new ArrayList<Facility>();
    @SerializedName("integration_partner")
    @Expose
    private IntegrationPartner integrationPartner;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("review")
    @Expose
    private Review review;
    @SerializedName("gallery")
    @Expose
    private List<Gallery> gallery = new ArrayList<Gallery>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("streetview_data")
    @Expose
    private StreetviewData streetviewData;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * 
     * @param distance
     *     The distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The customTitle
     */
    public String getCustomTitle() {
        return customTitle;
    }

    /**
     * 
     * @param customTitle
     *     The custom_title
     */
    public void setCustomTitle(String customTitle) {
        this.customTitle = customTitle;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The priceHour
     */
    public Double getPriceHour() {
        return priceHour;
    }

    /**
     * 
     * @param priceHour
     *     The price_hour
     */
    public void setPriceHour(Double priceHour) {
        this.priceHour = priceHour;
    }

    /**
     * 
     * @return
     *     The priceDay
     */
    public Integer getPriceDay() {
        return priceDay;
    }

    /**
     * 
     * @param priceDay
     *     The price_day
     */
    public void setPriceDay(Integer priceDay) {
        this.priceDay = priceDay;
    }

    /**
     * 
     * @return
     *     The priceWeek
     */
    public Integer getPriceWeek() {
        return priceWeek;
    }

    /**
     * 
     * @param priceWeek
     *     The price_week
     */
    public void setPriceWeek(Integer priceWeek) {
        this.priceWeek = priceWeek;
    }

    /**
     * 
     * @return
     *     The priceMonth
     */
    public Integer getPriceMonth() {
        return priceMonth;
    }

    /**
     * 
     * @param priceMonth
     *     The price_month
     */
    public void setPriceMonth(Integer priceMonth) {
        this.priceMonth = priceMonth;
    }

    /**
     * 
     * @return
     *     The addressLat
     */
    public Double getAddressLat() {
        return addressLat;
    }

    /**
     * 
     * @param addressLat
     *     The address_lat
     */
    public void setAddressLat(Double addressLat) {
        this.addressLat = addressLat;
    }

    /**
     * 
     * @return
     *     The addressLng
     */
    public Double getAddressLng() {
        return addressLng;
    }

    /**
     * 
     * @param addressLng
     *     The address_lng
     */
    public void setAddressLng(Double addressLng) {
        this.addressLng = addressLng;
    }

    /**
     * 
     * @return
     *     The reviewCount
     */
    public Integer getReviewCount() {
        return reviewCount;
    }

    /**
     * 
     * @param reviewCount
     *     The review_count
     */
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    /**
     * 
     * @return
     *     The reviewAverage
     */
    public Double getReviewAverage() {
        return reviewAverage;
    }

    /**
     * 
     * @param reviewAverage
     *     The review_average
     */
    public void setReviewAverage(Double reviewAverage) {
        this.reviewAverage = reviewAverage;
    }

    /**
     * 
     * @return
     *     The address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 
     * @param address1
     *     The address_1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 
     * @return
     *     The address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 
     * @param address2
     *     The address_2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 
     * @return
     *     The address3
     */
    public String getAddress3() {
        return address3;
    }

    /**
     * 
     * @param address3
     *     The address_3
     */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
     * 
     * @return
     *     The postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode
     *     The postal_code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * @return
     *     The cancellationPolicy
     */
    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    /**
     * 
     * @param cancellationPolicy
     *     The cancellation_policy
     */
    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    /**
     * 
     * @return
     *     The cancellationPolicyType
     */
    public String getCancellationPolicyType() {
        return cancellationPolicyType;
    }

    /**
     * 
     * @param cancellationPolicyType
     *     The cancellation_policy_type
     */
    public void setCancellationPolicyType(String cancellationPolicyType) {
        this.cancellationPolicyType = cancellationPolicyType;
    }

    /**
     * 
     * @return
     *     The facilities
     */
    public List<Facility> getFacilities() {
        return facilities;
    }

    /**
     * 
     * @param facilities
     *     The facilities
     */
    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    /**
     * 
     * @return
     *     The integrationPartner
     */
    public IntegrationPartner getIntegrationPartner() {
        return integrationPartner;
    }

    /**
     * 
     * @param integrationPartner
     *     The integration_partner
     */
    public void setIntegrationPartner(IntegrationPartner integrationPartner) {
        this.integrationPartner = integrationPartner;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity
     *     The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return
     *     The review
     */
    public Review getReview() {
        return review;
    }

    /**
     * 
     * @param review
     *     The review
     */
    public void setReview(Review review) {
        this.review = review;
    }

    /**
     * 
     * @return
     *     The gallery
     */
    public List<Gallery> getGallery() {
        return gallery;
    }

    /**
     * 
     * @param gallery
     *     The gallery
     */
    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The streetviewData
     */
    public StreetviewData getStreetviewData() {
        return streetviewData;
    }

    /**
     * 
     * @param streetviewData
     *     The streetview_data
     */
    public void setStreetviewData(StreetviewData streetviewData) {
        this.streetviewData = streetviewData;
    }

}
