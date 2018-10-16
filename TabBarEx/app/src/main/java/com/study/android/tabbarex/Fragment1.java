package com.study.android.tabbarex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;


public class Fragment1 extends Fragment {
    private static final String TAG = "lecture";
    private Context context;
    EditText edit1;
    EditText edit2;
    TextView status1;

    String data;

    String pass1;
    String pass2;

    LayoutInflater inflater;
    ViewGroup container;

    String key="jaYEdfXvyWldUslfq8Gy" +
            "102uMd6QitFvayicDdZbsAKUoI%2FkrdS%2B%2FlH3LI35BNE6lMOvZk8dCXwxfCypPU7Jmw%3D%3D";

    boolean initem = false, indutyAddr = false, indutyEtc = false, indutyMapimg = false, indutyName = false;
    boolean indutyTel1 = false;
    boolean indutyTime1c = false,indutyTime2c = false,indutyTime3c = false,indutyTime4c = false,
            indutyTime5c = false,indutyTime6c = false,indutyTime7c = false,indutyTime8c = false;
    boolean indutyTime1s = false,indutyTime2s = false,indutyTime3s = false,indutyTime4s = false,
            indutyTime5s = false,indutyTime6s = false,indutyTime7s = false,indutyTime8s = false;
    boolean inhpid = false,inpostCdn1 = false,inpostCdn2 = false,inwgs84Lon=false,inwgs84Lat=false;

    String dutyAddr = null, dutyEtc = null, dutyMapimg = null, dutyName = null, dutyTel1 = null;
    String dutyTime1c = null, dutyTime2c = null, dutyTime3c = null, dutyTime4c = null,
            dutyTime5c = null, dutyTime6c = null, dutyTime7c = null, dutyTime8c = null;
    String dutyTime1s = null, dutyTime2s = null, dutyTime3s = null, dutyTime4s = null,
            dutyTime5s = null, dutyTime6s = null, dutyTime7s = null, dutyTime8s = null;
    String hpid = null, postCdn1 = null, postCdn2 = null , wgs84Lon = null , wgs84Lat = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

             final ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment_fragment1,container,false);

        edit1 = rootView.findViewById(R.id.edit1);
        edit2 = rootView.findViewById(R.id.edit2);

        pass1 = edit1.getText().toString();
        pass2 = edit2.getText().toString();

        context = container.getContext();

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit1 = rootView.findViewById(R.id.edit1);
                edit2 = rootView.findViewById(R.id.edit2);

                pass1 = edit1.getText().toString();
                pass2 = edit2.getText().toString();

                Intent intent = new Intent(getActivity(),MainActivity.class);
                intent.putExtra("pass1" , pass1);
                intent.putExtra("pass2" , pass2);
                getXmlData(edit1,edit2);
//                ((MainActivity)getActivity()).getXmlData(pass1,pass2);
//                ((MainActivity)getActivity()).getString(intent);
            }
        });
        return rootView;
    }

    //검색명 입력하면 입력된 검색데이터 송출
    public void getXmlData(EditText edit1,EditText edit2){
        Log.d(TAG,"1111111111111");
//        StringBuffer buffer=new StringBuffer();


        String str1= edit1.getText().toString();//EditText에 작성된 Text얻어오기
        String str2= edit2.getText().toString();
        Log.d(TAG,str1+" + "+str2);
        String location1 = URLEncoder.encode(str1);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..
        String location2 = URLEncoder.encode(str2);
        Log.d(TAG,"2222222222222");

        try {
            Log.d(TAG,location1+" + "+location2);
            URL url=new URL("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire?serviceKey=" +
                    key + "&Q0=" + location1 + "&Q1=" + location2 +
                    "&QN=%EC%82%BC%EC%84%B1%EC%95%BD%EA%B5%AD&ORD=NAME&pageNo=1&startPage=1&numOfRows=10&pageSize=10");
            Log.d(TAG,"1111111111111");
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            Log.d(TAG,"2222222222222");
            parser.setInput(url.openStream(), null);
            Log.d(TAG,"333333333333");
            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");
            Log.d(TAG,"444444444444");

            while (parserEvent != XmlPullParser.END_DOCUMENT){
                Log.d(TAG,"55555555");
                switch(parserEvent){
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
                        if(parser.getName().equals("dutyAddr")){ //title 만나면 내용을 받을수 있게 하자
                            indutyAddr = true;
                        }
                        if(parser.getName().equals("dutyEtc")){ //address 만나면 내용을 받을수 있게 하자
                            indutyEtc = true;
                        }
                        if(parser.getName().equals("dutyMapimg")){ //mapx 만나면 내용을 받을수 있게 하자
                            indutyMapimg = true;
                        }
                        if(parser.getName().equals("dutyName")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyName = true;
                        }
                        if(parser.getName().equals("dutyTel1")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTel1 = true;
                        }
                        if(parser.getName().equals("dutyTime1c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime1c = true;
                        }
                        if(parser.getName().equals("dutyTime2c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime2c = true;
                        }
                        if(parser.getName().equals("dutyTime3c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime3c = true;
                        }
                        if(parser.getName().equals("dutyTime4c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime4c = true;
                        }
                        if(parser.getName().equals("dutyTime5c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime5c = true;
                        }
                        if(parser.getName().equals("dutyTime6c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime6c = true;
                        }
                        if(parser.getName().equals("dutyTime7c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime7c = true;
                        }
                        if(parser.getName().equals("dutyTime8c")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime8c = true;
                        }
                        if(parser.getName().equals("dutyTime1s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime1s = true;
                        }
                        if(parser.getName().equals("dutyTime2s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime2s = true;
                        }
                        if(parser.getName().equals("dutyTime3s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime3s = true;
                        }
                        if(parser.getName().equals("dutyTime4s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime4s = true;
                        }
                        if(parser.getName().equals("dutyTime5s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime5s = true;
                        }
                        if(parser.getName().equals("dutyTime6s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime6s = true;
                        }
                        if(parser.getName().equals("dutyTime7s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime7s = true;
                        }
                        if(parser.getName().equals("dutyTime8s")){ //mapy 만나면 내용을 받을수 있게 하자
                            indutyTime8s = true;
                        }
                        if(parser.getName().equals("wgs84Lon")){ //mapy 만나면 내용을 받을수 있게 하자
                            inwgs84Lon = true;
                        }
                        if(parser.getName().equals("wgs84Lat")){ //mapy 만나면 내용을 받을수 있게 하자
                            inwgs84Lat = true;
                        }
                        if(parser.getName().equals("message")){ //message 태그를 만나면 에러 출력
                            status1.setText(status1.getText()+"에러");
                            //여기에 에러코드에 따라 다른 메세지를 출력하도록 할 수 있다.
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
                        if(indutyAddr){ //isTitle이 true일 때 태그의 내용을 저장.
                            dutyAddr = parser.getText();
                            indutyAddr = false;
                        }
                        if(indutyEtc){ //isAddress이 true일 때 태그의 내용을 저장.
                            dutyEtc = parser.getText();
                            indutyEtc = false;
                        }
                        if(indutyMapimg){ //isMapx이 true일 때 태그의 내용을 저장.
                            dutyMapimg = parser.getText();
                            indutyMapimg = false;
                        }
                        if(indutyName){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyName = parser.getText();
                            indutyName = false;
                        }
                        if(indutyTel1){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTel1 = parser.getText();
                            indutyTel1 = false;
                        }
                        if(indutyTime1c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime1c = parser.getText();
                            indutyTime1c = false;
                        }
                        if(indutyTime2c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime2c = parser.getText();
                            indutyTime2c = false;
                        }
                        if(indutyTime3c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime3c = parser.getText();
                            indutyTime3c = false;
                        }
                        if(indutyTime4c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime4c = parser.getText();
                            indutyTime4c = false;
                        }
                        if(indutyTime5c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime5c = parser.getText();
                            indutyTime5c = false;
                        }
                        if(indutyTime6c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime6c = parser.getText();
                            indutyTime6c = false;
                        }
                        if(indutyTime7c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime7c = parser.getText();
                            indutyTime7c = false;
                        }
                        if(indutyTime8c){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime8c = parser.getText();
                            indutyTime8c = false;
                        }
                        if(indutyTime1s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime1s = parser.getText();
                            indutyTime1s = false;
                        }
                        if(indutyTime2s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime2s = parser.getText();
                            indutyTime2s = false;
                        }
                        if(indutyTime3s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime3s = parser.getText();
                            indutyTime3s = false;
                        }
                        if(indutyTime4s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime4s = parser.getText();
                            indutyTime4s = false;
                        }
                        if(indutyTime5s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime5s = parser.getText();
                            indutyTime5s = false;
                        }
                        if(indutyTime6s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime6s = parser.getText();
                            indutyTime6s = false;
                        }
                        if(indutyTime7s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime7s = parser.getText();
                            indutyTime7s = false;
                        }
                        if(indutyTime8s){ //isMapy이 true일 때 태그의 내용을 저장.
                            dutyTime8s = parser.getText();
                            indutyTime8s = false;
                        }
                        if(inwgs84Lon){ //isMapy이 true일 때 태그의 내용을 저장.
                            wgs84Lon = parser.getText();
                            inwgs84Lon = false;
                        }
                        if(inwgs84Lat){ //isMapy이 true일 때 태그의 내용을 저장.
                            wgs84Lat = parser.getText();
                            inwgs84Lat = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                            status1.setText(status1.getText()+"약국명 : "+ dutyName  +"\n 주소 : " + dutyAddr +
                                    "\n 간이 약도 : " + dutyMapimg+"\n 대표 전화 : " + dutyTel1+"\n 비고 : "+ dutyEtc+
                                    "\n 월요일 진료시간 : " + dutyTime1s + " ~ " + dutyTime1c + "\n 화요일 진료시간 : " + dutyTime2s + " ~ " + dutyTime2c+
                                    "\n 수요일 진료시간 : " + dutyTime3s + " ~ " + dutyTime3c + "\n 목요일 진료시간 : " + dutyTime4s + " ~ " + dutyTime4c+
                                    "\n 금요일 진료시간 : " + dutyTime5s + " ~ " + dutyTime5c + "\n 토요일 진료시간 : " + dutyTime6s + " ~ " + dutyTime6c+
                                    "\n 토요일 진료시간 : " + dutyTime7s + " ~ " + dutyTime7c + "\n 공휴일 진료시간 : " + dutyTime8s + " ~ " + dutyTime8c
                                    + "\n 약국 위도 : " + wgs84Lat + "\n 약국 경도 : " + wgs84Lon + "\n\n\n\n" );

                            initem = false;
                        }
                        break;
                }
                parserEvent = parser.next();
            }

        } catch(Exception e){
            status1.setText("에러가..났습니다...");
        }
    }


}
