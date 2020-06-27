package com.example.neutronxstudios.tea_winding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class ProfileFragment2 extends Fragment {
Button logout;
TextView emailfetch,mob_no,namee,walle;
    DatabaseReference ref;
String emailidd;
    FirebaseUser user;
    private FirebaseAuth auth;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv= inflater.inflate(R.layout.fragment_profile_fragment2, container, false);
        auth = FirebaseAuth.getInstance();
            walle=(TextView)vv.findViewById(R.id.walle);
            logout=(Button)vv.findViewById(R.id.logout);
            emailfetch=(TextView)vv.findViewById(R.id.emailfetch);
            mob_no=(TextView)vv.findViewById(R.id.mob_no);
        namee=(TextView)vv.findViewById(R.id.name11);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        emailidd=user.getEmail();
        ref= FirebaseDatabase.getInstance().getReference("customer");



        ref.orderByChild("emailid").equalTo(emailidd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String,Object> postValues=new HashMap<String,Object>();
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {


                    emailfetch.setText((String) locationSnapshot.child("emailid").getValue());
                    namee.setText((String) locationSnapshot.child("name").getValue());
                    mob_no.setText((String) locationSnapshot.child("phoneno").getValue());
                    walle.setText((String) locationSnapshot.child("wallet1").getValue());

                }
            }


            @Override
            public void onCancelled(DatabaseError dataSnapshot) {

            }
        });

                    return vv;
    }
    //sign out method
    public void signOut() {
        auth.signOut();
    }


}