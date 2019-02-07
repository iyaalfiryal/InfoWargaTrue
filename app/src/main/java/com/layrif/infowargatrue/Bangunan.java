
package com.layrif.infowargatrue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.layrif.infowargatrue.adapternya.AdapterBangunan;
import com.layrif.infowargatrue.koneksi.ApiService;
import com.layrif.infowargatrue.koneksi.Server;
import com.layrif.infowargatrue.model.DataBangunan;
import com.layrif.infowargatrue.model.ResponseBangunan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bangunan extends AppCompatActivity {
    RecyclerView rv;
    private AdapterBangunan adapterBangunan;
    List<DataBangunan> listbangunan = new ArrayList<>();

    ProgressDialog progressDialog;
    ApiService apiService;

    private final String api_key = "http://192.168.100.240/infowarga/";
    private final String nama_bangunan = "nama_bangunan";
    private final String alamat_bangunan = "alamat_bangunan";
    private final String user_bangunan = "user_bangunan";
    private final String nohp_bangunan = "nohp_bangunan";
    private final String img_bangunan = "img_bangunan";
    private final String waktu_bangunan = "waktu_bangunan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangunan);

        rv = findViewById(R.id.rv_bangunan);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapterBangunan);

        apiService = Server.getApiService();
        adapterBangunan = new AdapterBangunan(getApplicationContext(), listbangunan);
        bangunan();
    }

    private void bangunan() {
        progressDialog = ProgressDialog.show(this, null, "tunggu dulu...",
                true, false);
        apiService.getAllbangunan(api_key, nama_bangunan, alamat_bangunan, user_bangunan, nohp_bangunan, img_bangunan, waktu_bangunan)
                .enqueue(new Callback<ResponseBangunan>() {
                    @Override
                    public void onResponse(Call<ResponseBangunan> call, Response<ResponseBangunan> response) {

                        if (response.isSuccessful()){
                            progressDialog.dismiss();
                            listbangunan = response.body().getData();
                            rv.setAdapter(new AdapterBangunan(getApplicationContext(), listbangunan));
                            adapterBangunan.notifyDataSetChanged();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBangunan> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Koneksi gagal", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
