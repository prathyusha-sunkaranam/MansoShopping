package com.example.mansopresk21.mansoshopping.ExpandListView;

import java.util.ArrayList;

/**
 * Created by Mansopresk01 on 3/12/2018.
 */

public class Group {

    private String Name;
    private int Image;
    private ArrayList<Child> Items;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }
}
