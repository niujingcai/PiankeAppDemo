package com.example.administrator.piankeappdemo.baseclass;

import android.app.Application;


/**
 * Created by 董梦娇 on 2015/10/10.
 */
public class AppApplication extends Application {
    private static Application mApplication;
    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 地图的初始化
         */
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现

        mApplication = this;
        /**
         * 这里添加程序初始化内容
         * 设置新版本
         * 数据库初始化
         * 地图初始化
         * 数据统计初始化
         */




    }

    /**
     * 通过此方法可以获得Appliaction的context
     * @return
     */
    public static Application getApplication(){
        return mApplication;
    }
}
