package com.example.abdulrahman.githubrepo.ui.home.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdulrahman.githubrepo.R;
import com.example.abdulrahman.githubrepo.entity.Repo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by abdulrahman on 6/4/2018.
 */

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private List<Repo> items;

    public ReposAdapter() {
        items = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = items.get(position);
        holder.tvRepoDescribtion.setText(repo.getDescription());
        holder.tvRepoNAme.setText(repo.getFull_name());
        holder.tvRepoOwner.setText(repo.getName());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Repo> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_repo_name)
        TextView tvRepoNAme;

        @BindView(R.id.tv_repo_owner)
        TextView tvRepoOwner;

        @BindView(R.id.tv_repo_describtion)
        TextView tvRepoDescribtion;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {


        }
    }
}
