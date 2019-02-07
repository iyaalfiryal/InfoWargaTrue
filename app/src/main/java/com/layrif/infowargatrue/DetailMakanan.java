package com.layrif.infowargatrue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMakanan extends AppCompatActivity {

    String txtNama, txtAlamat, txtUser, txtNohp, txtImg, txtWaktu;
    TextView tvNama, tvAlamat, tvUser, tvNohp, tvWaktu;
    ImageView imgNya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);


        imgNya = findViewById(R.id.img_makanan);
        tvNama = findViewById(R.id.nama_makanan);
        tvAlamat = findViewById(R.id.alamat_makanan);
        tvUser = findViewById(R.id.user_makanan);
        tvNohp = findViewById(R.id.nohp_makanan);
        tvWaktu = findViewById(R.id.waktu_makanan);

        txtNama = getIntent().getStringExtra("nama_makanan");
        txtAlamat = getIntent().getStringExtra("alamat_makanan");
        txtUser = getIntent().getStringExtra("user_makanan");
        txtNohp = getIntent().getStringExtra("nohp_makanan");
        txtImg = getIntent().getStringExtra("img_makanan");
        txtWaktu = getIntent().getStringExtra("waktu_makanan");

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
