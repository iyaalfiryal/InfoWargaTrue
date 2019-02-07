package com.layrif.infowargatrue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailElektronik extends AppCompatActivity {

    String txtNama, txtAlamat, txtUser, txtNohp, txtImg, txtWaktu;
    TextView tvNama, tvAlamat, tvUser, tvNohp, tvWaktu;
    ImageView imgNya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_elektronik);


        imgNya = findViewById(R.id.img_elektronik);
        tvNama = findViewById(R.id.nama_elektronik);
        tvAlamat = findViewById(R.id.alamat_elektronik);
        tvUser = findViewById(R.id.user_elektronik);
        tvNohp = findViewById(R.id.nohp_elektronik);
        tvWaktu = findViewById(R.id.waktu_elektronik);

        txtNama = getIntent().getStringExtra("nama_elektronik");
        txtAlamat = getIntent().getStringExtra("alamat_elektronik");
        txtUser = getIntent().getStringExtra("user_elektronik");
        txtNohp = getIntent().getStringExtra("nohp_elektronik");
        txtImg = getIntent().getStringExtra("img_elektronik");
        txtWaktu = getIntent().getStringExtra("waktu_elektronik");

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
