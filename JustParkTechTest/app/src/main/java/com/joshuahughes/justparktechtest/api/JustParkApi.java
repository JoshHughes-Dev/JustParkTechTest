package com.joshuahughes.justparktechtest.api;

import com.joshuahughes.justparktechtest.models.RegionSearchRequest;
import com.joshuahughes.justparktechtest.models.RegionSearchResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JustParkApi {

    @POST("search/region")
    Call<RegionSearchResponse> regionSearch(@Body RegionSearchRequest regionSearchRequest);
}

