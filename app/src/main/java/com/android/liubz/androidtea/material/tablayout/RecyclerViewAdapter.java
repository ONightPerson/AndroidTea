package com.android.liubz.androidtea.material.tablayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.liubz.androidtea.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_card_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final View view = holder.view;
        view.setOnClickListener(v -> Toast.makeText(mContext,
                "奔跑在孤傲的路上", Toast.LENGTH_SHORT).show());
    }


    @Override
    public int getItemCount() {
        return 30;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public ViewHolder(View view) {
            super(view);
            this.view = view;
        }
    }

}
