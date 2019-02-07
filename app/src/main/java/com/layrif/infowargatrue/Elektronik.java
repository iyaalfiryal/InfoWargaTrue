
package com.layrif.infowargatrue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.layrif.infowargatrue.adapternya.AdapterElektronik;
import com.layrif.infowargatrue.koneksi.ApiService;
import com.layrif.infowargatrue.koneksi.Server;
import com.layrif.infowargatrue.model.DataElek;
import com.layrif.infowargatrue.model.ResponseElek;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Elektronik extends AppCompatActivity {
    RecyclerView rv;
    private AdapterElektronik adapterElektronik;
    List<DataElek> listelektronik = new ArrayList<>();

    ProgressDialog progressDialog;
    ApiService apiService;

    private final String api_key = "http://192.168.100.240/infowarga/";
    private final String nama_elektronik = "nama_elektronik";
    private final String alamat_elektronik = "alamat_elektronik";
    private final String user_elektronik = "user_elektronik";
    private final String nohp_elektronik = "nohp_elektronik";
    private final String img_elektronik = "img_elektronik";
    private final String waktu_elektronik = "waktu_elektronik";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elektronik);

        rv = findViewById(R.id.rv_elektronik);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapterElektronik);

        apiService = Server.getApiService();
        adapterElektronik = new AdapterElektronik(getApplicationContext(), listelektronik);
        elektronik();
    }

    private void elektronik() {
        progressDialog = ProgressDialog.show(this, null, "tunggu dulu...",
                true, false);
        apiService.getAllElek(api_key, nama_elektronik, alamat_elektronik, user_elektronik, nohp_elektronik, img_elektronik, waktu_elektronik)
                .enqueue(new Callback<ResponseElek>() {
                    @Override
                    public void onResponse(Call<ResponseElek> call, Response<ResponseElek> response) {

                        if (response.isSuccessful()){
                            progressDialog.dismiss();
                            listelektronik = response.body().getData();
                            rv.setAdapter(new AdapterElektronik(getApplicationContext(), listelektronik));
                            adapterElektronik.notifyDataSetChanged();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseElek> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Koneksi gagal", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
