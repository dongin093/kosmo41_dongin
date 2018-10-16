package com.study.android.android_project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "lecture";

    String Tel;
    String Lon;
    String Lat;
    String Name;
    String Addr;

    String[] permissions=new String[] {
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_PHONE_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = new Intent(this.getIntent());
        Name = intent.getStringExtra("Name");
        Addr = intent.getStringExtra("Addr");
        Tel = intent.getStringExtra("Tel");
        Lat = intent.getStringExtra("Lat");
        Lon = intent.getStringExtra("Lon");
        String Time1c = intent.getStringExtra("Time1c");
        String Time2c = intent.getStringExtra("Time2c");
        String Time3c = intent.getStringExtra("Time3c");
        String Time4c = intent.getStringExtra("Time4c");
        String Time5c = intent.getStringExtra("Time5c");
        String Time6c = intent.getStringExtra("Time6c");
        String Time7c = intent.getStringExtra("Time7c");
        String Time8c = intent.getStringExtra("Time8c");
        String Time1s = intent.getStringExtra("Time1s");
        String Time2s = intent.getStringExtra("Time2s");
        String Time3s = intent.getStringExtra("Time3s");
        String Time4s = intent.getStringExtra("Time4s");
        String Time5s = intent.getStringExtra("Time5s");
        String Time6s = intent.getStringExtra("Time6s");
        String Time7s = intent.getStringExtra("Time7s");
        String Time8s = intent.getStringExtra("Time8s");



        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView9 = findViewById(R.id.textView9);
        TextView textView10 = findViewById(R.id.textView10);

        textView1.setText(Name);
        textView2.setText("주소 : " + Addr);
        textView3.setText("월요일 진료시간 : " + Time1s + " ~ " + Time1c);
        textView4.setText("화요일 진료시간 : " + Time2s + " ~ " + Time2c);
        textView5.setText("수요일 진료시간 : " + Time3s + " ~ " + Time3c);
        textView6.setText("목요일 진료시간 : " + Time4s + " ~ " + Time4c);
        textView7.setText("금요일 진료시간 : " + Time5s + " ~ " + Time5c);
        textView8.setText("토요일 진료시간 : " + Time6s + " ~ " + Time6c);
        textView9.setText("일요일 진료시간 : " + Time7s + " ~ " + Time7c);
        textView10.setText("공휴일 진료시간 : " + Time8s + " ~ " + Time8c);

        if(!checkPermissions()) {
            Toast.makeText(getApplicationContext(),"권한 설정을 해주셔 앱이 정상 동작합니다.",
                    Toast.LENGTH_LONG).show();
            return;
        }

    }

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(this,p);
            if(result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if(!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    1);
            return false;
        }
        return true;
    }

    public void onBtn1Clicked(View v) {
        String str = "tel:" + Tel;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
        startActivity(intent);
    }
    public void onBtn2Clicked(View v) {
        Intent intent1 = new Intent(Main2Activity.this,Main3Activity.class);
        intent1.putExtra("Lat",Lat);
        intent1.putExtra("Lon",Lon);
        intent1.putExtra("Name",Name);
        intent1.putExtra("Tel",Tel);
        startActivity(intent1);
    }
}
