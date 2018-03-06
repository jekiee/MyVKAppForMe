package com.example.jek.myvkappforme.rest.api;

import com.example.jek.myvkappforme.rest.model.response.BaseItemResponse;
import com.example.jek.myvkappforme.rest.model.response.Full;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jek on 06.03.2018.
 */

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("owner_id") String ownerId,
                                     @Query("access_token") String accessToken,
                                     @Query("extended") Integer extended,
                                     @Query("v") String version);
}
