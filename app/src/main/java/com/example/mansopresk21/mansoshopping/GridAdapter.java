package com.example.mansopresk21.mansoshopping;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mansopresk01 on 3/20/2018.
 */

public class GridAdapter  extends RecyclerView.Adapter<GridAdapter.ViewHolder> {


    String flowerNames[] ={"pink","yellowrose","rose","pink","pink","yellowrose","rose","pink"} ;

    Integer images[] = {R.drawable.girl1,

            R.drawable.girl2,R.drawable.girl3,

            R.drawable.girl5,R.drawable.girl7,

            R.drawable.girl8,R.drawable.girl9,

            R.drawable.girl10,R.drawable.girl5,R.drawable.girl2,R.drawable.girl3,R.drawable.girl1};


    public GridAdapter(GridActivity gridActivity) {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(flowerNames[position]);
        holder.image.setBackgroundResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return flowerNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name ;

        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.grid_text);
            image = (ImageView) itemView.findViewById(R.id.grid_image);

        }
    }
    }

