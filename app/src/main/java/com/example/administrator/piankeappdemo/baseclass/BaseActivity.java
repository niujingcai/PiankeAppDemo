package com.example.administrator.piankeappdemo.baseclass;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 董梦娇 on 2015/10/9.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //可以放置全局代码
    }

    @Override
    protected void onResume() {
        super.onResume();
        //读取保存的数据
    }

    @Override
    protected void onPause() {
        super.onPause();
        //界面终止时保存数据
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

