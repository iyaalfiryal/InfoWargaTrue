
package com.layrif.infowargatrue;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.layrif.infowargatrue.adapternya.AdapterMinuman;
import com.layrif.infowargatrue.koneksi.ApiService;
import com.layrif.infowargatrue.koneksi.Server;
import com.layrif.infowargatrue.model.DataMinuman;
import com.layrif.infowargatrue.model.ResponseMinuman;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Minuman extends AppCompatActivity {
    RecyclerView rv;
    private AdapterMinuman adapterMinuman;
    List<DataMinuman> listminuman = new ArrayList<>();

    ProgressDialog progressDialog;
    ApiService apiService;

    private final String api_key = "http://192.168.100.240/infowarga/";
    private final String nama_minuman = "nama_minuman";
    private final String alamat_minuman = "alamat_minuman";
    private final String user_minuman = "user_minuman";
    private final String nohp_minuman = "nohp_minuman";
    private final String img_minuman = "img_minuman";
    private final String waktu_minuman = "waktu_minuman";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);

        rv = findViewById(R.id.rv_minuman);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapterMinuman);

        apiService = Server.getApiService();
        adapterMinuman = new AdapterMinuman(getApplicationContext(), listminuman);
        minuman();
    }

    private void minuman() {
        progressDialog = ProgressDialog.show(this, null, "tunggu dulu...",
                true, false);
        apiService.getAllMinuman(api_key, nama_minuman, alamat_minuman, user_minuman, nohp_minuman, img_minuman, waktu_minuman)
                .enqueue(new Callback<ResponseMinuman>() {
                    @Override
                    public void onResponse(Call<ResponseMinuman> call, Response<ResponseMinuman> response) {

                        if (response.isSuccessful()){
                            progressDialog.dismiss();
                            listminuman = response.body().getData();
                            rv.setAdapter(new AdapterMinuman(getApplicationContext(), listminuman));
                            adapterMinuman.notifyDataSetChanged();
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMinuman> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Koneksi gagal", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
