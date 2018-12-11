package com.example.gaurav.myapplication;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Object> mList;
    Context mContext;

    public ImageAdapter(ArrayList<Object> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_view, viewGroup, false);
            return new MyHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.ads_item_view, viewGroup, false);
            return new MyHolder2(view);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder myHolder, final int i) {
        if (myHolder instanceof MyHolder) {
            MyHolder holder = (MyHolder) myHolder;
            holder.imageView.setImageResource((Integer) mList.get(i));
        } else if (myHolder instanceof MyHolder2) {
            UserModel userModel = (UserModel) mList.get(i);
            MyHolder2 holder = (MyHolder2) myHolder;
            holder.tvName.setText(userModel.getName());
            holder.tvAge.setText(String.valueOf(userModel.getAge()));
            holder.tvCity.setText(userModel.getCity());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }

    public class MyHolder2 extends RecyclerView.ViewHolder {
        TextView tvName, tvCity, tvAge;

        public MyHolder2(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvAge = itemView.findViewById(R.id.tvAge);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mList.get(position).getClass().getName().equals("com.example.gaurav.myapplication.UserModel"))
            return 2;
        else
        {
            return 1;
        }
    }
}
