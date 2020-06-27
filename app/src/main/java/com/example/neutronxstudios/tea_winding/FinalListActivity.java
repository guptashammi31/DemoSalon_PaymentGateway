package com.example.neutronxstudios.tea_winding;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.text.Text;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FinalListActivity extends AppCompatActivity {
    private String totalprice,list,barbournm;
    TextView amount,alllist,dates,barbourname;
    FirebaseUser user;
TextView t1,t2,t3,t5,t6,t7,t9,t10,t11;
    ProgressDialog progressDialog ;
    int day,month,year,hour,min;
    TextView editdate;
    String Mytime;
EditText editname1,editnumber;
    String dmy,ymd,mh,davl,email;
    Calendar c;
    private FirebaseAuth auth;
   private DatabaseReference Reference;
    String emailidd="guptashammi31@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_list);
        barbournm = getIntent().getStringExtra("barbourname");
        totalprice = getIntent().getStringExtra("totalprice");
        list = getIntent().getStringExtra("list");
        Button submit;
        editname1 = (EditText) findViewById(R.id.editname);
        editnumber = (EditText) findViewById(R.id.editmob);

        amount = (TextView) findViewById(R.id.textView20);
        alllist = (TextView) findViewById(R.id.list);
        //dates = (TextView) findViewById(R.id.textView25);
        barbourname = (TextView) findViewById(R.id.textView11);
        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        emailidd=user.getEmail();
        email=emailidd;
        amount.setText(totalprice);
        alllist.setText(list);
       barbourname.setText(barbournm);


        c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);

        String hr = String.valueOf(hour);
        String mn = String.valueOf(min);

        mh=hr+" : "+mn;

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        month=month+1;
        day = c.get(Calendar.DAY_OF_MONTH);

        String dd = String.valueOf(day);
        String mm = String.valueOf(month);
        String yy = String.valueOf(year);
        dmy=dd +"/" + mm + "/"+ yy;
        ymd=yy+"/"+mm+"/"+dd;
        editdate = (TextView) findViewById(R.id.datee);

        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t9=(TextView)findViewById(R.id.t9);
        t10=(TextView)findViewById(R.id.t10);
        t11=(TextView)findViewById(R.id.t11);


        Reference = FirebaseDatabase.getInstance().getReference();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                t1.setBackgroundColor(Color.RED);
                Mytime="9:30AM";

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setBackgroundColor(Color.RED);
                Mytime="10:30AM";


            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3.setBackgroundColor(Color.RED);
                Mytime="11:30AM";


            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t5.setBackgroundColor(Color.RED);
                Mytime="12:30PM";


            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t6.setBackgroundColor(Color.RED);
                Mytime="01:30PM";


            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7.setBackgroundColor(Color.RED);
                Mytime="02:30PM";


            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9.setBackgroundColor(Color.RED);
                Mytime="03:30PM";


            }
        });
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t10.setBackgroundColor(Color.RED);
                Mytime="04:30PM";



            }
        });
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t11.setBackgroundColor(Color.RED);
                Mytime="05:30PM";


            }
        });




        editdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date

                DatePickerDialog dd = new DatePickerDialog(FinalListActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                try {
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                    Date date = formatter.parse(dateInString);

                                    editdate.setText(formatter.format(date).toString());


                                } catch (Exception ex) {

                                }


                            }
                        }, year, month, day);
                dd.show();
            }
        });




       submit=(Button)findViewById(R.id.submit);
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name = editname1.getText().toString().trim();

               if (TextUtils.isEmpty(name)) {
                   Toast.makeText(getApplicationContext(), "Please Enter  Name!", Toast.LENGTH_SHORT).show();
                   return;
               }

               if (editnumber.getText().toString().trim().length() < 6) {
                   Toast.makeText(getApplicationContext(), " Please Enter Number", Toast.LENGTH_SHORT).show();
                   return;
               }
               if (TextUtils.isEmpty(Mytime)) {
                   Toast.makeText(getApplicationContext(), "Please select  time!", Toast.LENGTH_SHORT).show();
                   return;
               }


               UploadImageFileToFirebaseStorage();
           }
       });
    }
    public void UploadImageFileToFirebaseStorage() {

        String name = editname1.getText().toString().trim();
        String Number = editnumber.getText().toString().trim();
        String Daate = editdate.getText().toString().trim();
        String Discription = alllist.getText().toString().trim();
        String salonname = barbourname.getText().toString().trim();
        String amount1 = amount.getText().toString().trim();
        String status="pending";
         String payment="cash";

        BookingDetails Name1 = new BookingDetails(emailidd,salonname,Daate,amount1,Discription,name,Number,status,payment,Mytime);

        String ImageUploadId = Reference.push().getKey();


      Reference.child("Booking").child(salonname).child(ImageUploadId).setValue(Name1);
       Reference.child("Customer_order").child(Daate).child(Number).child(ImageUploadId).setValue(Name1);
       Reference.child("Booking_Date_Time").child(Daate).child(ImageUploadId).setValue(Mytime);
        Toast.makeText(this, "data Saved,Select Payment Method...", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(FinalListActivity.this, ConfirmActivity.class);
        intent.putExtra("id",ImageUploadId);
        intent.putExtra("salonname",salonname);
        intent.putExtra("totalprice",amount1);
        intent.putExtra("number",Number);
        startActivity(intent);

    }

}
