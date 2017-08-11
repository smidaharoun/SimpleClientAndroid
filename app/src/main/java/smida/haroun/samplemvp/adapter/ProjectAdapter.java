package smida.haroun.samplemvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import smida.haroun.samplemvp.R;
import smida.haroun.samplemvp.model.Project;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class ProjectAdapter extends BaseAdapter {


    private List<Project> items;

    public ProjectAdapter(List<Project> items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.title.setText(items.get(position).getTitle());
        myViewHolder.description.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
