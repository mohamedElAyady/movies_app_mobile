
package com.example.movies_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView label,type;
    ImageView movieImg;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        label = itemView.findViewById(R.id.label);
        type = itemView.findViewById(R.id.label);
        movieImg = itemView.findViewById(R.id.movieImg);


    }
}
