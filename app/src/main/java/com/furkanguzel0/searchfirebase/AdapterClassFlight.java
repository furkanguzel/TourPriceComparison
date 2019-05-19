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

import java.text.BreakIterator;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

import static com.furkanguzel0.searchfirebase.MainActivity.totalcost;

public class AdapterClassFlight extends RecyclerView.Adapter<AdapterClassFlight.MyViewHolder> {
    ArrayList<Flights> list1;
    public Context context;

    public String str1;
    public String str2;
    public String str3;

    private MainActivity totalValue = new MainActivity();
    private String FlightName;
    private String FlightDescription;
    private String FlightImg;


    public AdapterClassFlight(ArrayList<Flights> list1)
    {
        this.list1 = list1;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int position) {
        final Flights item = list1.get(position);

        myViewHolder.id.setText(list1.get(position).getFlight_company());
        myViewHolder.desc.setText(list1.get(position).getPrice());
        myViewHolder.id1.setText(list1.get(position).getDeparture_airport());
        myViewHolder.id2.setText(list1.get(position).getArrival_airport());
        myViewHolder.id3.setText(list1.get(position).getDeparture_time());
        myViewHolder.id4.setText(list1.get(position).getArrival_time());

        Picasso.get()
                .load(list1.get(position).getFlight_img())
                .resize(500, 400)
                // .centerCrop()
                .into(myViewHolder.imgUrl);
        myViewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlightDescription = list1.get(position).getPrice();
                str1 = FlightDescription.substring(0,FlightDescription.length() - 3);
                str2 = str1.replace(".","");
                str3 = str2.replace(",",".");
                MainActivity.totalcost +=  Float.parseFloat(str3) ;

            }


        });
        myViewHolder.linkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri linkimiz1 = Uri.parse(list1.get(position).getLink_adress()); //butona vermek istediğimiz linki buraya yazıyoruz.
                Intent intentimiz1 = new Intent(Intent.ACTION_VIEW,linkimiz1);
                context.startActivity(intentimiz1);
            }
        });

    }



    @Override
    public int getItemCount()
    {
        return list1.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,id1,id2,id3,id4,desc;

        ImageView imgUrl;
        Button btn;
        Button linkbutton;

        //Button goToBasket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id = itemView.findViewById(R.id.dealId);
            id1 = itemView.findViewById(R.id.dealId1);
            id2 = itemView.findViewById(R.id.dealId2);
            id3 = itemView.findViewById(R.id.dealId3);
            id4 = itemView.findViewById(R.id.dealId4);
            desc = itemView.findViewById(R.id.description);
            imgUrl = itemView.findViewById(R.id.imageView);
            btn = itemView.findViewById(R.id.basket);
            linkbutton = itemView.findViewById(R.id.goToWebsite);


            //goToBasket = itemView.findViewById(R.id.sepet);
        }
    }
}
