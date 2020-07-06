package com.liubz.androidtea.material.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liubz.androidtea.Constants;
import com.liubz.androidtea.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private static final String TAG = "HomeAdapter" + Constants.RECYCLER_VIEW_SUFFIX;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private List<Integer> mRandomHeightList;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    private Context mContext;
    private List<String> mList;

    public HomeAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mRandomHeightList = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mRandomHeightList.add((int) (100 + Math.random() * 300));
        }
    }

    public void removeData(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(
                R.layout.item_recycler, parent, false));
        return holder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
        lp.height = mRandomHeightList.get(position);
        holder.tv.setLayoutParams(lp);
        holder.tv.setText(mList.get(position));
        holder.tv.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                int pos = holder.getLayoutPosition();
                Log.i(TAG, "onClick: pos: " + pos + ", position: " + position);
                mOnItemClickListener.onItemClick(holder.tv, position);
            }
        });

        holder.tv.setOnLongClickListener(v -> {
            if (mOnItemClickListener != null) {
                int pos = holder.getLayoutPosition();
                mOnItemClickListener.onItemLongClick(holder.tv, pos);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_item);
        }
    }
}
