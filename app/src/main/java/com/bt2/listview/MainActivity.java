package com.bt2.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        arr.add(new DiskView(R.drawable.chomchom, 10, "Rambutan")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.dua, r.nextInt(10) * 5, "Coconut")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.luu, r.nextInt(10) * 5, "Pomegranate")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.nhan, r.nextInt(10) * 5, "Longan")); //tap Ctrl+D
        arr.add(new DiskView(R.drawable.vai, r.nextInt(10) * 5, "Lychee")); //tap Ctrl+D

        DiskAdapter adapter = new DiskAdapter(this, 0, arr);
        lsvdisk.setAdapter(adapter);

        lsvdisk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                }
            }
        });

        lsvdisk.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int which_item = i;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn xóa hay không?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arr.remove(which_item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });

    }

}