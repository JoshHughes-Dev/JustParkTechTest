package com.joshuahughes.justparktechtest;


import android.app.AlertDialog;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.joshuahughes.justparktechtest.api.ApiClient;
import com.joshuahughes.justparktechtest.api.JustParkApi;
import com.joshuahughes.justparktechtest.fragments.ListBottomSheetFragment;
import com.joshuahughes.justparktechtest.fragments.MapFragment;
import com.joshuahughes.justparktechtest.models.Datum;
import com.joshuahughes.justparktechtest.models.Near;
import com.joshuahughes.justparktechtest.models.RegionSearchRequest;
import com.joshuahughes.justparktechtest.models.RegionSearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main activity hosting several fragments as well as handling API client.
 */
public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener{

    private ProgressBar progressBar;
    private View bottomSheet;
    private FloatingActionButton fab;

    private boolean fabShown = false;
    private final String fabShownKey = "fabShownKey";

    private MapFragment mapFragment;
    private final String mapFragmentKey = "mapFragment";

    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mapFragment = (MapFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, mapFragmentKey);
            fabShown = savedInstanceState.getBoolean(fabShownKey);
        }
        else{
            //new instance of mapfragment
            mapFragment = (MapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.mapFragment);
        }


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        Button demoSearchButton = (Button) findViewById(R.id.demoSearchButton);
        demoSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                ApiRequest();
            }
        });

        bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        if(!fabShown) {
            fab.setTranslationY(fab.getHeight() + 160);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createResultsListDialog();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, mapFragmentKey, mapFragment);
        outState.putBoolean(fabShownKey,fabShown);
    }

    /**
     * creates and executes API request.
     * (creates input model, creates API client using Retrofit, executes call to JustPark API)
     */
    private void ApiRequest(){

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
            public void onResponse(Call<RegionSearchResponse> call,
                                   Response<RegionSearchResponse> response) {

                mapFragment.DrawNewResponse(response.body());
                progressBar.setVisibility(View.INVISIBLE);
                fab.animate().translationY(0).setInterpolator(
                        new DecelerateInterpolator(2)).start();
                fabShown = true;
            }

            @Override
            public void onFailure(Call<RegionSearchResponse> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle(R.string.request_error_dialog_title);
                builder.setMessage(R.string.request_error_dialog_message);
                builder.setCancelable(true);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    /**
     * from interface with MapFragment.
     * handles populating and opening of details bottom sheet when marker is pressed.
     * @param datum
     */
    @Override
    public void onMapFragmentMarkerClick(Datum datum){

        if(datum != null) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            TextView title = (TextView) bottomSheet.findViewById(R.id.detailsTitle);
            title.setText(datum.getTitle());

            TextView category = (TextView) bottomSheet.findViewById(R.id.detailsCategory);
            category.setText(datum.getCategory().toUpperCase());

            TextView prices = (TextView) bottomSheet.findViewById(R.id.detailsPrices);
            prices.setText(Utils.getFormattedDailyWeeklyPrice(getResources(), datum));

            TextView ratingsInfo = (TextView) bottomSheet.findViewById(R.id.detailsRatingInfo);
            RatingBar ratings = (RatingBar) bottomSheet.findViewById(R.id.detailsRatingBar);

            if(datum.getReviewCount() > 0){
                ratingsInfo.setText(Utils.getFormattedReviewScore(getResources(), datum));
                ratings.setMax(5);
                ratings.setNumStars(5);
                ratings.setRating(datum.getReviewAverage().floatValue());
            }
            else{
                ratingsInfo.setText(getResources().getString(R.string.no_review));
                ratings.setVisibility(View.GONE);
            }

            TextView distanceTextView = (TextView) bottomSheet.findViewById(R.id.detailsDistance);
            distanceTextView.setText(Utils.getFormattedDistance(getResources(), datum));

            TextView spacesTextView = (TextView) bottomSheet.findViewById(R.id.detailsSpaces);
            spacesTextView.setText(String.format(
                    getResources().getString(R.string.spaces), datum.getQuantity().toString())
            );
        }
        else{
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

    }

    /**
     * Creates new instance of Results list fragment (bottom sheet), populating and showing it.
     */
    private void createResultsListDialog(){
        ListBottomSheetFragment listBottomSheetFragment = ListBottomSheetFragment.newInstance(
                mapFragment.getRegionSearchResponseData());
        listBottomSheetFragment.show(getSupportFragmentManager(), listBottomSheetFragment.getTag());
    }
}
