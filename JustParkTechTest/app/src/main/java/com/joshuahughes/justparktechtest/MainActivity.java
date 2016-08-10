package com.joshuahughes.justparktechtest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


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
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testApiButton = (Button) findViewById(R.id.testApiButton);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);


        testApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                ApiConfig();
            }
        });
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

                mapFragment.AddResultsToMap(response.body());

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
    public void onFragmentInteraction(){}
}
