package com.example.mansopresk21.mansoshopping.WomenGrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mansopresk21.mansoshopping.R;

public class GridActivity extends AppCompatActivity {
    private  GridAdapter adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        textView = (TextView) findViewById(R.id.toolbartext);

        textView.setText("Women's Clothing");

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
        adapter = new GridAdapter(this);
        recyclerView.setAdapter(adapter); // set the Adapter to RecyclerView


        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {


                Intent intent = new Intent(GridActivity.this, ImageviewActivity.class);

                intent.putExtra("image", adapter.images[position]);
                intent.putExtra("name", adapter.flowerNames);
                startActivity(intent);
            }
        });
    }

    }

