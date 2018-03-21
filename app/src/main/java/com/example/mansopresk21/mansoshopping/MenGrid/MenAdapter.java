package com.example.mansopresk21.mansoshopping.MenGrid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansopresk21.mansoshopping.R;
import com.example.mansopresk21.mansoshopping.WomenGrid.GridActivity;


/**
 * Created by Mansopresk01 on 3/21/2018.
 */

public class MenAdapter  extends RecyclerView.Adapter<MenAdapter.ViewHolder> {


        String flowerNames[] ={"pink","yellowrose","rose","pink","pink","yellowrose",
        "rose","pink","pink","yellowrose","rose","pink","pink","pink"} ;

        Integer images[] = {R.drawable.men1,

        R.drawable.men2,R.drawable.men3,

        R.drawable.men4,R.drawable.men5,

        R.drawable.men6,R.drawable.men7,

        R.drawable.men8,R.drawable.men9,
        R.drawable.men10,R.drawable.men11,
        R.drawable.men12,R.drawable.men13,R.drawable.men14};


public MenAdapter(MenGridActivity menGridActivity) {
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
    
