package com.layrif.infowargatrue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMinuman extends AppCompatActivity {

    String txtNama, txtAlamat, txtUser, txtNohp, txtImg, txtWaktu;
    TextView tvNama, tvAlamat, tvUser, tvNohp, tvWaktu;
    ImageView imgNya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_minuman);


        imgNya = findViewById(R.id.img_minuman);
        tvNama = findViewById(R.id.nama_minuman);
        tvAlamat = findViewById(R.id.alamat_minuman);
        tvUser = findViewById(R.id.user_minuman);
        tvNohp = findViewById(R.id.nohp_minuman);
        tvWaktu = findViewById(R.id.waktu_minuman);

        txtNama = getIntent().getStringExtra("nama_minuman");
        txtAlamat = getIntent().getStringExtra("alamat_minuman");
        txtUser = getIntent().getStringExtra("user_minuman");
        txtNohp = getIntent().getStringExtra("nohp_minuman");
        txtImg = getIntent().getStringExtra("img_minuman");
        txtWaktu = getIntent().getStringExtra("waktu_minuman");

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
