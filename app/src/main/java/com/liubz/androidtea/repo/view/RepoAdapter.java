package com.liubz.androidtea.repo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liubz.androidtea.R;
import com.liubz.androidtea.network.retrofit.data.Repo;
import com.liubz.androidtea.repo.viewmodel.RepoViewModel;

import java.util.List;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/26/24 4:47 PM
 */
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private final Context mContext;
    private final RepoViewModel mViewModel;
    private RepoSelectListener mListener;

    public interface RepoSelectListener {
        void onSelectAnim(View startView);
    }

    public void setRepoSelectListener(RepoSelectListener listener) {
        mListener = listener;
    }

    public RepoAdapter(@NonNull Context context, @NonNull RepoViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.layout_repo_item, parent, false);
        RepoViewHolder holder = new RepoViewHolder(root);
        holder.repoSelectView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onSelectAnim(v);
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        List<Repo> data = mViewModel.data.getValue();
        if (data != null && position < data.size()) {
            holder.repoNameView.setText(data.get(position).fullName);
        }
    }

    @Override
    public int getItemCount() {
        List<Repo> data = mViewModel.data.getValue();
        return data == null ? 0 : data.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView repoNameView;
        ImageView repoSelectView;
        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            repoNameView = itemView.findViewById(R.id.repo_name);
            repoSelectView = itemView.findViewById(R.id.repo_select);
        }
    }
}
