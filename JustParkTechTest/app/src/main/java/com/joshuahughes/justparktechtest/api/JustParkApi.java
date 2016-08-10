package com.joshuahughes.justparktechtest.api;

import com.joshuahughes.justparktechtest.models.RegionSearchRequest;
import com.joshuahughes.justparktechtest.models.RegionSearchResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by joshuahughes on 10/08/2016.
 */
public interface JustParkApi {

    @POST("search/region")
    Call<RegionSearchResponse> regionSearch(@Body RegionSearchRequest regionSearchRequest);
}

