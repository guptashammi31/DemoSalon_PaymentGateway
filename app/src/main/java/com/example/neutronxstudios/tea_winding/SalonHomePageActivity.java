package com.example.neutronxstudios.tea_winding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SalonHomePageActivity extends AppCompatActivity {
DatabaseReference ref;
    Button onn;
    Button off;
    TextView temp;
String str1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_home_page);
Button button=findViewById(R.id.book);
 onn=findViewById(R.id.onn);
 off=findViewById(R.id.off);
temp=findViewById(R.id.temp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SalonHomePageActivity.this, SalonConfirmationListActivity.class));
            }
        });

        ref = FirebaseDatabase.getInstance().getReference().child("salon");


        // total=(TextView)findViewById(R.id.totalnumber);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                onn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ref.child("s1").setValue("open");
                        Toast.makeText(getApplicationContext(), " salon is open", Toast.LENGTH_SHORT).show();
temp.setText("salon is open");
                    }
                });
                off.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ref.child("s1").setValue("close");
                        Toast.makeText(getApplicationContext(), " salon is closed", Toast.LENGTH_SHORT).show();
                        temp.setText("salon is closed");

                    }
                });
//
            }

            @Override
            public void onCancelled(DatabaseError dataSnapshot) {

            }
        });
    }

}
