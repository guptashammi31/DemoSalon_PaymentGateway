package com.example.neutronxstudios.tea_winding.service;


import com.example.neutronxstudios.tea_winding.model.BalanceData;
import com.example.neutronxstudios.tea_winding.model.BalanceResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface BalanceService {

    @POST("api/wallet/1/")
    Call<BalanceResponse> updateBalance(@Body BalanceData balanceData);
}







