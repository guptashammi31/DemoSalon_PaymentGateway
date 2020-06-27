package com.example.neutronxstudios.tea_winding;

/**
 * Created by INTEL on 3/25/2017.
 */

public class UserInformation {
    public String emailid;
    public String name;
    public String pass;
    public String phoneno;
    public String wallet1;
    public UserInformation(){

    }

    public UserInformation(String emaiid, String name, String password, String phoneno,String wallet) {
        this.emailid = emaiid;
        this.name = name;
        this.pass = password;
        this.phoneno=phoneno;
        this.wallet1=wallet;
    }
}