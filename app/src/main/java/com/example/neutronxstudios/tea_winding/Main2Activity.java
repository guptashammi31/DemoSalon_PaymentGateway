package com.example.neutronxstudios.tea_winding;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    String amount;

    DatabaseReference databaseReference;
    TextView amountEt, noteEt, nameEt, upiIdEt;
    Button send;
    int  money=1;
    final int UPI_PAYMENT = 0;
    DatabaseReference ref;
    TextView wallet,temptext;
    String strDate;
    String emailidd;
    String date = DateFormat.getDateTimeInstance().format(new Date());
    FirebaseUser user;
    private FirebaseAuth auth;
    String id,salon,totalprice,number;
    String TotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        id = getIntent().getStringExtra("id");
        salon = getIntent().getStringExtra("salonname");
        totalprice = getIntent().getStringExtra("totalprice");
        number = getIntent().getStringExtra("number");



        send = findViewById(R.id.send);
        amountEt = findViewById(R.id.amount_et);
        amountEt.setText("1");

        //temptext=findViewById(R.id.temptetx);
       // upiIdEt = findViewById(R.id.upi_id);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        strDate = "Current Date : " + mdformat.format(calendar.getTime());
        final String str ="8908780503@paytm";
        final String name = "NeutronX studio's";
        final String note = "Welcome To BOQ";

        databaseReference = FirebaseDatabase.getInstance().getReference();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting the values from the EditTexts
                amount = amountEt.getText().toString();


                payUsingUpi(amount, str, name, note);
            }
        });


        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        emailidd=user.getEmail();
        ref= FirebaseDatabase.getInstance().getReference("customer");




    }




    void payUsingUpi(String amount, String upiId, String name, String note) {

        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();


        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        // check if intent resolves
        if(null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(Main2Activity.this,"No UPI app found, please install one to continue", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        Log.d("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        Log.d("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    Log.d("UPI", "onActivityResult: " + "Return data is null"); //when user simply back without payment
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(Main2Activity.this)) {
            String str = data.get(0);
            Log.d("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if(equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    }
                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                }
                else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }

            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(Main2Activity.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.d("UPI", "responseStr: "+approvalRefNo);
                AddWallet(amount,emailidd,date);
                UpdateWallet(amount);
                UpdatePayment();
                Intent myIntent = new Intent(Main2Activity.this, HomeActivity.class);

                startActivity(myIntent);
            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(Main2Activity.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Main2Activity.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Main2Activity.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    private void AddWallet(String AddAmount,String Emailid,String date) {



        AddMoneyClass addwallet = new AddMoneyClass(Emailid,AddAmount,date);



        String key = databaseReference.push().getKey();
        databaseReference.child("Wallet History").child(strDate).child(key).setValue(addwallet);

        //displaying a success toast
        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
    }

    private void  UpdateWallet(final String am){

        ref.orderByChild("emailid").equalTo(emailidd).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot datas : dataSnapshot.getChildren()) {
                        String key=datas.getKey();
                        String fetch=datas.child("wallet1").getValue().toString();
                      Float  fetchAmount = Float.parseFloat(fetch);
                       Float addValue = Float.parseFloat(am)+fetchAmount;
                        String s=Float.toString(addValue);
                        ref.child(key).child("wallet1").setValue(s);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    private void UpdatePayment(){
        databaseReference.child("Booking").child(salon).child(id).child("payment").setValue("paid");
        databaseReference.child("Customer_order").child(number).child(id).child("payment").setValue("paid");

    }
}

