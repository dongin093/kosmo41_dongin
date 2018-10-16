package com.study.android.android_project;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.internal.MapLifecycleDelegate;

import org.w3c.dom.NameList;
import org.w3c.dom.ls.LSInput;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private static final String TAG = "lecture";
    ListView listView1;
    SingerAdapter adapter;
    EditText edit1;
    EditText edit2;
    TextView text;

    String[] items = { "전체","서울특별시","인천광역시","광주광역시","부산광역시","대전광역시","대구광역시","세종특별자치시","경기도","경상남도",
            "경상북도","전라남도","전라북도","충청남도","충청북도","강원도","제주특별자치도"};

    XmlPullParser xpp;
    String key="jaYEdfXvyWldUslfq8Gy102uMd6QitFvayicDdZbsAKUoI%2FkrdS%2B%2FlH3LI35BNE6lMOvZk8dCXwxfCypPU7Jmw%3D%3D";

    String data;
    String sw;
    int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_item,items);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //아이템이 선택되었을 때 호출됨
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sw =items[position];
            }

            // 아무것도 선택되지 않았을 때 호출됨
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sw = "";
            }
        });

        adapter = new SingerAdapter(this);

        edit2= (EditText)findViewById(R.id.edit2);

        listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("Name",item.getName());
                intent.putExtra("Addr",item.getAddr());
                intent.putExtra("Tel",item.getTel());
                intent.putExtra("Time1c",item.getTime1c());
                intent.putExtra("Time2c",item.getTime2c());
                intent.putExtra("Time3c",item.getTime3c());
                intent.putExtra("Time4c",item.getTime4c());
                intent.putExtra("Time5c",item.getTime5c());
                intent.putExtra("Time6c",item.getTime6c());
                intent.putExtra("Time7c",item.getTime7c());
                intent.putExtra("Time8c",item.getTime8c());
                intent.putExtra("Time1s",item.getTime1s());
                intent.putExtra("Time2s",item.getTime2s());
                intent.putExtra("Time3s",item.getTime3s());
                intent.putExtra("Time4s",item.getTime4s());
                intent.putExtra("Time5s",item.getTime5s());
                intent.putExtra("Time6s",item.getTime6s());
                intent.putExtra("Time7s",item.getTime7s());
                intent.putExtra("Time8s",item.getTime8s());
                intent.putExtra("Lat",item.getLat());
                intent.putExtra("Lon",item.getLon());
                startActivity(intent);
            }
        });

    }

    //Button을 클릭했을 때 자동으로 호출되는 callback method....
    public void mOnClick(View v){
        switch( v.getId() ){
            case R.id.button:

                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        adapter.ClearItem();
                        pageNo=1;
                        if(sw.equals("전체")) {
                            sw="";
                        }
                        data = getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
                break;
        }
    }//mOnClick method..

    public void Btn1Clicked(View v){
        pageNo++;
        switch( v.getId() ){
            case R.id.button2:

                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if(sw.equals("전체")) {
                            sw="";
                        }
                        data = getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
                break;
        }
    }//mOnClick method..

    //검색명 입력하면 입력된 검색데이터 송출
       String  getXmlData(){
           ArrayList<String> AddrList = new ArrayList<>();
           ArrayList<String> EtcList = new ArrayList<>();
           ArrayList<String> MapimgList = new ArrayList<>();
           ArrayList<String> NameList = new ArrayList<>();
           ArrayList<String> Tel1List = new ArrayList<>();

           ArrayList<String> Time1cList = new ArrayList<>();
           ArrayList<String> Time2cList = new ArrayList<>();
           ArrayList<String> Time3cList = new ArrayList<>();
           ArrayList<String> Time4cList = new ArrayList<>();
           ArrayList<String> Time5cList = new ArrayList<>();
           ArrayList<String> Time6cList = new ArrayList<>();
           ArrayList<String> Time7cList = new ArrayList<>();
           ArrayList<String> Time8cList = new ArrayList<>();
           ArrayList<String> Time1sList = new ArrayList<>();
           ArrayList<String> Time2sList = new ArrayList<>();
           ArrayList<String> Time3sList = new ArrayList<>();
           ArrayList<String> Time4sList = new ArrayList<>();
           ArrayList<String> Time5sList = new ArrayList<>();
           ArrayList<String> Time6sList = new ArrayList<>();
           ArrayList<String> Time7sList = new ArrayList<>();
           ArrayList<String> Time8sList = new ArrayList<>();
           ArrayList<String> M84LonList = new ArrayList<>();
           ArrayList<String> M84LatList = new ArrayList<>();

        StringBuffer buffer=new StringBuffer();
        Log.d(TAG,sw);
        String no = Integer.toString(pageNo);
        Log.d(TAG,no);

        String str1= sw;//EditText에 작성된 Text얻어오기
        String str2= edit2.getText().toString();
        String location1 = URLEncoder.encode(str1);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..
        String location2 = URLEncoder.encode(str2);

        String queryURL = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire?serviceKey=" +
                key + "&Q0=" + location1 + "&Q1=" + location2 +
                "&QN=&ORD=NAME&pageNo="+no+"&startPage=1&numOfRows=10&pageSize=10";

        try {
            URL url=new URL(queryURL);
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//테그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과
                        else if(tag.equals("dutyAddr")){
                            xpp.next();
                            AddrList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyEtc")){
                            xpp.next();
                            EtcList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyMapimg")){
                            xpp.next();
                            MapimgList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyName")){
                            xpp.next();
                            NameList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTel1")){
                            xpp.next();
                            Tel1List.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime1c")){
                            xpp.next();
                            Time1cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime2c")){
                            xpp.next();
                            Time2cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime3c")){
                            xpp.next();
                            Time3cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime4c")){
                            xpp.next();
                            Time4cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime5c")){
                            xpp.next();
                            Time5cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime6c")){
                            xpp.next();
                            Time6cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime7c")){
                            xpp.next();
                            Time7cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime8c")){
                            xpp.next();
                            Time8cList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime1s")){
                            xpp.next();
                            Time1sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime2s")){
                            xpp.next();
                            Time2sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime3s")){
                            xpp.next();
                            Time3sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime4s")){
                            xpp.next();
                            Time4sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime5s")){
                            xpp.next();
                            Time5sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime6s")){
                            xpp.next();
                            Time6sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime7s")){
                            xpp.next();
                            Time7sList.add(xpp.getText());
                        }
                        else if(tag.equals("dutyTime8s")){
                            xpp.next();
                            Time8sList.add(xpp.getText());
                        }
                        else if(tag.equals("wgs84Lon")){
                            xpp.next();
                            M84LonList.add(xpp.getText());
                        }
                        else if(tag.equals("wgs84Lat")){
                            xpp.next();
                            M84LatList.add(xpp.getText());
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //테그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }
                eventType= xpp.next();
            }

//            listView1.clearAnimation();

            for (int i=0;i<NameList.size();i++) {

                String Name = "";
                String Addr = "";
                String Map = "";
                String Tel = "";

                String Time1c = "휴일";
                String Time2c = "휴일";
                String Time3c = "휴일";
                String Time4c = "휴일";
                String Time5c = "휴일";
                String Time6c = "휴일";
                String Time7c = "휴일";
                String Time8c = "휴일";
                String Time1s = "휴일";
                String Time2s = "휴일";
                String Time3s = "휴일";
                String Time4s = "휴일";
                String Time5s = "휴일";
                String Time6s = "휴일";
                String Time7s = "휴일";
                String Time8s = "휴일";

                String Lat = "0";
                String Lon = "0";

                if(NameList.size() > i) {
                    Name = NameList.get(i);
                }
                if(AddrList.size() > i) {
                    Addr = AddrList.get(i);
                }
                if(MapimgList.size() > i) {
                    Map = MapimgList.get(i);
                }
                if(Tel1List.size() > i) {
                    Tel = Tel1List.get(i);
                }
                if(Time1cList.size() > i) {
                    Time1c = Time1cList.get(i);
                }
                if(Time2cList.size() > i) {
                    Time2c = Time2cList.get(i);
                }
                if(Time3cList.size() > i) {
                    Time3c = Time3cList.get(i);
                }
                if(Time4cList.size() > i) {
                    Time4c = Time4cList.get(i);
                }
                if(Time5cList.size() > i) {
                    Time5c = Time5cList.get(i);
                }
                if(Time6cList.size() > i) {
                    Time6c = Time6cList.get(i);
                }
                if(Time7cList.size() > i) {
                    Time7c = Time7cList.get(i);
                }
                if(Time8cList.size() > i) {
                    Time8c = Time8cList.get(i);
                }
                if(Time1sList.size() > i) {
                    Time1s = Time1sList.get(i);
                }
                if(Time2sList.size() > i) {
                    Time2s = Time2sList.get(i);
                }
                if(Time3sList.size() > i) {
                    Time3s = Time3sList.get(i);
                }
                if(Time4sList.size() > i) {
                    Time4s = Time4sList.get(i);
                }
                if(Time5sList.size() > i) {
                    Time5s = Time5sList.get(i);
                }
                if(Time6sList.size() > i) {
                    Time6s = Time6sList.get(i);
                }
                if(Time7sList.size() > i) {
                    Time7s = Time7sList.get(i);
                }
                if(Time8sList.size() > i) {
                    Time8s = Time8sList.get(i);
                }
                if(M84LatList.size() > i) {
                    Lat = M84LatList.get(i);
                }
                if(M84LonList.size() > i) {
                    Lon = M84LonList.get(i);
                }
                SingerItem item = new SingerItem(
                        Name,Addr,Map,Tel,Time1c,Time2c,Time3c,Time4c,Time5c,
                        Time6c,Time7c,Time8c,Time1s,Time2s,Time3s,Time4s,
                        Time5s,Time6s,Time7s,Time8s,Lat,Lon,R.drawable.pills);

                adapter.addItem(item);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }
//        buffer.append("파싱 끝\n");
        return buffer.toString();//StringBuffer 문자열 객체 반환
    }//getXmlData method....
}//MainActivity class..

