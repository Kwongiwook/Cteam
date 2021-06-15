package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    //소스작성은 onCreate에서 한다.
    //AppCompatActivity를 상속받았다.
    //implements 상속 View.OnClickListener 강제성 . onClick
    EditText edt_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "안녕하세요", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_naver = findViewById(R.id.btn_naver);
        btn_naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent 어떤 값을 다른 Activity나 uri를 통해서 새창을 띄울때 사용
                Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });
        //전화걸기 이벤트
        //1.Button 선언 btn_call변수명입력
        //2.btn_call = findViewById(R.id.btn_call);
        //3.btn_call.setOnClickListener()
        //4.
        Button btn_call1 = findViewById(R.id.btncall_1);
        edt_num = findViewById(R.id.edt_num);//위에서선언하고밑에서할당이되었다.

        btn_call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                            //edt_num에 잇는 텍스트를 받아와서
                                            //string 변수에 넣었음
                String phoneNum = "tel:" + edt_num.getText().toString();
                                            //action_dial이라는 동작을 실행시키는데
                                            //phoneNum 이라는 string변수를 넘겨서 사용함
                Intent intent = new Intent(Intent.ACTION_DIAL
                                            , Uri.parse(phoneNum));
                startActivity(intent);

            }
        });

        Button btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this
                , Sub_Activity.class);
                startActivity(intent);
            }
        });

        //Button btn_new2 =  findViewById(R.id.btn_new2);
        //btn_new2.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this
                //, MainActivity.class);
                //startActivity(intent);
            //}
        //});


    }//onCrate

}//Class