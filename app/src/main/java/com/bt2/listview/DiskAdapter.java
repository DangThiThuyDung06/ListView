package com.bt2.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DiskAdapter extends ArrayAdapter<DiskView> {
    private Context ct;
    private ArrayList<DiskView> arr;
    public DiskAdapter(@NonNull Context context, int resource, @NonNull List<DiskView> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.fish_layout, null);
        }
        if(arr.size()>0){
            DiskView d = arr.get(position);
            ImageView imgDisk = convertView.findViewById(R.id.imgDisk);
            TextView txvNameDisk = convertView.findViewById(R.id.txvNameDisk);
            TextView number = convertView.findViewById(R.id.number);
            TextView number1 = convertView.findViewById(R.id.number1);
            number1.setText("$"+d.numItems);
            number.setText(d.numItems+" Items");
            imgDisk.setImageResource(d.image);
            txvNameDisk.setText(d.name);
        }
        return convertView;
    }
}
