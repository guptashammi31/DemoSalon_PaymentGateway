package com.example.neutronxstudios.tea_winding;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.neutronxstudios.tea_winding.config.APIConstants;
import com.example.neutronxstudios.tea_winding.model.BalanceData;
import com.example.neutronxstudios.tea_winding.model.BalanceRequestModel;
import com.example.neutronxstudios.tea_winding.model.BalanceResponse;
import com.example.neutronxstudios.tea_winding.model.BalanceResponseModel;
import com.example.neutronxstudios.tea_winding.restapi.TeaWindingAPI;
import com.example.neutronxstudios.tea_winding.service.BalanceService;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMenuActivity extends AppCompatActivity {
    private JSONObject jsonObject;
    private  String machine_data;
    private String current_balance_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Scan Button

        //AutoRun
                new IntentIntegrator(MainMenuActivity.this).setCaptureActivity(ScannerActivity.class).initiateScan();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //We will get scan results here
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check for null
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
            } else {
                //show dialogue with result
                showResultDialogue(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //method to construct dialogue with scan results
    public void showResultDialogue(final String result) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Scan Result")
                .setMessage("Scanned result is " + result)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        String finalResult=result.replace("\"", "\"");

                        try {
                             jsonObject = new JSONObject(finalResult);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                             machine_data=jsonObject.getString("machine_id");
                             current_balance_data=jsonObject.getString("to_load");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        BalanceData balanceData=new BalanceData(Integer.valueOf(machine_data),Integer.valueOf(current_balance_data));
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://alpha.qubiseven.com/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        BalanceService service = retrofit.create(BalanceService.class);


                        Call<BalanceResponse> call=service.updateBalance(balanceData);
                        call.enqueue(new Callback<BalanceResponse>() {
                            @Override
                            public void onResponse(Call<BalanceResponse> call, Response<BalanceResponse> response) {


                                if(response.body().getSuccess().equals("True")) {
                                    Toast.makeText(getBaseContext(),"Succesfully updated", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(getBaseContext(),"update failed", Toast.LENGTH_SHORT).show();

                                }

                            }

                            @Override
                            public void onFailure(Call<BalanceResponse> call, Throwable t) {
                                Toast.makeText(getBaseContext(),"something went wrong.", Toast.LENGTH_SHORT).show();

                                Log.v("checkResponseProfile","check here");
                                t.printStackTrace();

                            }
                        });

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        //intent.putExtra("message", result);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
