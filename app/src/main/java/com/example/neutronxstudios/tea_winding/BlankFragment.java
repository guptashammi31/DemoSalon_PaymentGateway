package com.example.neutronxstudios.tea_winding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Toast;

public class BlankFragment extends Fragment implements View.OnClickListener {
Button AddButton;
    DatabaseReference ref;
    TextView wallet;
    FirebaseUser user;
    Context context;
    ImageView i1,i2,i3;
    String str2="open",str1="a",str3,str4;
    private FirebaseAuth auth;
ImageView scanme;
String email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        AddButton  = (Button) v.findViewById(R.id.AddButton);
        scanme=(ImageView)v.findViewById(R.id.scanme);
        wallet=(TextView)v.findViewById(R.id.wallet);
        Button btncall=(Button)v.findViewById(R.id.btncall);
        i1=(ImageView) v.findViewById(R.id.i1);
        i2=(ImageView) v.findViewById(R.id.i2);
        i3=(ImageView) v.findViewById(R.id.i3);

        ref = FirebaseDatabase.getInstance().getReference().child("salon");


       // total=(TextView)findViewById(R.id.totalnumber);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    str1=((String) dataSnapshot.child("s1").getValue());
                     str3=((String) dataSnapshot.child("s2").getValue());
                        str4=((String) dataSnapshot.child("s3").getValue());
//
                }
            }

            @Override
            public void onCancelled(DatabaseError dataSnapshot) {

            }
        });




        i1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
if(str1.equals(str2)){
                Intent intent = new Intent(getActivity().getApplication(), ServiceListActivity.class);
                intent.putExtra("barbourname", "THE COLOR PALETTE");
                startActivity(intent);
            }
            else{
    Toast.makeText(getContext(), " salon is closed", Toast.LENGTH_SHORT).show();

}
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(str3.equals(str2)){


                Intent intent = new Intent(getActivity().getApplication(), ServiceListActivity.class);
                intent.putExtra("barbourname", "BED HEAD ");
                startActivity(intent);}
                else{
                    Toast.makeText(getContext(), " salon is closed", Toast.LENGTH_SHORT).show();

                }
            }
        });


        i2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
if(str4.equals(str2)){
                Intent intent = new Intent(getActivity().getApplication(), ServiceListActivity.class);
                intent.putExtra("barbourname", "SWEET PIXIE SALON ");
                startActivity(intent);}
else{
    Toast.makeText(getContext(), " salon is closed", Toast.LENGTH_SHORT).show();

}
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+"7991062503"));
                startActivity(intent);
            }
        });
        AddButton.setOnClickListener((View.OnClickListener) this);

        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();



        email=user.getEmail();
        ref= FirebaseDatabase.getInstance().getReference("customer");

        ref.orderByChild("emailid").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {


                    wallet.setText((String) locationSnapshot.child("wallet1").getValue());
                }
            }


            @Override
            public void onCancelled(DatabaseError dataSnapshot) {

            }
        });


        return v;

         }
     @Override
    public void onClick(View v){
        switch (v.getId())
        {
         case R.id.AddButton:
            Intent intent =new Intent(getActivity(),BookingHistoryActivity.class);
            startActivity(intent);
             break;

             case R.id.scanme:
                Intent intet =new Intent(getActivity(),MainMenuActivity.class);
                startActivity(intet);
                break;
        }
     }
}
