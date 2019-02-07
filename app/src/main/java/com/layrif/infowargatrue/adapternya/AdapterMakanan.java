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
import com.layrif.infowargatrue.DetailMakanan;
import com.layrif.infowargatrue.R;
import com.layrif.infowargatrue.model.DataMakanan;

import java.util.List;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.ViewHolder>{
    private Context context;
    private List<DataMakanan> listMakanan;

    //construktor
    public AdapterMakanan(Context context, List<DataMakanan> listMakanan) {
        this.context = context;
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int view) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_makanan, null,
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
        final DataMakanan dataMakanan = listMakanan.get(i);
        Glide.with(context).load("http://192.168.100.240/infowarga/aa/"+dataMakanan.getImgMakanan())
                .apply(new RequestOptions().placeholder(R.mipmap.defaultnya))
                .into(holder.img);
        holder.nm.setText(dataMakanan.getNamaMakanan());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailMakanan.class );
                i.putExtra("nama_makanan", dataMakanan.getNamaMakanan());
                i.putExtra("alamat_makanan", dataMakanan.getAlamatMakanan());
                i.putExtra("user_makanan", dataMakanan.getUserMakanan());
                i.putExtra("nohp_makanan", dataMakanan.getNohpMakanan());
                i.putExtra("img_makanan", dataMakanan.getImgMakanan());
                i.putExtra("waktu_makanan", dataMakanan.getWaktuMakanan());
                //addflags = nambah tugas baru.
                //agar segera di execute, biar datanya cepet keluar.
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView img;
        private TextView nm, user, alamat, nohp, waktu;

        public ViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.cv_makanan);
            img = view.findViewById(R.id.img_makanan);
            nm = view.findViewById(R.id.nama_makanan);
            user = view.findViewById(R.id.user_makanan);
            alamat = view.findViewById(R.id.alamat_makanan);
            nohp = view.findViewById(R.id.nohp_makanan);
            waktu = view.findViewById(R.id.waktu_makanan);

        }
    }
}
