package com.layrif.infowargatrue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailBaju extends AppCompatActivity {

    String txtNama, txtAlamat, txtUser, txtNohp, txtImg, txtWaktu;
    TextView tvNama, tvAlamat, tvUser, tvNohp, tvWaktu;
    ImageView imgNya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_baju);


        imgNya = findViewById(R.id.img_baju);
        tvNama = findViewById(R.id.nama_baju);
        tvAlamat = findViewById(R.id.alamat_baju);
        tvUser = findViewById(R.id.user_baju);
        tvNohp = findViewById(R.id.nohp_baju);
        tvWaktu = findViewById(R.id.waktu_baju);

        txtNama = getIntent().getStringExtra("nama_baju");
        txtAlamat = getIntent().getStringExtra("alamat_baju");
        txtUser = getIntent().getStringExtra("user_baju");
        txtNohp = getIntent().getStringExtra("nohp_baju");
        txtImg = getIntent().getStringExtra("img_baju");
        txtWaktu = getIntent().getStringExtra("waktu_baju");

        Glide.with(getApplicationContext())
                .load("http://192.168.100.240/infowarga/aa/"+txtImg)
                .apply(new RequestOptions().placeholder(R.mipmap.defaultnya))
                .into(imgNya);

        tvNama.setText(txtNama);
        tvAlamat.setText(txtAlamat);
        tvUser.setText(txtUser);
        tvNohp.setText(txtNohp);
        tvWaktu.setText(txtWaktu);
    }
}
