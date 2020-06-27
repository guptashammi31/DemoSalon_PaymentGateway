package com.example.neutronxstudios.tea_winding.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 27-08-2019.
 */

public class BalanceRequestModel {

    @SerializedName("current_balance")
    private Integer currentBalance;

    @SerializedName("machine")
    private Integer machine;


    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Integer getMachine() {
        return machine;
    }

    public void setMachine(Integer machine) {
        this.machine = machine;
    }
}
