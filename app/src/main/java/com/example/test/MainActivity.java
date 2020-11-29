package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button)findViewById(R.id.but1);
        TextView text1=(TextView)findViewById(R.id.sina_sign);
        TextView text2=(TextView)findViewById(R.id.tencent_sign);
        TextView text3=(TextView)findViewById(R.id.reminder);
        EditText user=(EditText)findViewById(R.id.sign_in);
        EditText password=(EditText)findViewById(R.id.password);
        text3.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
            finish();
        });
        text1.setOnClickListener(v -> Toast.makeText(MainActivity.this,"无事发生",Toast.LENGTH_SHORT).show());
        text2.setOnClickListener(v -> Toast.makeText(MainActivity.this,"无事发生",Toast.LENGTH_SHORT).show());
        button1.setOnClickListener(v ->{
            for (String key:AAA.data.keySet()){
                String pass=AAA.data.get(key);
                if(user.getText().toString().equals(key)&&password.getText().toString().equals(pass))
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this,"账号密码错误",Toast.LENGTH_SHORT).show();
            }
        });

    }
}