
package com.layrif.infowargatrue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.layrif.infowargatrue.adapternya.AdapterMakanan;
import com.layrif.infowargatrue.koneksi.ApiService;
import com.layrif.infowargatrue.koneksi.Server;
import com.layrif.infowargatrue.model.DataMakanan;
import com.layrif.infowargatrue.model.ResponseMakanan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Makanan extends AppCompatActivity {
    RecyclerView rv;
    private AdapterMakanan adapterMakanan;
    List<DataMakanan> listmakanan = new ArrayList<>();

    ProgressDialog progressDialog;
    ApiService apiService;

    private final String api_key = "http://192.168.100.240/infowarga/";
    private final String nama_makanan = "nama_makanan";
    private final String alamat_makanan = "alamat_makanan";
    private final String user_makanan = "user_makanan";
    private final String nohp_makanan = "nohp_makanan";
    private final String img_makanan = "img_makanan";
    private final String waktu_makanan = "waktu_makanan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        rv = findViewById(R.id.rv_makanan);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapterMakanan);

        apiService = Server.getApiService();
        adapterMakanan = new AdapterMakanan(getApplicationContext(), listmakanan);
        makanan();
    }

    private void makanan() {
        progressDialog = ProgressDialog.show(this, null, "tunggu dulu...",
                true, false);
        apiService.getAllMakanan(api_key, nama_makanan, alamat_makanan, user_makanan, nohp_makanan, img_makanan, waktu_makanan)
                .enqueue(new Callback<ResponseMakanan>() {
                    @Override
                    public void onResponse(Call<ResponseMakanan> call, Response<ResponseMakanan> response) {

                        if (response.isSuccessful()){
                            progressDialog.dismiss();
                            listmakanan = response.body().getData();
                            rv.setAdapter(new AdapterMakanan(getApplicationContext(), listmakanan));
                            adapterMakanan.notifyDataSetChanged();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMakanan> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Koneksi gagal", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
