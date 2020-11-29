package com.example.test;
import android.app.Application;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class AAA extends Application {
    static HashMap <String,String> data=new HashMap();
    public Map<String, String> getData() {
        return data;
    }
    public void add(String x,String y){
        data.put(x,y);
    }

    public void setData(HashMap<String, String> data) {
        AAA.data = data;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        data=new HashMap<>();
        data= (HashMap<String, String>) Collections.synchronizedMap(data);
    }
    public void onTerminate() {
        super.onTerminate();
    }
}




