package com.satnam.ksm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SatsangListAdapter extends RecyclerView.Adapter<SatsangListAdapter.SatsangListHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<SatsangListModal> satsangList;

    //getting the context and product list with constructor
    public SatsangListAdapter(Context mCtx, List<SatsangListModal> satsangList) {
        this.mCtx = mCtx;
        this.satsangList = satsangList;
    }

    @NonNull
    @Override
    public SatsangListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new SatsangListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_satsang_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SatsangListHolder holder, int position) {
        //getting the product of the specified position
        SatsangListModal satsang = satsangList.get(position);

        //binding the data with the viewholder views
        holder.textViewDate.setText(satsang.getDate());
        holder.textViewTime.setText(satsang.getTime());
        holder.textViewOrganizer.setText(satsang.getOrganizer());
        holder.textViewPlace.setText(satsang.getPlace());
        holder.textViewKirtankar.setText(satsang.getKirtankar());
    }

    @Override
    public int getItemCount() {
        return satsangList.size();
    }

    class SatsangListHolder extends RecyclerView.ViewHolder {

        TextView textViewDate, textViewTime, textViewOrganizer, textViewPlace, textViewKirtankar;

        public SatsangListHolder(View itemView) {
            super(itemView);

            textViewDate = itemView.findViewById(R.id.txtDate);
            textViewTime = itemView.findViewById(R.id.txtTime);
            textViewOrganizer = itemView.findViewById(R.id.txtOrganizer);
            textViewPlace = itemView.findViewById(R.id.txtPlace);
            textViewKirtankar = itemView.findViewById(R.id.txtKirtankar);
        }
    }
}
