package com.shengxi.xxwork.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class HeyBoxRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TOP = 400;
    private final static int NORMOL = 401;
    private final static int LIST = 402;

    private LayoutInflater inflater;

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == TOP) {
           // return new TopViewHolder(inflater.inflate())
        } else if (i == LIST) {

        } else {

        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof TopViewHolder){

        }else if (viewHolder instanceof NormalViewHolder){

        }else {

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TOP;
        } else if (position == 5) {
            return LIST;
        } else {
            return NORMOL;
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class TopViewHolder extends RecyclerView.ViewHolder {


        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder{

        public NormalViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ListViewHolder extends RecyclerView.ViewHolder{

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
