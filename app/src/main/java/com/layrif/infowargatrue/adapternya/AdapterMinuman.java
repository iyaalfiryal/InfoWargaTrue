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
import com.layrif.infowargatrue.DetailMinuman;
import com.layrif.infowargatrue.R;
import com.layrif.infowargatrue.model.DataMinuman;

import java.util.List;

public class AdapterMinuman extends RecyclerView.Adapter<AdapterMinuman.ViewHolder>{
    private Context context;
    private List<DataMinuman> listMinuman;

    //construktor
    public AdapterMinuman(Context context, List<DataMinuman> listMinuman) {
        this.context = context;
        this.listMinuman = listMinuman;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int view) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_minuman, null,
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
        final DataMinuman dataMinuman = listMinuman.get(i);
        Glide.with(context).load("http://192.168.100.240/infowarga/aa/"+dataMinuman.getImgMinuman())
                .apply(new RequestOptions().placeholder(R.mipmap.defaultnya))
                .into(holder.img);
        holder.nm.setText(dataMinuman.getNamaMinuman());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailMinuman.class );
                i.putExtra("nama_minuman", dataMinuman.getNamaMinuman());
                i.putExtra("alamat_minuman", dataMinuman.getAlamatMinuman());
                i.putExtra("user_minuman", dataMinuman.getUserMinuman());
                i.putExtra("nohp_minuman", dataMinuman.getNohpMinuman());
                i.putExtra("img_minuman", dataMinuman.getImgMinuman());
                i.putExtra("waktu_minuman", dataMinuman.getWaktuMinuman());
                //addflags = nambah tugas baru.
                //agar segera di execute, biar datanya cepet keluar.
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMinuman.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView img;
        private TextView nm, user, alamat, nohp, waktu;

        public ViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.cv_minuman);
            img = view.findViewById(R.id.img_minuman);
            nm = view.findViewById(R.id.nama_minuman);
            user = view.findViewById(R.id.user_minuman);
            alamat = view.findViewById(R.id.alamat_minuman);
            nohp = view.findViewById(R.id.nohp_minuman);
            waktu = view.findViewById(R.id.waktu_minuman);

        }
    }
}
