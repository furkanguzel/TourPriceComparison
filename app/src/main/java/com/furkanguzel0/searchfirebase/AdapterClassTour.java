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

public class AdapterClassTour extends RecyclerView.Adapter<AdapterClassTour.MyViewHolder>  {
    ArrayList<Tours> list2;
    public Context context;
    public String str;
    private String str1,str2,str3;
    public String f;
    public String s;
    private String TourDescription;
    private String link;



    public AdapterClassTour(ArrayList<Tours> list2)
    {
        this.list2 = list2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {
        final Tours item = list2.get(position);

        myViewHolder.id.setText(list2.get(position).getTour_name());
        myViewHolder.desc.setText(list2.get(position).getPrice());

        Picasso.get()
                .load(list2.get(position).getTour_img())
                .resize(500, 400)
                // .centerCrop()
                .into(myViewHolder.imgUrl);
        myViewHolder.btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TourDescription = list2.get(position).getPrice();
                str1 = TourDescription.substring(0,TourDescription.length() - 3);
                str2 = str1.replace(".","");
                str3 = str2.replace(",",".");
                MainActivity.totalcost +=  Float.parseFloat(str3);

            }
        });

        myViewHolder.linkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri linkimiz2=Uri.parse(list2.get(position).getLink_adress()); //butona vermek istediğimiz linki buraya yazıyoruz.
                Intent intentimiz2 =new Intent(Intent.ACTION_VIEW,linkimiz2);
                context.startActivity(intentimiz2);
            }
        });
    }



    @Override
    public int getItemCount()
    {
        return list2.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,desc;
        ImageView imgUrl;
        Button btn;
        Button linkbutton;
        //Button goToBasket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id = itemView.findViewById(R.id.dealId);
            desc = itemView.findViewById(R.id.description);
            imgUrl = itemView.findViewById(R.id.imageView);
            btn = itemView.findViewById(R.id.basket);
            linkbutton = itemView.findViewById(R.id.goToWebsite);
            //goToBasket = itemView.findViewById(R.id.sepet);


        }
    }
}

