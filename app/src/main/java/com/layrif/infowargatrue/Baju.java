
package com.layrif.infowargatrue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.layrif.infowargatrue.adapternya.AdapterBaju;
import com.layrif.infowargatrue.koneksi.ApiService;
import com.layrif.infowargatrue.koneksi.Server;
import com.layrif.infowargatrue.model.DataBaju;
import com.layrif.infowargatrue.model.ResponseBaju;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Baju extends AppCompatActivity {
    RecyclerView rv;
    private AdapterBaju adapterBaju;
    List<DataBaju> listbaju = new ArrayList<>();

    ProgressDialog progressDialog;
    ApiService apiService;

    private final String api_key = "http://192.168.100.240/infowarga/";
    private final String nama_baju = "nama_baju";
    private final String alamat_baju = "alamat_baju";
    private final String user_baju = "user_baju";
    private final String nohp_baju = "nohp_baju";
    private final String img_baju = "img_baju";
    private final String waktu_baju = "waktu_baju";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baju);

        rv = findViewById(R.id.rv_baju);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapterBaju);

        apiService = Server.getApiService();
        adapterBaju = new AdapterBaju(getApplicationContext(), listbaju);
        baju();
    }

    private void baju() {
        progressDialog = ProgressDialog.show(this, null, "tunggu dulu...",
                true, false);
        apiService.getAllBaju(api_key, nama_baju, alamat_baju, user_baju, nohp_baju, img_baju, waktu_baju)
                .enqueue(new Callback<ResponseBaju>() {
                    @Override
                    public void onResponse(Call<ResponseBaju> call, Response<ResponseBaju> response) {

                        if (response.isSuccessful()){
                            progressDialog.dismiss();
                            listbaju = response.body().getData();
                            rv.setAdapter(new AdapterBaju(getApplicationContext(), listbaju));
                            adapterBaju.notifyDataSetChanged();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBaju> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Koneksi gagal", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
