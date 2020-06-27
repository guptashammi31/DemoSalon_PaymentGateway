package com.example.neutronxstudios.tea_winding;


import java.util.jar.Attributes;

public class BookingDetails {



    public String email;
    public String salon_name;
    public String ddate;
    public String discription;
    public String  amount;
    public String  name;
    public String  number;
    public String  status;
    public String  payment;
public String booking_time;

    public  BookingDetails()
    {

    }
    public BookingDetails( String email1,String salon_name1,String ddate1,String  amount1 ,String discription1 ,String name1,String number1,String status,String payment,String Booking_time) {
        this.email=email1;
        this.salon_name=salon_name1;
        this.ddate=ddate1;
        this.amount=amount1;
        this.discription=discription1;
        this.name=name1;
        this.number=number1;
        this.payment=payment;
       this.status=status;
       this.booking_time=Booking_time;


    }
    public String getEmail() {
        return email;
    }
    public String getSalon_name(){return  salon_name;}
    public String getDdate(){return ddate;}
    public String getAmount(){return  amount;}
    public String getStatus(){ return  status;}
    public String getBooking_time(){return  booking_time;}
  //  public String getPayment(){ return  payment;}
    public String getDiscription(){return  discription;}
   // public String getName(){ return  name;}


}
