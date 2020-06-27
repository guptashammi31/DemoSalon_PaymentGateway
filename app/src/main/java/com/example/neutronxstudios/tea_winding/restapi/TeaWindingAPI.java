package com.example.neutronxstudios.tea_winding.restapi;

import com.example.neutronxstudios.tea_winding.model.BalanceRequestModel;
import com.example.neutronxstudios.tea_winding.model.BalanceResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hp on 27-08-2019.
 */

public interface TeaWindingAPI {

    @POST("/")
    public Call<BalanceResponseModel> updateBalance(@Body BalanceRequestModel balanceRequestModel);


}
