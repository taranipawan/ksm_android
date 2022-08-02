package com.satnam.ksm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GurpurabListAdapter extends RecyclerView.Adapter<GurpurabListAdapter.GurpurabListHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<GurpurabModal> gurpurabList;

    //getting the context and product list with constructor
    public GurpurabListAdapter(Context mCtx, List<GurpurabModal> gurpurabList) {
        this.mCtx = mCtx;
        this.gurpurabList = gurpurabList;
    }

    @NonNull
    @Override
    public GurpurabListAdapter.GurpurabListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new GurpurabListAdapter.GurpurabListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_gurpurab_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GurpurabListAdapter.GurpurabListHolder holder, int position) {
        //getting the product of the specified position
        GurpurabModal satsang = gurpurabList.get(position);

        //binding the data with the viewholder views
        holder.textGurpurab.setText(satsang.getDescription());
    }

    @Override
    public int getItemCount() {
        return gurpurabList.size();
    }

    class GurpurabListHolder extends RecyclerView.ViewHolder {

        TextView textGurpurab;

        public GurpurabListHolder(View itemView) {
            super(itemView);

            textGurpurab = itemView.findViewById(R.id.txtGurpurab);
        }
    }
}
