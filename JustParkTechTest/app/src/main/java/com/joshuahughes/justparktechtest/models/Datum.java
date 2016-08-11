
package com.joshuahughes.justparktechtest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable {

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
    private Double price;
    @SerializedName("price_hour")
    @Expose
    private Double priceHour;
    @SerializedName("price_day")
    @Expose
    private Double priceDay;
    @SerializedName("price_week")
    @Expose
    private Double priceWeek;
    @SerializedName("price_month")
    @Expose
    private Double priceMonth;
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
    public Double getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(Double price) {
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
    public Double getPriceDay() {
        return priceDay;
    }

    /**
     * 
     * @param priceDay
     *     The price_day
     */
    public void setPriceDay(Double priceDay) {
        this.priceDay = priceDay;
    }

    /**
     * 
     * @return
     *     The priceWeek
     */
    public Double getPriceWeek() {
        return priceWeek;
    }

    /**
     * 
     * @param priceWeek
     *     The price_week
     */
    public void setPriceWeek(Double priceWeek) {
        this.priceWeek = priceWeek;
    }

    /**
     * 
     * @return
     *     The priceMonth
     */
    public Double getPriceMonth() {
        return priceMonth;
    }

    /**
     * 
     * @param priceMonth
     *     The price_month
     */
    public void setPriceMonth(Double priceMonth) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.url);
        dest.writeValue(this.distance);
        dest.writeString(this.title);
        dest.writeString(this.customTitle);
        dest.writeParcelable(this.currency, flags);
        dest.writeValue(this.price);
        dest.writeValue(this.priceHour);
        dest.writeValue(this.priceDay);
        dest.writeValue(this.priceWeek);
        dest.writeValue(this.priceMonth);
        dest.writeValue(this.addressLat);
        dest.writeValue(this.addressLng);
        dest.writeValue(this.reviewCount);
        dest.writeValue(this.reviewAverage);
        dest.writeString(this.address1);
        dest.writeString(this.address2);
        dest.writeString(this.address3);
        dest.writeString(this.postalCode);
        dest.writeString(this.cancellationPolicy);
        dest.writeString(this.cancellationPolicyType);
        dest.writeTypedList(facilities);
        dest.writeParcelable(this.integrationPartner, flags);
        dest.writeParcelable(this.location, flags);
        dest.writeString(this.category);
        dest.writeValue(this.quantity);
        dest.writeParcelable(this.review, flags);
        dest.writeTypedList(gallery);
        dest.writeString(this.description);
        dest.writeParcelable(this.streetviewData, flags);
    }

    public Datum() {
    }

    protected Datum(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.url = in.readString();
        this.distance = (Double) in.readValue(Double.class.getClassLoader());
        this.title = in.readString();
        this.customTitle = in.readString();
        this.currency = in.readParcelable(Currency.class.getClassLoader());
        this.price = (Double) in.readValue(Double.class.getClassLoader());
        this.priceHour = (Double) in.readValue(Double.class.getClassLoader());
        this.priceDay = (Double) in.readValue(Double.class.getClassLoader());
        this.priceWeek = (Double) in.readValue(Double.class.getClassLoader());
        this.priceMonth = (Double) in.readValue(Double.class.getClassLoader());
        this.addressLat = (Double) in.readValue(Double.class.getClassLoader());
        this.addressLng = (Double) in.readValue(Double.class.getClassLoader());
        this.reviewCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.reviewAverage = (Double) in.readValue(Double.class.getClassLoader());
        this.address1 = in.readString();
        this.address2 = in.readString();
        this.address3 = in.readString();
        this.postalCode = in.readString();
        this.cancellationPolicy = in.readString();
        this.cancellationPolicyType = in.readString();
        this.facilities = in.createTypedArrayList(Facility.CREATOR);
        this.integrationPartner = in.readParcelable(IntegrationPartner.class.getClassLoader());
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.category = in.readString();
        this.quantity = (Integer) in.readValue(Integer.class.getClassLoader());
        this.review = in.readParcelable(Review.class.getClassLoader());
        this.gallery = in.createTypedArrayList(Gallery.CREATOR);
        this.description = in.readString();
        this.streetviewData = in.readParcelable(StreetviewData.class.getClassLoader());
    }

    public static final Parcelable.Creator<Datum> CREATOR = new Parcelable.Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel source) {
            return new Datum(source);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };
}
