package com.example.mansopresk21.mansoshopping.MenGrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mansopresk21.mansoshopping.R;
import com.example.mansopresk21.mansoshopping.WomenGrid.GridActivity;
import com.example.mansopresk21.mansoshopping.WomenGrid.GridAdapter;
import com.example.mansopresk21.mansoshopping.WomenGrid.ImageviewActivity;
import com.example.mansopresk21.mansoshopping.WomenGrid.ItemClickSupport;

/**
 * Created by Mansopresk01 on 3/21/2018.
 */

public class MenGridActivity extends Activity {
    private MenAdapter menAdapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        textView = (TextView) findViewById(R.id.toolbartext);

        textView.setText("Men's Clothing");
    //  recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    // set a GridLayoutManager with default vertical orientation and 2 number of columns
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Your code
                finish();
            }
        });
    //  call the constructor of CustomAdapter to send the reference and data to Adapter
        menAdapter = new MenAdapter(this);

        recyclerView.setAdapter(menAdapter); // set the Adapter to RecyclerView


        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
        @Override
        public void onItemClicked(RecyclerView recyclerView, int position, View v) {


            Intent intent = new Intent(MenGridActivity.this, ImageviewActivity.class);

            intent.putExtra("image", menAdapter.images[position]);
            intent.putExtra("name", menAdapter.flowerNames);
            startActivity(intent);
        }
    });
}

}
