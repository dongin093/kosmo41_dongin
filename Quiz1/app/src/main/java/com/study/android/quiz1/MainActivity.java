package com.study.android.quiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    String[] names = {"정석진","윤용백","김지훈"};
    String[] ages = { "1963년","1984년","1987년"};
    String[] address = {"인천시 부평","서울시 동작","서울시 구로"};
    int[] images = {R.drawable.face1,R.drawable.face1,R.drawable.face1};

    String[] gnames = {"오연주","최송이","남궁윤희"};
    String[] gages = { "1988년","1989년","1991년"};
    String[] gaddress = {"경기도 부천","인천시 서구","인천시 부평"};
    int[] gimages = {R.drawable.face3,R.drawable.face3,R.drawable.face3};

    String[] tel = {"010-0000-0000","010-1111-1111","010-2222-2222"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 3단계
        final MyAdapter adapter = new MyAdapter();
        ListView listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        // 4단계
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Toast.makeText(getApplicationContext(),
                        "selected : " + tel[position],
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    // 1단계
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {return  names.length; }

        @Override
        public Object getItem(int position) {
            return  names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {
//            // 1-1 단계
//            TextView view1 = new TextView(getApplicationContext());
//            view1.setText(names[position]);
//            view1.setTextSize(40.0f);
//            view1.setTextColor(Color.BLUE);
//
////            return view1;
//
//            //
//            LinearLayout layout = new LinearLayout(getApplicationContext());
//            layout.setOrientation(LinearLayout.VERTICAL);
//
//            layout.addView(view1);
//
//            TextView view2 = new TextView(getApplicationContext());
//            view2.setText(ages[position]);
//            view2.setTextSize(40.0f);
//            view2.setTextColor(Color.RED);
//
//            layout.addView(view2);

            // 2단계
            SingerItemView view = new SingerItemView(getApplicationContext());
            view.setName(names[position]);
            view.setgName(gnames[position]);

            view.setAge(ages[position]);
            view.setgAge(gages[position]);

            view.setAddress(address[position]);
            view.setgAddress(gaddress[position]);

            view.setImage(images[position]);
            view.setgImage(gimages[position]);

            return  view;
        }
    }


}