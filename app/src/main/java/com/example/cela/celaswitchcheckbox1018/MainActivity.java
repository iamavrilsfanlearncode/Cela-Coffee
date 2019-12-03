package com.example.cela.celaswitchcheckbox1018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Button btn_next;
    RadioGroup iceselect;
    Spinner spinner;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;
    //命名對應 checkBox cola,  checkBox1 chololate latte   ,  checkBox2 milk tea  ,  checkBox3 bubble tea ,  checkBox4 black tea ,  checkBox5  latte//

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence>
                adapter = ArrayAdapter.createFromResource
                (this,R.array.time,R.layout.support_simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        iceselect = findViewById(R.id.ra_iceselect);
        btn_next = findViewById(R.id.btnNext);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        spinner.setAdapter(adapter);


        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
        checkBox5.setOnCheckedChangeListener(this);
        checkBox6.setOnCheckedChangeListener(this);
        //監聽事件
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bag = new Bundle();

           //挑選spinner時間  (onClick時 , spinner start)
                bag.putString("spinner",spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString());
                Toast.makeText(MainActivity.this,"選擇時間:"+(spinner.getItemAtPosition(spinner.getSelectedItemPosition())), Toast.LENGTH_LONG).show();
           //飲料品項 checkBox
                if (checkBox1.isChecked()){
                    bag.putString("checkBox1", checkBox1.getText().toString());
                    Toast.makeText(MainActivity.this,"挑選飲品:"+checkBox1.getText().toString(), Toast.LENGTH_LONG).show();
                }
                if (checkBox2.isChecked()){
                    bag.putString("checkBox2", checkBox2.getText().toString());
                    Toast.makeText(MainActivity.this,"挑選飲品:"+checkBox2.getText().toString(), Toast.LENGTH_LONG).show();
                }
                if (checkBox3.isChecked()){
                    bag.putString("checkBox3", checkBox3.getText().toString());
                    Toast.makeText(MainActivity.this,"挑選飲品:"+checkBox3.getText().toString(), Toast.LENGTH_LONG).show();
                }
                if (checkBox4.isChecked()){
                    bag.putString("checkBox4", checkBox4.getText().toString());
                    Toast.makeText(MainActivity.this,"挑選飲品:"+checkBox4.getText().toString(), Toast.LENGTH_LONG).show();
                }
                if (checkBox5.isChecked()){
                    bag.putString("checkBox5", checkBox5.getText().toString());
                    Toast.makeText(MainActivity.this,"挑選飲品:"+checkBox5.getText().toString(), Toast.LENGTH_LONG).show();
                }
                if (checkBox6.isChecked()){
                    bag.putString("checkBox6", checkBox6.getText().toString());
                    Toast.makeText(MainActivity.this,"挑選飲品:"+checkBox6.getText().toString(), Toast.LENGTH_LONG).show();
                }
          //RadioButton 加冰  CheckedRadioButtonId
                switch (iceselect.getCheckedRadioButtonId())
                {
                    case R.id.ra1:
                        bag.putString("method","yes");
                        Toast.makeText(MainActivity.this,"加冰:"+R.id.ra1, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.ra2:
                        bag.putString("method","No Ice");
                        Toast.makeText(MainActivity.this,"不加冰:"+R.id.ra2, Toast.LENGTH_LONG).show();
                        break;
                }

                intent = new Intent();
                intent.putExtras(bag);

                intent.setClass(MainActivity.this,MenuListActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }// OnCreate End


    @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {

        }

    }//onCheckedChanged  END


} //MainActivity End