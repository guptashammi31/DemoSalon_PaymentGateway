package com.example.neutronxstudios.tea_winding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SalonLoginActivity extends AppCompatActivity {
DatabaseReference ref;
String str1="123456",str2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_login);
        EditText e=findViewById(R.id.send_email);
Button b1=findViewById(R.id.btn_reset);
//        ref = FirebaseDatabase.getInstance().getReference().child("salon");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists())
//                {
//                    str1=((String) dataSnapshot.child("s1").getValue());
//
////
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError dataSnapshot) {
//
//            }
//        });
         str2= e.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                if("123456"==("123456")){
                    Intent i = new Intent(SalonLoginActivity.this, SalonHomePageActivity.class);
                    startActivity(i);
                }
                else{
                   // Toast.makeText(getContext(), " salon is closed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
