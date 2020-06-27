package com.example.neutronxstudios.tea_winding;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.neutronxstudios.tea_winding.model.BalanceData;
import com.example.neutronxstudios.tea_winding.model.BalanceResponse;
import com.example.neutronxstudios.tea_winding.service.BalanceService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {
Button  cash1,upi1;
String id,totalprice,salon,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        id = getIntent().getStringExtra("id");
        salon = getIntent().getStringExtra("salonname");
        totalprice = getIntent().getStringExtra("totalprice");
        number = getIntent().getStringExtra("number");

        upi1=(Button)findViewById(R.id.upi);
cash1=(Button)findViewById(R.id.cash);

cash1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});


        upi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmActivity.this,Main2Activity.class);
                intent.putExtra("id",id);
                intent.putExtra("salonname",salon);
                intent.putExtra("totalprice",totalprice);
                intent.putExtra("number",number);

                startActivity(intent);
            }
        });


    }
}
