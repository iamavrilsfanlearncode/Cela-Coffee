package com.example.cela.celaswitchcheckbox1018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MenuListActivity extends AppCompatActivity {

    Intent intent;
    Bundle bag;
    TextView message;
    Button btnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        //宣告
        message = findViewById(R.id.message);
        bag = getIntent().getExtras();
        String order ="";

        String checkBox1 = bag.getString("checkBox1");
        String checkBox2 = bag.getString("checkBox2");
        String checkBox3 = bag.getString("checkBox3");
        String checkBox4 = bag.getString("checkBox4");
        String checkBox5 = bag.getString("checkBox5");
        String checkBox6 = bag.getString("checkBox6");
        if(checkBox1 != null) order += checkBox1+"\n";
        if(checkBox2 != null) order += checkBox2+"\n";
        if(checkBox3 != null) order += checkBox3+"\n";
        if(checkBox4 != null) order += checkBox4+"\n";
        if(checkBox5 != null) order += checkBox5+"\n";
        if(checkBox6 != null) order += checkBox6+"\n";
        String spinner = bag.getString("spinner");


        String method = "加冰: "+bag.getString("method");
        message.setText(spinner+"\n"+order+"\n"+method);
        btnPrevious = findViewById(R.id.btnPrevious);


        //OnClickListener 開始
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //回到MainActivity, this主要Activity  ; class 下一個Activity
                intent.setClass(MenuListActivity.this,MainActivity.class);
                startActivity(intent);
                finish();//先暫停專案的工作, btnPrevious執行setOnClickListener
            }
        });//OnClickListener END


    }//onCreate END
} //MainActivity End
