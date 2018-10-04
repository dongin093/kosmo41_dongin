package com.study.android.quiz1;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    ImageView imageView1;

    TextView textView4;
    TextView textView5;
    TextView textView6;
    ImageView imageView2;

    public SingerItemView(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view,this,true);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        imageView1 = findViewById(R.id.imageView1);

        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        imageView2 = findViewById(R.id.imageView2);
    }

    public void setName(String name) {
        textView1.setText(name);
    }

    public void setAge(String age) {
        textView2.setText(age);
    }

    public void setAddress(String address) {
        textView3.setText(address);
    }

    public void setImage(int imgNum) {
        imageView1.setImageResource(imgNum);
    }

    public void setgName(String name) {
        textView4.setText(name);
    }

    public void setgAge(String age) { textView5.setText(age); }

    public void setgAddress(String address) {
        textView6.setText(address);
    }

    public void setgImage(int imgNum) {
        imageView2.setImageResource(imgNum);
    }
}

