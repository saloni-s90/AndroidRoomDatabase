package com.example.displayrecords;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;

    private List<UserModel> userModelList;


    public MyAdapter(Context context) {
        this.context = context;
        userModelList = new ArrayList<>();
    }

    public void addUser(UserModel userModel)
    {
        userModelList.add(userModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.addList.setText(userModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView addList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            addList = itemView.findViewById(R.id.addList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,UpdateDataActivity.class);
                    intent.putExtra("userm", userModelList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
