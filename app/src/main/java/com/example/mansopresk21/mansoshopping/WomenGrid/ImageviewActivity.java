package com.example.mansopresk21.mansoshopping.WomenGrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mansopresk21.mansoshopping.R;

public class ImageviewActivity extends AppCompatActivity
{
    ImageView selectedImage;
    TextView brand,discription,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        selectedImage = (ImageView) findViewById(R.id.selectedImage);
        brand = (TextView) findViewById(R.id.brand_text);
        discription = (TextView) findViewById(R.id.discriptn_text);
        price = (TextView) findViewById(R.id.price_text);
        // init a ImageView
        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        selectedImage.setImageResource(intent.getIntExtra("image", 0));
    }

}
