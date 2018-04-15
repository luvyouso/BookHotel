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
import com.example.lathaibinh.bookhotel.model.DataShop;
import com.example.lathaibinh.bookhotel.view.activity.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{
    ArrayList<DataShop> dataShops;
    Context context;
    private final static int FADE_DURATION = 1000;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final DataShop item = dataShops.get(position);
        Picasso.get()
                .load(item.getHinhAnh())
                .centerCrop()
                .fit()
                .into(holder.image);

        holder.txtTitle.setText(item.getTitle());
        holder.txtDiaChi.setText("Địa Chỉ : "+item.getDiaChi());
        holder.txtGia.setText("Giá :"+item.getGia());
        setFadeAnimation(holder.itemView);
        holder.btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable(DetailActivity.class.getName(), item);
//                intent.putExtra(DetailActivity.class.getName(), bundle);
                intent.putExtra(DetailActivity.class.getName(), item.getTitle());
                context.startActivity(intent);
//                Bundle bundle = new Bundle();
//                bundle.putString("key","Jhon Doe"); // set your parameteres
//
//                HistoryFragment nextFragment = new HistoryFragment();
//                nextFragment.setArguments(bundle);
//
//                FragmentManager fragmentManager = DetailActivity.class.getName().getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.recycleView1, nextFragment).commit();
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
        return dataShops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtDiaChi;
        TextView txtGia;
        ImageView image;
        LinearLayout item;
        Button btnChoose;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView)itemView.findViewById(R.id.textViewTitle);
            txtDiaChi = (TextView)itemView.findViewById(R.id.textViewAddress);
            txtGia=(TextView)itemView.findViewById(R.id.textViewPrice);
            image = (ImageView)itemView.findViewById(R.id.imgHinh);
            item = (LinearLayout)itemView.findViewById(R.id.linearlayout_item);
            btnChoose = (Button)itemView.findViewById(R.id.buttonBook);
        }
    }
}
