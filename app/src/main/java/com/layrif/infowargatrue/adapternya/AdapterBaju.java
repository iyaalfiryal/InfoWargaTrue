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
import com.layrif.infowargatrue.DetailBaju;
import com.layrif.infowargatrue.R;
import com.layrif.infowargatrue.model.DataBaju;

import java.util.List;

public class AdapterBaju extends RecyclerView.Adapter<AdapterBaju.ViewHolder>{
    private Context context;
    private List<DataBaju> listBaju;

    //construktor
    public AdapterBaju(Context context, List<DataBaju> listBaju) {
        this.context = context;
        this.listBaju = listBaju;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int view) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_baju, null,
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
        final DataBaju dataBaju = listBaju.get(i);
        Glide.with(context).load("http://192.168.100.240/infowarga/aa/"+dataBaju.getImgBaju())
                .apply(new RequestOptions().placeholder(R.mipmap.defaultnya))
                .into(holder.img);
        holder.nm.setText(dataBaju.getNamaBaju());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailBaju.class );
                i.putExtra("nama_baju", dataBaju.getNamaBaju());
                i.putExtra("alamat_baju", dataBaju.getAlamatBaju());
                i.putExtra("user_baju", dataBaju.getUserBaju());
                i.putExtra("nohp_baju", dataBaju.getNohpBaju());
                i.putExtra("img_baju", dataBaju.getImgBaju());
                i.putExtra("waktu_baju", dataBaju.getWaktuBaju());
                //addflags = nambah tugas baru.
                //agar segera di execute, biar datanya cepet keluar.
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBaju.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView img;
        private TextView nm, user, alamat, nohp, waktu;

        public ViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.cv_baju);
            img = view.findViewById(R.id.img_baju);
            nm = view.findViewById(R.id.nama_baju);
            user = view.findViewById(R.id.user_baju);
            alamat = view.findViewById(R.id.alamat_baju);
            nohp = view.findViewById(R.id.nohp_baju);
            waktu = view.findViewById(R.id.waktu_baju);

        }
    }
}
