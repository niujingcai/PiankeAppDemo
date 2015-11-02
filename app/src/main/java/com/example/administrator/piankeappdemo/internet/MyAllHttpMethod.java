package com.example.administrator.piankeappdemo.internet;

import com.example.pianke.toolsclass.UrlConfig;

import java.util.HashMap;

/**
 * Created by 董梦娇 on 2015/10/10.
 * 这里写所有的连接，包括登录注册等
 */
public class MyAllHttpMethod {
    //单例
    private MyAllHttpMethod(){}
    private static MyAllHttpMethod myAllHttpMethod;
    public synchronized static MyAllHttpMethod newInstance(){
        if (myAllHttpMethod==null){
            myAllHttpMethod=new MyAllHttpMethod();
        }
        return myAllHttpMethod;
    }

    public static void login(HashMap<String,String> params,InternetConnect.onConnectionListener listener){
        InternetConnect.newInstance().addReqest(UrlConfig.URL_LOGIN,params,listener);

    }
    public static void register(){

    }


}
