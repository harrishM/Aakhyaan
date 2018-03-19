package com.gmail.sowmiyanagarajan98.aakhyaan;

/**
 * Created by Sowmiya Nagarajan on 18-03-2018.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    //Creating an arraylist of User objects
    private ArrayList<User> list_members=new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    MyViewHolder holder;
    private Context context;

    public CustomAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view=inflater.inflate(R.layout.custom_row, parent, false);
        holder=new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        User list_items=list_members.get(position);
        holder.user_name.setText(list_items.getName());
        holder.content.setText(list_items.getEmail());
    }

    //Setting the arraylist
    public void setListContent(ArrayList<User> list_members){
        this.list_members=list_members;
        notifyItemRangeChanged(0,list_members.size());

    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView user_name,content,time;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            user_name=(TextView)itemView.findViewById(R.id.user_name);
            content=(TextView)itemView.findViewById(R.id.content);
            time=(TextView)itemView.findViewById(R.id.time);
        }
        @Override
        public void onClick(View v) {

        }
    }
    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }

}