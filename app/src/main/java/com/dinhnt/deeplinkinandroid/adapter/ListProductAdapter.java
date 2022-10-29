package com.dinhnt.deeplinkinandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dinhnt.deeplinkinandroid.DetailActivity;
import com.dinhnt.deeplinkinandroid.R;
import com.dinhnt.deeplinkinandroid.models.Product;

import java.util.ArrayList;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Product> list;

    public ListProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTensp.setText(list.get(position).getTensp());
        holder.txtMasp.setText(list.get(position).getMasp());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", list.get(holder.getAdapterPosition()).getMasp());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtMasp, txtTensp;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMasp = itemView.findViewById(R.id.txtMasp);
            txtTensp = itemView.findViewById(R.id.txtTensp);
            cvItem = itemView.findViewById(R.id.cvItem);
        }
    }
}