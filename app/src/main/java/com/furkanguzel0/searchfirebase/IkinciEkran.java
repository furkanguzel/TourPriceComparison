package com.furkanguzel0.searchfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class IkinciEkran extends Activity {
    TextView SecondText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikinci);

        TextView SecondText = findViewById(R.id.textViewSecond);

        //Intent intent = getIntent();
        //String money = intent.getStringExtra("price");
        //SecondText.setText(money);

    }
}
