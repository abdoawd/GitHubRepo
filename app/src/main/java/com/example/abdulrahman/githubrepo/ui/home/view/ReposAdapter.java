package com.example.abdulrahman.githubrepo.ui.home.view;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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

    private MainActivity activity;
    private List<Repo> items;

    public ReposAdapter(MainActivity activity) {
        items = new ArrayList<>();
        this.activity = activity;
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
        if (repo.getFork()) {
            holder.layout.setBackgroundColor(Color.WHITE);
        } else {
            holder.layout.setBackgroundColor(Color.GREEN);

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Repo> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        @BindView(R.id.tv_repo_name)
        TextView tvRepoNAme;

        @BindView(R.id.tv_repo_owner)
        TextView tvRepoOwner;

        @BindView(R.id.tv_repo_describtion)
        TextView tvRepoDescribtion;
        @BindView(R.id.row_constraint)
        ConstraintLayout layout;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnLongClickListener(this);
        }




        @Override
        public boolean onLongClick(View v) {
            activity.showDialog(items.get(getAdapterPosition()).getHtml_url(),
                    items.get(getAdapterPosition()).getOwner().getHtml_url());
            return false;
        }
    }
}
