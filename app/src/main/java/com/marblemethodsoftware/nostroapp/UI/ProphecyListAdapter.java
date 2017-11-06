package com.marblemethodsoftware.nostroapp.UI;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.marblemethodsoftware.nostroapp.R;

public class ProphecyListAdapter extends RecyclerView.Adapter<ProphecyListAdapter.ProphecyViewHolder>{

    private String[] prophecyList;
    public TextView prophecyText;


    public ProphecyListAdapter (String[] prophecies){
        prophecyList = prophecies;

    }

    @Override
    public ProphecyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prophecy_list_item, parent, false);
        ProphecyViewHolder holder = new ProphecyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProphecyViewHolder holder, int position) {
        holder.bindProphecy(prophecyList[position]);
    }

    @Override
    public int getItemCount() {
        return prophecyList.length;
    }

    public class ProphecyViewHolder extends RecyclerView.ViewHolder {


        public ProphecyViewHolder(View itemView) {
            super(itemView);
            prophecyText = itemView.findViewById(R.id.prophecyListText);
        }

        public void bindProphecy(String prophecy){
            prophecyText.setText(prophecy);
        }
    }
}
