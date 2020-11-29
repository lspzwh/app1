package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AAA aaa=new AAA();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button button=(Button)findViewById(R.id.but2);
        EditText user=(EditText)findViewById(R.id.register_user);
        EditText password=(EditText)findViewById(R.id.register_password);
        EditText password_sure=(EditText)findViewById(R.id.register_password_sure);
        button.setOnClickListener(v -> {
            int flag = 1;
            String username=user.getText().toString();
            String pass=password.getText().toString();
            String pass_sure=password_sure.getText().toString();
            if(username.equals(null)||username.equals("")){
                Toast.makeText(MainActivity2.this, "用户名不能为空", Toast.LENGTH_LONG).show();
                flag=0;
            }
            if (pass.equals(null)||pass.equals("")) {
                Toast.makeText(MainActivity2.this, "密码不能为空", Toast.LENGTH_LONG).show();
                flag=0;}
            for(String key:aaa.getData().keySet())
                if (username.equals(key))
                {Toast.makeText(MainActivity2.this, "用户名已存在", Toast.LENGTH_LONG).show();
                    flag=0;
                    break;}
            if(!pass.equals(pass_sure)){Toast.makeText(MainActivity2.this, "两次密码不一致", Toast.LENGTH_LONG).show();
                flag=0;}
            if(flag==1){
                AAA.data.put(username,pass);
                Toast.makeText(MainActivity2.this, "注册成功", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }


            /*else{
                for(String key:aaa.getData().keySet()){
                    if(username.equals(key))Toast.makeText(MainActivity2.this, "用户名已存在", Toast.LENGTH_LONG).show();
                    else {if (pass.equals(null)||pass.equals("")) {
                        Toast.makeText(MainActivity2.this, "密码不能为空", Toast.LENGTH_LONG).show();
                    }*/
                        /*
                        if (TextUtils.isEmpty(password.getText())) {
                            Toast.makeText(MainActivity2.this, "密码不能为空", Toast.LENGTH_LONG).show();
                        } else if(pass_sure!=pass) Toast.makeText(MainActivity2.this, "两次密码不一致", Toast.LENGTH_LONG).show();
                        else {aaa.data.put(username,pass);
                            Toast.makeText(MainActivity2.this, "注册成功", Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }*/
               /* }
                }

            }*/

            });
        ImageView imageView=(ImageView)findViewById(R.id.back);
        imageView.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}