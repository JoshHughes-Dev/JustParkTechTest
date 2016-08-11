package com.joshuahughes.justparktechtest;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;


import com.google.android.gms.vision.text.Text;
import com.joshuahughes.justparktechtest.api.ApiClient;
import com.joshuahughes.justparktechtest.api.JustParkApi;
import com.joshuahughes.justparktechtest.fragments.MapFragment;
import com.joshuahughes.justparktechtest.models.Datum;
import com.joshuahughes.justparktechtest.models.Near;
import com.joshuahughes.justparktechtest.models.RegionSearchRequest;
import com.joshuahughes.justparktechtest.models.RegionSearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener{

    private ProgressBar progressBar;
    private View bottomSheet;

    private MapFragment mapFragment;
    private final String mapFragmentKey = "mapfragment";


    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mapFragment = (MapFragment) getSupportFragmentManager().getFragment(savedInstanceState, mapFragmentKey);
        }
        else{
            //new instance of mapfragment
            mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);

        }


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        Button testApiButton = (Button) findViewById(R.id.testApiButton);
        testApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                ApiConfig();
            }
        });

        bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, mapFragmentKey, mapFragment);
    }

    private void ApiConfig(){

        RegionSearchRequest model = new RegionSearchRequest();
        Near near = new Near();
        near.setLat("51.5560241");
        near.setLng("-0.2817075");
        near.setDistance(100);
        model.setNear(near);

        JustParkApi justParkApi = ApiClient.getClient().create(JustParkApi.class);

        Call<RegionSearchResponse> call = justParkApi.regionSearch(model);
        call.enqueue(new Callback<RegionSearchResponse>() {
            @Override
            public void onResponse(Call<RegionSearchResponse> call, Response<RegionSearchResponse> response) {
                List<Datum> data = response.body().getData();
                Log.d("test","success: " + data.size());

                mapFragment.DrawNewResponse(response.body());

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<RegionSearchResponse> call, Throwable t) {
                Log.d("test", t.toString());
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onMapFragmentMarkerClick(Datum datum){

        if(datum != null) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            TextView title = (TextView) bottomSheet.findViewById(R.id.detailsTitle);
            title.setText(datum.getTitle());

            TextView category = (TextView) bottomSheet.findViewById(R.id.detailsCategory);
            category.setText(datum.getCategory().toUpperCase());

            TextView prices = (TextView) bottomSheet.findViewById(R.id.detailsPrices);
            prices.setText(
                    datum.getCurrency().getSymbol() +
                    String.format("%.2f",datum.getPriceDay()) +
                    " per week / " +
                    datum.getCurrency().getSymbol() +
                    String.format("%.2f",datum.getPriceWeek()) +
                    " per month"
            );


            TextView ratingsInfo = (TextView) bottomSheet.findViewById(R.id.detailsRatingInfo);
            RatingBar ratings = (RatingBar) bottomSheet.findViewById(R.id.detailsRatingBar);

            if(datum.getReviewCount() > 0){
                ratingsInfo.setText(datum.getReviewAverage() + " (" + datum.getReviewCount() +")");
                ratings.setMax(5);
                ratings.setNumStars(5);
                ratings.setRating(datum.getReviewAverage().floatValue());
            }
            else{
                ratingsInfo.setText(" - Not review yet");
                ratings.setVisibility(View.GONE);
            }


            String dist = "";
            if(datum.getDistance() > 1){
                dist = String.format("%.2f km", datum.getDistance());
            }
            else {
                String distInMeters = Double.toString(Math.floor(datum.getDistance() * 1000));
                dist = distInMeters + " m";
            }

            TextView distanceTextView = (TextView) bottomSheet.findViewById(R.id.detailsDistance);
            distanceTextView.setText(dist);

            TextView spacesTextView = (TextView) bottomSheet.findViewById(R.id.detailsSpaces);
            spacesTextView.setText(datum.getQuantity() + " space(s)");

        }
        else{
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

    }
}
