package com.retrofitdemo.adapter;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.retrofitdemo.R;
import com.retrofitdemo.databinding.ReposItemLayoutBinding;
import com.retrofitdemo.model.Repo;

import java.util.ArrayList;
import java.util.List;


public class UserRepoAdapter extends RecyclerView.Adapter<UserRepoAdapter.UserViewHolder> {

    private final List<Repo> repoArrayList;
    private ReposItemLayoutBinding reposItemLayoutBinding;
     public UserRepoAdapter( List<Repo> repoArrayList) {
        this.repoArrayList = repoArrayList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        reposItemLayoutBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.repos_item_layout, parent, false);
        return new UserViewHolder(reposItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Glide.with(holder.ivUserProfile.getContext())
                .load(repoArrayList.get(position).getOwner().getAvatarUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivUserProfile);

        holder.tvRepositoryName.setText(String.format("%s", repoArrayList.get(position).getName()));
        holder.tvRepositoryDesc.setText((CharSequence) repoArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return repoArrayList.size();
    }

    public void addList(ArrayList<Repo> repoArrayList) {
        this.repoArrayList.clear();
        this.repoArrayList.addAll(repoArrayList);
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView ivUserProfile;
        TextView tvRepositoryName;
        TextView tvRepositoryDesc;

        public UserViewHolder(ReposItemLayoutBinding itemView) {
            super(itemView.getRoot());
            ivUserProfile = itemView.ivAvatar;
            tvRepositoryName = itemView.tvRepositoryName;
            tvRepositoryDesc = itemView.tvRepositoryDesc;
        }
    }
}
