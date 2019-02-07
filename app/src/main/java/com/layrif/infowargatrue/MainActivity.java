package com.layrif.infowargatrue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout makanan, minuman, bangunan, baju, elek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makanan = findViewById(R.id.makanansatu);
        minuman = findViewById(R.id.minumansatu);
        baju = findViewById(R.id.bajusatu);
        bangunan = findViewById(R.id.bangunansatu);
        elek = findViewById(R.id.eleksatu);

        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Makanan.class);
                startActivity(i);

            }
        });
        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Minuman.class);
                startActivity(i);

            }
        });

        elek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Elektronik.class);
                startActivity(i);

            }
        });
        baju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Baju.class);
                startActivity(i);

            }
        });
        bangunan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Bangunan.class);
                startActivity(i);

            }
        });
    }
}
