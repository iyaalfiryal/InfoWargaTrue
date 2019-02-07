package com.layrif.infowargatrue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailBangunan extends AppCompatActivity {

    String txtNama, txtAlamat, txtUser, txtNohp, txtImg, txtWaktu;
    TextView tvNama, tvAlamat, tvUser, tvNohp, tvWaktu;
    ImageView imgNya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bangunan);


        imgNya = findViewById(R.id.img_bangunan);
        tvNama = findViewById(R.id.nama_bangunan);
        tvAlamat = findViewById(R.id.alamat_bangunan);
        tvUser = findViewById(R.id.user_bangunan);
        tvNohp = findViewById(R.id.nohp_bangunan);
        tvWaktu = findViewById(R.id.waktu_bangunan);

        txtNama = getIntent().getStringExtra("nama_bangunan");
        txtAlamat = getIntent().getStringExtra("alamat_bangunan");
        txtUser = getIntent().getStringExtra("user_bangunan");
        txtNohp = getIntent().getStringExtra("nohp_bangunan");
        txtImg = getIntent().getStringExtra("img_bangunan");
        txtWaktu = getIntent().getStringExtra("waktu_bangunan");

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
