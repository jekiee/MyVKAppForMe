package com.example.jek.myvkappforme.rest.api;

import com.example.jek.myvkappforme.rest.model.response.GetWallResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);

}