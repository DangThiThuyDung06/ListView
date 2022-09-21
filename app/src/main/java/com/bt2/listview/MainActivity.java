package com.bt2.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView lsvdisk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvdisk = findViewById(R.id.lsvdisk);

        ArrayList<DiskView> arr = new ArrayList<>();

        Random r = new Random();

        arr.add(new DiskView(R.drawable.coffee, 10, "Coffee")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.egg, r.nextInt(10)*5, "Coffee")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.pizza, r.nextInt(10)*5, "Pizza")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.pngegg, r.nextInt(10)*5, "Spaghetti")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.salad, r.nextInt(10)*5, "Salad")); //tap Ctrl+D

        DiskAdapter adapter = new DiskAdapter(this, 0, arr);
        lsvdisk.setAdapter(adapter);

    }
}