package com.example.neutronxstudios.tea_winding;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ServiceListActivity extends AppCompatActivity {
    private String brbrname;
    int  c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18;
    int total,min,hour;
    Button fab;
    TextView brbr;
    Context contextt;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11;
    CheckBox checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,checkBox19,checkBox20;
    CheckBox checkBox21,checkBox22,checkBox23,checkBox24,checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        brbrname = getIntent().getStringExtra("barbourname");
        brbr=(TextView)findViewById(R.id.brbr);
       brbr.setText(brbrname);
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        checkBox5=(CheckBox)findViewById(R.id.checkBox5);
        checkBox6=(CheckBox)findViewById(R.id.checkBox6);
        checkBox7=(CheckBox)findViewById(R.id.checkBox7);
        checkBox8=(CheckBox)findViewById(R.id.checkBox8);
        checkBox9=(CheckBox)findViewById(R.id.checkBox9);
        checkBox10=(CheckBox)findViewById(R.id.checkBox10);
        checkBox11=(CheckBox)findViewById(R.id.checkBox11);
        checkBox12=(CheckBox)findViewById(R.id.checkBox12);
        checkBox13=(CheckBox)findViewById(R.id.checkBox13);
        checkBox14=(CheckBox)findViewById(R.id.checkBox14);
        checkBox15=(CheckBox)findViewById(R.id.checkBox15);
        checkBox16=(CheckBox)findViewById(R.id.checkBox16);
        checkBox17=(CheckBox)findViewById(R.id.checkBox17);
        checkBox18=(CheckBox)findViewById(R.id.checkBox18);
        checkBox19=(CheckBox)findViewById(R.id.checkBox19);
        checkBox20=(CheckBox)findViewById(R.id.checkBox20);
        checkBox21=(CheckBox)findViewById(R.id.checkBox21);
        checkBox22=(CheckBox)findViewById(R.id.checkBox22);
        checkBox23=(CheckBox)findViewById(R.id.checkBox23);
        checkBox24=(CheckBox)findViewById(R.id.checkBox24);
        checkBox25=(CheckBox)findViewById(R.id.checkBox25);
        checkBox26=(CheckBox)findViewById(R.id.checkBox26);
        checkBox27=(CheckBox)findViewById(R.id.checkBox27);
        checkBox28=(CheckBox)findViewById(R.id.checkBox28);
        checkBox29=(CheckBox)findViewById(R.id.checkBox29);
        checkBox30=(CheckBox)findViewById(R.id.checkBox30);

        fab=(Button)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int totalamount=0;
                int totaltime=0;
                StringBuilder result=new StringBuilder();
                if(checkBox1.isChecked()){
                    result.append("\n Normal Hair cutting :-Rs 50.00");
                    totalamount+=50;
                    totaltime+=30;
                }
                if(checkBox2.isChecked()){
                    result.append("\n Style Hair Cutting :-RS 80.00");
                    totalamount+=80;
                    totaltime+=30;

                }
                if(checkBox3.isChecked()){
                    result.append("\n Normal Shaving :-RS 50");
                    totalamount+=50;
                    totaltime+=30;

                }
                if(checkBox4.isChecked()){
                    result.append("\n Special Shaving:-RS 50");
                    totalamount+=50;
                    totaltime+=30;
                }
                if(checkBox5.isChecked()){
                    result.append("\n Hair Shampoo:-RS 50");
                    totalamount+=50;
                    totaltime+=30;

                }
                if(checkBox6.isChecked()){
                    result.append("\n Head Massage:-RS 50");
                    totalamount+=50;
                    totaltime+=30;

                }
                if(checkBox7.isChecked()){
                    result.append("\n Trimming:-RS 30");
                    totalamount+=30;
                    totaltime+=10;
                }
                if(checkBox8.isChecked()){
                    result.append("\n Trimming With Lining:-RS 40");
                    totalamount+=40;
                    totaltime+=30;

                }
                if(checkBox9.isChecked()){
                    result.append("\n Loreal Black:-RS 400");
                    totalamount+=400;
                    totaltime+=30;

                }
                if(checkBox10.isChecked()){
                    result.append("\n Loreal Brown:-RS 450");
                    totalamount+=450;
                    totaltime+=30;
                }
                if(checkBox11.isChecked()){
                    result.append("\n Garnier Black:-RS 160");
                    totalamount+=160;
                    totaltime+=30;

                }
                if(checkBox12.isChecked()){
                    result.append("\n Garnier Burgundy RS:-180");
                    totalamount+=180;
                    totaltime+=30;

                }
                if(checkBox13.isChecked()){
                    result.append("\n Garnier Brown:-RS 180");
                    totalamount+=180;
                    totaltime+=30;

                }
                if(checkBox14.isChecked()){
                    result.append("\n Garnier Red:-RS 200");
                    totalamount+=200;
                    totaltime+=30;
                }
                if(checkBox15.isChecked()){
                    result.append("\n Strex Black:-RS 160");
                    totalamount+=160;
                    totaltime+=30;

                }
                if(checkBox16.isChecked()){
                    result.append("\n Strex Burgundy:-RS 120");
                    totalamount+=120;
                    totaltime+=30;

                }
                if(checkBox17.isChecked()){
                    result.append("\n Godrej Black:-RS 120");
                    totalamount+=120;
                    totaltime+=30;
                }
                if(checkBox18.isChecked()){
                    result.append("\n Godrej Brown:-RS 120");
                    totalamount+=120;
                    totaltime+=30;

                }
                if(checkBox19.isChecked()){
                    result.append("\n Hair Mehandi:-RS 150");
                    totalamount+=150;
                    totaltime+=30;

                }
                if(checkBox20.isChecked()){
                    result.append("\n Highlight Colour:-RS 70(per strip)");
                    totalamount+=70;
                    totaltime+=30;
                }

                if(totaltime<60) {
                    result.append("\nTotal Rupees: " + totalamount + "Rs");
                    result.append("\nTotal Time: " + totaltime + "Time");
                }
                else
                {
                    hour=totaltime/60;
                    min=totaltime%60;


                    //Displaying the message on the toast

                    String totalprice= String.valueOf(totalamount);
                    String list= result.toString();
                    String hours= String.valueOf(hour);
                    String mins= String.valueOf(min);

                    Intent intent = new Intent(ServiceListActivity.this,FinalListActivity.class);
                    intent.putExtra("list",list);
                  //  intent.putExtra("hours",hours);
                   // intent.putExtra("mins",mins);
                    intent.putExtra("totalprice",totalprice);
                    intent.putExtra("barbourname",brbrname);

                    startActivity(intent);
                }

            }

        });
    }

}
