package com.example.tableapprecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TablesRecyclerViewAdapter extends RecyclerView.Adapter<TablesRecyclerViewAdapter.ViewHolder> {

    List<String> mData;
    LayoutInflater mLayoutInflater;


    TablesRecyclerViewAdapter(List <String> data, Context context)
    {
        this.mData = data;
        this.mLayoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recylerview_row_table,parent, false) ;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String tableVal =mData.get(position);
            holder.mTextViewTables.setText(tableVal);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder
   {
       TextView mTextViewTables;
       public ViewHolder(@NonNull View itemView)
       {
           super(itemView);
           mTextViewTables  = itemView.findViewById(R.id.tv_table);
       }
   }
}
