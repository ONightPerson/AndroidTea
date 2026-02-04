package com.liubz.androidtea.repo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.liubz.androidtea.R;
import com.liubz.androidtea.network.retrofit.data.Repo;

import java.util.Objects;

/**
 * @Desc: 使用 ListAdapter (内含 DiffUtil) 优化刷新性能
 * @Author: liubaozhu
 * @Date: 6/26/24 4:47 PM
 */
public class RepoAdapter extends ListAdapter<Repo, RepoAdapter.RepoViewHolder> {

    private RepoSelectListener mListener;

    public interface RepoSelectListener {
        void onSelectAnim(View startView);
    }

    public void setRepoSelectListener(RepoSelectListener listener) {
        mListener = listener;
    }

    public RepoAdapter() {
        super(new RepoDiffCallback());
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_repo_item, parent, false);
        RepoViewHolder holder = new RepoViewHolder(root);
        holder.repoSelectView.setOnClickListener(v -> {
            int position = holder.getBindingAdapterPosition();
            if (mListener != null && position != RecyclerView.NO_POSITION) {
                mListener.onSelectAnim(v);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        Repo repo = getItem(position);
        if (repo != null) {
            holder.repoNameView.setText(repo.fullName);
        }
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        final TextView repoNameView;
        final ImageView repoSelectView;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            repoNameView = itemView.findViewById(R.id.repo_name);
            repoSelectView = itemView.findViewById(R.id.repo_select);
        }
    }

    /**
     * DiffUtil 回调类：用于计算列表差异
     */
    private static class RepoDiffCallback extends DiffUtil.ItemCallback<Repo> {
        @Override
        public boolean areItemsTheSame(@NonNull Repo oldItem, @NonNull Repo newItem) {
            return Objects.equals(oldItem.id, newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Repo oldItem, @NonNull Repo newItem) {
            return Objects.equals(oldItem.fullName, newItem.fullName);
        }
    }
}
