package com.layrif.infowargatrue.adapternya;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.layrif.infowargatrue.DetailElektronik;
import com.layrif.infowargatrue.R;
import com.layrif.infowargatrue.model.DataElek;

import java.util.List;

public class AdapterElektronik extends RecyclerView.Adapter<AdapterElektronik.ViewHolder>{
    private Context context;
    private List<DataElek> listElektronik;

    //construktor
    public AdapterElektronik(Context context, List<DataElek> listElektronik) {
        this.context = context;
        this.listElektronik = listElektronik;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int view) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_elektronik, null,
                        false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView
                .LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup
                .LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        final DataElek dataElektronik = listElektronik.get(i);
        Glide.with(context).load("http://192.168.100.240/infowarga/aa/"+dataElektronik.getImgElek())
                .apply(new RequestOptions().placeholder(R.mipmap.defaultnya))
                .into(holder.img);
        holder.nm.setText(dataElektronik.getNamaElek());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailElektronik.class );
                i.putExtra("nama_elektronik", dataElektronik.getNamaElek());
                i.putExtra("alamat_elektronik", dataElektronik.getAlamatElek());
                i.putExtra("user_elektronik", dataElektronik.getUserElek());
                i.putExtra("nohp_elektronik", dataElektronik.getNohpElek());
                i.putExtra("img_elektronik", dataElektronik.getImgElek());
                i.putExtra("waktu_elektronik", dataElektronik.getWaktuElek());
                //addflags = nambah tugas baru.
                //agar segera di execute, biar datanya cepet keluar.
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listElektronik.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView img;
        private TextView nm, user, alamat, nohp, waktu;

        public ViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.cv_elektronik);
            img = view.findViewById(R.id.img_elektronik);
            nm = view.findViewById(R.id.nama_elektronik);
            user = view.findViewById(R.id.user_elektronik);
            alamat = view.findViewById(R.id.alamat_elektronik);
            nohp = view.findViewById(R.id.nohp_elektronik);
            waktu = view.findViewById(R.id.waktu_elektronik);

        }
    }
}
