package com.joshuahughes.justparktechtest;

import android.content.res.Resources;

import com.joshuahughes.justparktechtest.models.Datum;

import java.util.Locale;

/**
 * Class of static methods to help format data ready for UI
 */
public class Utils {

    public static String getFormattedPrice(String currencySymbol, Double price){
        return currencySymbol + String.format(Locale.UK, "%.2f",price);
    }

    public static String getFormattedReviewScore(Resources resources, Datum datum){
        return String.format(resources.getString(
                R.string.review_score),
                datum.getReviewAverage().toString(),
                datum.getReviewCount().toString()
        );
    }

    public static String getFormattedDistance(Resources resources, Datum datum){
        String distance;
        if(datum.getDistance() > 1){
            distance = String.format(Locale.UK, "%.2f km", datum.getDistance());
        }
        else {
            Double distMeters = Math.floor(datum.getDistance() * 1000);
            Integer distInt = distMeters.intValue();
            distance = String.format(resources.getString(R.string.distance_meters), Integer.toString(distInt));
        }

        return distance;
    }

    public static String getFormattedDailyWeeklyPrice(Resources resources, Datum datum){

        String priceDay = Utils.getFormattedPrice(
                datum.getCurrency().getSymbol(), datum.getPriceDay());

        String priceWeek = Utils.getFormattedPrice(
                datum.getCurrency().getSymbol(), datum.getPriceWeek());

        return String.format(resources.getString(R.string.daily_weekly_price),priceDay, priceWeek);
    }
}
