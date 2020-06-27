package com.example.neutronxstudios.tea_winding;

/**
 * Created by HP on 30-12-2018.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<BookingDetails> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<BookingDetails> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookingDetails UploadInfo = MainImageUploadInfoList.get(position);

        holder.salon1.setText("Salon : "+UploadInfo.getSalon_name());
       holder.amount1.setText(" Amount: "+UploadInfo.getAmount());
       holder.status1.setText("Status : "+UploadInfo.getStatus());
        holder.date1.setText(UploadInfo.getDdate());
        holder.time1.setText(("Time:"+UploadInfo.getBooking_time()));
        holder.list1.setText("List:"+UploadInfo.getDiscription());
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder   {

        public ImageView imageView;
        public TextView salon1,status1,date1,time1,amount1,list1;
        final Context contextt = itemView.getContext();
        public ViewHolder(View itemView) {
            super(itemView);

            time1=(TextView)itemView.findViewById(R.id.time);

            list1=(TextView)itemView.findViewById(R.id.list1);
          salon1=(TextView) itemView.findViewById(R.id.sname1);
            amount1=(TextView) itemView.findViewById(R.id.amount1);
            status1=(TextView) itemView.findViewById(R.id.status1);
            date1=(TextView) itemView.findViewById(R.id.datte1);

          //  imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);


           // itemView.setOnClickListener(this);
        }


    }
}
