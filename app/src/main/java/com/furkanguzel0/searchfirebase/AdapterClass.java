package com.furkanguzel0.searchfirebase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder>  {
    ArrayList<Hotels> list;
    private Context context;

    private String HotelName;
    private String HotelDescription;
    private String hotelImg;

    private String str1,str2,str3;


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

        myViewHolder.id1.setText(list.get(position).getHotel_name());
        myViewHolder.desc1.setText(list.get(position).getPrice());

        Picasso.get()
                .load(list.get(position).getHotel_img())
                .resize(500, 400)
                // .centerCrop()
                .into(myViewHolder.imgUrl1);
        myViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelDescription = list.get(position).getPrice();
                str1 = HotelDescription.substring(0,HotelDescription.length() - 3);
                str2 = str1.replace(".","");
                str3 = str2.replace(",",".");
                MainActivity.totalcost +=  Float.parseFloat(str3) * 7;
            }
        });
        myViewHolder.linkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri linkimiz1 = Uri.parse(list.get(position).getLink_adress()); //butona vermek istediğimiz linki buraya yazıyoruz.
                Intent intentimiz1 = new Intent(Intent.ACTION_VIEW,linkimiz1);
                context.startActivity(intentimiz1);
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id1,desc1;
        ImageView imgUrl1;
        Button btn;
        Button linkbutton;

        //Button goToBasket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id1 = itemView.findViewById(R.id.dealId);
            desc1 = itemView.findViewById(R.id.description);
            imgUrl1 = itemView.findViewById(R.id.imageView);
            btn = itemView.findViewById(R.id.basket);
            linkbutton = itemView.findViewById(R.id.goToWebsite);

            //goToBasket = itemView.findViewById(R.id.sepet);


        }
    }
}
