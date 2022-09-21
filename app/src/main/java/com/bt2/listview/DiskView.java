package com.bt2.listview;

import android.content.Context;
import android.view.LayoutInflater;

public class DiskView {
    public int image, numItems;
    public String name;

    public DiskView(int image, int numItems, String name) {
        this.image = image;
        this.numItems = numItems;
        this.name = name;
    }
}
