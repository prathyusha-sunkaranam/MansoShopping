package com.example.mansopresk21.mansoshopping.ExpandListView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.mansopresk21.mansoshopping.R;

import java.util.ArrayList;

public class ExplistMainActivity extends Activity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    //ImageView imageView;
    ListView lv;
//    Integer[] imageId = {
//            R.drawable.image,
//            R.drawable.image,
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandmain);
      //  imageView = (ImageView)findViewById(R.id.imageview);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Your code
                finish();
            }
        });


        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(ExplistMainActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<Child> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                showToastMsg(group_name + "n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "n Expanded");

            }
        });

    }

    public ArrayList<Group> SetStandardGroups() {

        ArrayList<Group> group_list = new ArrayList<Group>();
        ArrayList<Child> child_list;

        // Setting Group 1
        child_list = new ArrayList<Child>();
        Group gru1 = new Group();
        gru1.setName("Clothing");

        Child ch1_1 = new Child();
        ch1_1.setName("Dresses & Jumpsuits");
        child_list.add(ch1_1);

        Child ch1_2 = new Child();
        ch1_2.setName("Tops, Tees & Shirts");
        child_list.add(ch1_2);

        Child ch1_3 = new Child();
        ch1_3.setName("Ethnic Wear");
        child_list.add(ch1_3);

        Child ch1_4 = new Child();
        ch1_4.setName("Tunics");
        child_list.add(ch1_4);

        Child ch1_5 = new Child();
        ch1_5.setName("Trousers & Jeans");
        child_list.add(ch1_5);

        Child ch1_6 = new Child();
        ch1_6.setName("Leggings & Jeggings");
        child_list.add(ch1_6);

        Child ch1_7 = new Child();
        ch1_7.setName("Bridal Wear");
        child_list.add(ch1_7);

        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<Child>();
        Group gru2 = new Group();
        gru2.setName("Men");

        Child ch2_1 = new Child();
        ch2_1.setName("Casual Shirts");
        child_list.add(ch2_1);

        Child ch2_2 = new Child();
        ch2_2.setName("Polos & Tees");
        child_list.add(ch2_2);

        Child ch2_3 = new Child();
        ch2_3.setName("Formal Shirts");
        child_list.add(ch2_3);

        Child ch2_4 = new Child();
        ch2_4.setName("Ethnic wear");
        child_list.add(ch2_4);

        gru2.setItems(child_list);



        child_list = new ArrayList<Child>();
        Group gru3 = new Group();
        gru3.setName("Girls Clothing ");

        Child ch3_1 = new Child();
        ch3_1.setName("Dresses & Skirts");
        child_list.add(ch3_1);

        Child ch3_2 = new Child();
        ch3_2.setName("Jeans & Trousers");
        child_list.add(ch3_2);

        Child ch3_3 = new Child();
        ch3_3.setName("Ethnic Wear");
        child_list.add(ch3_3);

        Child ch3_4 = new Child();
        ch3_4.setName("Tops & T-Shirts");
        child_list.add(ch3_4);

        gru3.setItems(child_list);


        child_list = new ArrayList<Child>();
        Group gru4 = new Group();
        gru4.setName("Boys Clothing ");

        Child ch4_1 = new Child();
        ch4_1.setName("Baby Essentials");
        child_list.add(ch4_1);

        Child ch4_2 = new Child();
        ch4_2.setName("Jeans & Trousers");
        child_list.add(ch4_2);

        Child ch4_3 = new Child();
        ch4_3.setName("Ethnic Wear");
        child_list.add(ch4_3);

        Child ch4_4 = new Child();
        ch4_4.setName("Tops & T-Shirts");
        child_list.add(ch4_4);

        gru4.setItems(child_list);

        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);
        group_list.add(gru3);
        group_list.add(gru4);

        return group_list;
    }


    public void showToastMsg(String Msg) {
        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    }
}
