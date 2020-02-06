package com.example.assignmentmvvmretrofit;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.modelNameTextView.setText(listItem.getModelName());
        holder.colorQuantityTextView.setText(listItem.getColor() +" | "+ listItem.getQuantity() + "Mobiles");
        holder.endsOnTextView.setText(listItem.getEndsOn());
        holder.expectedPriceTextView.setText(listItem.getExpectedPrice()+"");
        holder.totalTextView.setText(listItem.getTotalBids()+"");
        holder.lowestBidTextView.setText(listItem.getLowest()+"");
        holder.moreBiddersTextView.setText((listItem.getTotalBids()-2) + " more bidders");


        JSONArray jsonArray = listItem.getBidders();


        List<JSONObject> jsonArrayAsList = new ArrayList<JSONObject>();
        for(int i=0;i<jsonArray.length();i++){
            try {
                boolean add = jsonArrayAsList.add(jsonArray.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(jsonArrayAsList, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject o1, JSONObject o2) {
                int compare = 0;
                try {
                    int keyA = o1.getInt("amount");
                    int keyB = o2.getInt("amount");
                    compare = Integer.compare(keyA,keyB);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return compare;
            }
        });
        jsonArray = new JSONArray();
        for (int i=0;i<jsonArrayAsList.size();i++){
            jsonArray.put(jsonArrayAsList.get(i));
        }

        try {
            JSONObject bidder1 = jsonArray.getJSONObject(0);
            JSONObject bidder2 = jsonArray.getJSONObject(1);
            holder.amount1TextView.setText(bidder1.getInt("amount")+"");
            holder.name1TextView.setText(bidder1.getString("name"));
            holder.time1TextView.setText(bidder1.getString("time"));
            holder.amount2TextView.setText(bidder2.getInt("amount")+"");
            holder.name2TextView.setText(bidder2.getString("name"));
            holder.time2TextView.setText(bidder2.getString("time"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView modelNameTextView;
        public TextView colorQuantityTextView;
        public TextView endsOnTextView;
        public TextView expectedPriceTextView;
        public TextView totalTextView;
        public TextView lowestBidTextView;
        public TextView amount1TextView;
        public TextView name1TextView;
        public TextView time1TextView;
        public TextView amount2TextView;
        public TextView name2TextView;
        public TextView time2TextView;
        public TextView moreBiddersTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            modelNameTextView = itemView.findViewById(R.id.modelNameTextView);
            colorQuantityTextView = itemView.findViewById(R.id.colorQuantityTextView);
            endsOnTextView = itemView.findViewById(R.id.endsOnTextView);
            expectedPriceTextView = itemView.findViewById(R.id.expectedPriceTextView);
            totalTextView = itemView.findViewById(R.id.totalTextView);
            lowestBidTextView = itemView.findViewById(R.id.lowestBidTextView);
            amount1TextView = itemView.findViewById(R.id.amount1TextView);
            name1TextView = itemView.findViewById(R.id.name1TextView);
            time1TextView = itemView.findViewById(R.id.time1TextView);
            amount2TextView = itemView.findViewById(R.id.amount2TextView);
            name2TextView = itemView.findViewById(R.id.name2TextView);
            time2TextView = itemView.findViewById(R.id.time2TextView);
            moreBiddersTextView = itemView.findViewById(R.id.moreBiddersTextView);
        }
    }
}
