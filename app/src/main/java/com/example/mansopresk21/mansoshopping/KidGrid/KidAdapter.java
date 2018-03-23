package com.example.mansopresk21.mansoshopping.KidGrid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mansopresk21.mansoshopping.MenGrid.MenGridActivity;
import com.example.mansopresk21.mansoshopping.R;

/**
 * Created by Mansopresk01 on 3/21/2018.
 */

public class KidAdapter extends RecyclerView.Adapter<KidAdapter.ViewHolder> {


    String flowerNames[] ={"pink","yellowrose","rose","pink","pink","yellowrose",
            "rose","pink","pink","yellowrose","rose","pink","pink","pink","pink",
            "pink","pink","pink"} ;

    Integer images[] = {R.drawable.kid1,

            R.drawable.kid2,R.drawable.kid3,

            R.drawable.kid4,R.drawable.kid5,

            R.drawable.kid6,R.drawable.kid7,

            R.drawable.kid8,R.drawable.kid9,
            R.drawable.kid10,R.drawable.kid11,
            R.drawable.kid12,R.drawable.kid13,R.drawable.kid14,R.drawable.kid15,R.drawable.kid16,
            R.drawable.kid17,R.drawable.kid18};


    public KidAdapter(KidActivity kidActivity) {
    }


    @Override
    public KidAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        KidAdapter.ViewHolder vh = new KidAdapter.ViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(KidAdapter.ViewHolder holder, final int position) {

        holder.name.setText(flowerNames[position]);
        holder.image.setBackgroundResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return images.length;
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
