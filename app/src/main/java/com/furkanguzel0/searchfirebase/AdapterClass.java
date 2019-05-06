package com.furkanguzel0.searchfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder>  {
    ArrayList<Hotels> list;
    public Context context;
    public String str;
    public String str1;
    public String f;
    public String s;

    public  Float totalcost;


    public AdapterClass(ArrayList<Hotels> list)
    {
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {
        final Hotels item = list.get(position);

        myViewHolder.id.setText(list.get(position).getHotel_name());
        myViewHolder.desc.setText(list.get(position).getPrice());

        Picasso.get()
                .load(list.get(position).getHotel_img())
                .resize(500, 400)
                // .centerCrop()
                .into(myViewHolder.imgUrl);


    }




    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,desc;
        ImageView imgUrl;
        //Button btn;
        //Button goToBasket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id = itemView.findViewById(R.id.dealId);
            desc = itemView.findViewById(R.id.description);
            imgUrl = itemView.findViewById(R.id.imageView);
           // btn = itemView.findViewById(R.id.basket);
            //goToBasket = itemView.findViewById(R.id.sepet);


        }
    }
}