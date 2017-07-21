package com.example.android.finalandroid511;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.finalandroid511.entitiy.Person;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/7/17.
 */

class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.ViewHolder>{
    Context context;
    ArrayList<Person> employees;

    public EmployeesAdapter(Context context,ArrayList<Person> employees){
        this.context = context;
        this.employees = employees;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name_tv;
        public TextView email_tv;
        public TextView phoneNum_tv;

        public ViewHolder(View v){
            super(v);
            name_tv = v.findViewById(R.id.name_tv);
            email_tv =v.findViewById(R.id.email_tv);
            phoneNum_tv=v.findViewById(R.id.phoneNum_tv);
        }
    }

    @Override
    public EmployeesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.person,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(EmployeesAdapter.ViewHolder holder, int position) {
        holder.name_tv.setText(employees.get(position).getName());
        holder.email_tv.setText(employees.get(position).getEmail());
        holder.phoneNum_tv.setText(employees.get(position).getPhoneNumber());
        // Set a text color for TextView
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
