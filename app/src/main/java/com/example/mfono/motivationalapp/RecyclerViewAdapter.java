package com.example.mfono.motivationalapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<Quote> mQuote;


    public RecyclerViewAdapter(ArrayList<Quote> mQuote) {
        this.mQuote = mQuote;

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG,"onBindViewHolder: called.");
        // we have initialised our position of each views in our recycler layout
        Quote quote  = mQuote.get(position);
        // Apply our logic to connect the views to the data
        viewHolder.quote.setText(quote.getmQuotes());
        viewHolder.author_name.setText(quote.getmAuthor());
    }

    @Override
    public int getItemCount() {
        return mQuote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView quote;
        TextView author;
        TextView author_name;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quote = itemView.findViewById(R.id.quote);
            author=itemView.findViewById(R.id.author);
            author_name=itemView.findViewById(R.id.Tv_authorName);
            imageView = itemView.findViewById(R.id.health);
        }
    }
}
