package com.example.lathaibinh.bookhotel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lathaibinh.bookhotel.R;
import com.example.lathaibinh.bookhotel.model.DataRoom;
import com.example.lathaibinh.bookhotel.view.activity.BookActivity;
import com.example.lathaibinh.bookhotel.view.activity.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {
    ArrayList<DataRoom> roomAdapters;
    Context context;
    private final static int FADE_DURATION = 1000;

    public RoomAdapter(ArrayList<DataRoom> roomAdapters, Context context) {
        this.roomAdapters = roomAdapters;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_room,parent,false);
        return new RoomAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder holder, final int position) {
        final DataRoom item = roomAdapters.get(position);
        Picasso.get()
                .load(item.getHinhAnh())
                .centerCrop()
                .fit()
                .into(holder.image);

        holder.txtTenPhong.setText(item.getTenPhong());
        holder.txtChiTietPhong.setText(item.getThongTinPhong());
        holder.txtGia.setText(item.getGia());
        setFadeAnimation(holder.itemView);
        holder.btnBookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BookActivity.class);
                intent.putExtra(DetailActivity.class.getName(), item.getTenPhong());
                context.startActivity(intent);
            }
        });

    }
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
    @Override
    public int getItemCount() {
        return roomAdapters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTenPhong;
        TextView txtChiTietPhong;
        TextView txtGia;
        ImageView image;
        LinearLayout item;
        Button btnBookRoom;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTenPhong = (TextView)itemView.findViewById(R.id.textViewTenPhong);
            txtChiTietPhong = (TextView)itemView.findViewById(R.id.textViewChiTietPhong);
            txtGia=(TextView)itemView.findViewById(R.id.textViewPriceRoom);
            image = (ImageView)itemView.findViewById(R.id.imageRoom);
            item = (LinearLayout)itemView.findViewById(R.id.linearlayout_itemroom);
            btnBookRoom = (Button)itemView.findViewById(R.id.buttonBookRoom);
        }
    }
}
