package com.liubz.androidtea.repo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liubz.androidtea.R;
import com.liubz.androidtea.network.retrofit.data.Repo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/26/24 4:47 PM
 */
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<Repo> mRepoList;
    private Context mContext;

    public RepoAdapter(Context context, @NonNull List<Repo> repoList) {
        mContext = context;
        mRepoList = repoList == null ? new ArrayList<>() : repoList;
    }

    public void dataChanged(List<Repo> repoList) {
        mRepoList.clear();
        if (repoList != null) {
            mRepoList.addAll(repoList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.layout_repo_item, parent, false);
        return new RepoViewHolder(root);

    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
         holder.repoNameView.setText(mRepoList.get(position).fullName);
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView repoNameView;
        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            repoNameView = itemView.findViewById(R.id.repo_name);
        }
    }
}
