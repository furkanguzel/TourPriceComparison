package com.furkanguzel0.searchfirebase;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity{
    //Hotel
    DatabaseReference ref;
    ArrayList<Hotels> list;

    RecyclerView recyclerView;
    RecyclerView recyclerViewFlight;

    Button btn;
    EditText editText;
    TextView tw1;
    private String TAG = "MainActivity";
    private String TAG1 = "MainActivity";

    private TextView mDisplayDate;
    private TextView mDisplayDate1;

    private TextView Text;
    private TextView Text1;
    Button tab1,tab2,tab3;

    public DatePickerDialog.OnDateSetListener from_date;
    public DatePickerDialog.OnDateSetListener to_date;
    //FLİGHT
    DatabaseReference ref1;
    ArrayList<Flights> list1;

    RecyclerView recyclerView1;
    Button btnFlight;
    EditText editText1,editText2;
    TextView tw2;
    private String TAG2 = "MainActivity";
    private String TAG3 = "MainActivity";

    private TextView mDisplayDate2;
    private TextView mDisplayDate3;

    private TextView Text2;
    private TextView Text3;

    public DatePickerDialog.OnDateSetListener from_date1;
    public DatePickerDialog.OnDateSetListener to_date1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(MainActivity.this);

        ref = FirebaseDatabase.getInstance().getReference().child("hotels");
        ref1 = FirebaseDatabase.getInstance().getReference().child("flights");

        //hotel
        btn = findViewById(R.id.button1);
        recyclerView = findViewById(R.id.recyclerview);
        editText = findViewById(R.id.edt);
        mDisplayDate = findViewById(R.id.tvDate);
        mDisplayDate1 = findViewById(R.id.tvDate1);
        Text = findViewById(R.id.tvDate);
        Text1 = findViewById(R.id.tvDate1);
        //flight
        btnFlight = findViewById(R.id.button2);
        recyclerViewFlight = findViewById(R.id.recyclerview1);
        editText1 = findViewById(R.id.edt1);
        editText2 = findViewById(R.id.edt2);
        mDisplayDate2 = findViewById(R.id.tvDate2);
        mDisplayDate3 = findViewById(R.id.tvDate3);

        Text2 = findViewById(R.id.tvDate2);
        Text3 = findViewById(R.id.tvDate3);

        tab1 = findViewById(R.id.tab1button);
        tab2 = findViewById(R.id.tab2button);
        tab3 = findViewById(R.id.tab3button);

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.tab1layout).setVisibility(View.VISIBLE);
                findViewById(R.id.tab2layout).setVisibility(View.GONE);
                findViewById(R.id.tab3layout).setVisibility(View.GONE);

                tab1.setAlpha(1F);
                tab2.setAlpha(0.4F);
                tab3.setAlpha(0.4F);
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.tab1layout).setVisibility(View.GONE);
                findViewById(R.id.tab2layout).setVisibility(View.VISIBLE);
                findViewById(R.id.tab3layout).setVisibility(View.GONE);

                tab1.setAlpha(0.4F);
                tab2.setAlpha(1F);
                tab3.setAlpha(0.4F);
            }
        });
        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.tab1layout).setVisibility(View.GONE);
                findViewById(R.id.tab2layout).setVisibility(View.GONE);
                findViewById(R.id.tab3layout).setVisibility(View.VISIBLE);

                tab1.setAlpha(0.4F);
                tab2.setAlpha(0.4F);
                tab3.setAlpha(1F);
            }
        });


        tab1.performClick();


        //hotel takvim
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog_MinWidth,
                        from_date, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        from_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month + 1;

                String mt, dy;   //local variable
                if (month < 10)
                    mt = "0" + month; //if month less than 10 then ad 0 before month
                else mt = String.valueOf(month);

                if (dayOfMonth < 10)
                    dy = "0" + dayOfMonth;
                else dy = String.valueOf(dayOfMonth);
                String date1 = year + "-" + mt + "-" + dy;
                mDisplayDate.setText(date1);

            }
        };
        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        to_date, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        to_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;

                String mt, dy;   //local variable
                if (month < 10)
                    mt = "0" + month; //if month less than 10 then ad 0 before month
                else mt = String.valueOf(month);

                if (dayOfMonth < 10)
                    dy = "0" + dayOfMonth;
                else dy = String.valueOf(dayOfMonth);
                String date2 = year + "-" + mt + "-" + dy;
                mDisplayDate1.setText(date2);


            }
        };
        //flight takvim
        mDisplayDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog_MinWidth,
                        from_date1, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        from_date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month + 1;

                String mt, dy;   //local variable
                if (month < 10)
                    mt = "0" + month; //if month less than 10 then ad 0 before month
                else mt = String.valueOf(month);

                if (dayOfMonth < 10)
                    dy = "0" + dayOfMonth;
                else dy = String.valueOf(dayOfMonth);
                String date1 = year + "-" + mt + "-" + dy;
                mDisplayDate2.setText(date1);

            }
        };
        mDisplayDate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        to_date1, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        to_date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;

                String mt, dy;   //local variable
                if (month < 10)
                    mt = "0" + month; //if month less than 10 then ad 0 before month
                else mt = String.valueOf(month);

                if (dayOfMonth < 10)
                    dy = "0" + dayOfMonth;
                else dy = String.valueOf(dayOfMonth);
                String date2 = year + "-" + mt + "-" + dy;
                mDisplayDate3.setText(date2);


            }
        };



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            //button bilgisi gerekebilir
                method();

            }
        });
        btnFlight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //button bilgisi gerekebilir
                method1();

            }
        });
    }


    public void method1 () {//bu uçak için


        if (ref1 != null) {


            Query query1 = ref1.orderByChild("price");
            query1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String s1 = editText1.getText().toString();
                    String s2 = editText2.getText().toString();

                    String s3 = Text2.getText().toString();
                    String s4 = Text3.getText().toString();
                    list1 = new ArrayList<>();

                    if (dataSnapshot.exists()) {
                        Flights local = new Flights();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list1.add(ds.getValue(Flights.class));
                        }
                        ArrayList<Flights> myList1 = new ArrayList<>();
                        for (Flights object : list1) {
                            if (object.getDeparture_city().toLowerCase().contains(s1.toLowerCase()) && object.getArrival_city().toLowerCase().contains(s2.toLowerCase())) {
                                String value = object.getCheckInDate();
                                String value1 = object.getCheckOutDate();

                                if (value.compareTo(s3) > 0 || value.compareTo(s3) == 0) //value >= date
                                    if (value1.compareTo(s4) < 0 || value1.compareTo(s4) == 0)// value1 <= date1
                                        myList1.add(object);
                            }
                        }

                        AdapterClassFlight adapterClass1 = new AdapterClassFlight(myList1);
                        recyclerViewFlight.removeAllViewsInLayout();
                        recyclerViewFlight.setAdapter(adapterClass1);

                        //deneme commit asas
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
    public void method () {//bu hotel için


        if (ref != null) {


            Query query = ref.orderByChild("price");
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String s1 = editText.getText().toString();
                    String s2 = Text.getText().toString();
                    String s3 = Text1.getText().toString();
                    list = new ArrayList<>();


                    if (dataSnapshot.exists()) {
                        Hotels local = new Hotels();
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            list.add(ds.getValue(Hotels.class));
                        }
                        ArrayList<Hotels> myList = new ArrayList<>();
                        for (Hotels object : list) {
                            if (object.getHotel_location().toLowerCase().contains(s1.toLowerCase())) {
                                String value = object.getCheckInDate();
                                String value1 = object.getCheckOutDate();

                                if (value.compareTo(s2) > 0 || value.compareTo(s2) == 0) //value >= date
                                    if (value1.compareTo(s3) < 0 || value1.compareTo(s3) == 0)// value1 <= date1
                                        myList.add(object);
                            }
                        }

                        AdapterClass adapterClass = new AdapterClass(myList);
                        recyclerView.setAdapter(adapterClass);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

