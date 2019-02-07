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
import com.layrif.infowargatrue.DetailBangunan;
import com.layrif.infowargatrue.R;
import com.layrif.infowargatrue.model.DataBangunan;

import java.util.List;

public class AdapterBangunan extends RecyclerView.Adapter<AdapterBangunan.ViewHolder>{
    private Context context;
    private List<DataBangunan> listBangunan;

    //construktor
    public AdapterBangunan(Context context, List<DataBangunan> listBangunan) {
        this.context = context;
        this.listBangunan = listBangunan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int view) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_bangunan, null,
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
        final DataBangunan dataBangunan = listBangunan.get(i);
        Glide.with(context).load("http://192.168.100.240/infowarga/aa/"+dataBangunan.getImgBangunan())
                .apply(new RequestOptions().placeholder(R.mipmap.defaultnya))
                .into(holder.img);
        holder.nm.setText(dataBangunan.getNamaBangunan());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailBangunan.class );
                i.putExtra("nama_bangunan", dataBangunan.getNamaBangunan());
                i.putExtra("alamat_bangunan", dataBangunan.getAlamatBangunan());
                i.putExtra("user_bangunan", dataBangunan.getUserBangunan());
                i.putExtra("nohp_bangunan", dataBangunan.getNohpBangunan());
                i.putExtra("img_bangunan", dataBangunan.getImgBangunan());
                i.putExtra("waktu_bangunan", dataBangunan.getWaktuBangunan());
                //addflags = nambah tugas baru.
                //agar segera di execute, biar datanya cepet keluar.
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBangunan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cv;
        private ImageView img;
        private TextView nm, user, alamat, nohp, waktu;

        public ViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.cv_bangunan);
            img = view.findViewById(R.id.img_bangunan);
            nm = view.findViewById(R.id.nama_bangunan);
            user = view.findViewById(R.id.user_bangunan);
            alamat = view.findViewById(R.id.alamat_bangunan);
            nohp = view.findViewById(R.id.nohp_bangunan);
            waktu = view.findViewById(R.id.waktu_bangunan);

        }
    }
}
