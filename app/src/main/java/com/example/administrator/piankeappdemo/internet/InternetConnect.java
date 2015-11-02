package com.example.administrator.piankeappdemo.internet;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.pianke.toolsclass.NetworkUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/8.
 * 网络连接类，需要网络连接时调用，判断1.是否有网络连接，2服务器是否超时，3，连接失败，4，连接成功
 */
public class InternetConnect {
    //单例
    private InternetConnect() {
    }

    private static InternetConnect mMyInternetConnect;

    public synchronized static InternetConnect newInstance() {
        if (mMyInternetConnect == null) {
            mMyInternetConnect = new InternetConnect();
        }
        return mMyInternetConnect;
    }

    public interface onConnectionListener {
        /**
         * 没有网络连接
         */
        public void onNullInternet();

        /**
         * 网络连接失败
         *
         * @param errorCode：错误码
         */
        public void onFailConnection(int errorCode);

        /**
         * 网络连接成功
         *
         * @param response：服务器返回值
         */
        public void onSuccess(String response);

    }


    /**
     * 此方法的功能：使用dopost方法连接网络
     *
     * @param url：传入连接地址
     * @param params                                                           :传入post需要的参数
     * @param listener：传入监听器（使用时需要利用匿名内部类，其中实现onSucess,onError,onConnection方法）
     */

    public void addReqest(String url, final HashMap<String, String> params, final onConnectionListener listener) {


        MySingleton.getInstance().getRequestQueue();//1.获得请求队列
        //判断是否已连接网络
        if (!NetworkUtils.isNetworkConnected()) {
            listener.onNullInternet();
            return;//如果没有连接直接返回
        }

        //2.创建http请求
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        // mTextView.setText("Response is: "+ response.substring(0,500));
                        listener.onSuccess(response);//网络连接正常返回了值
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse == null) {
                    listener.onFailConnection(404);//网络连接出错。
                } else {
                    listener.onFailConnection(error.networkResponse.statusCode);//网络连接出错。
                }


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //HashMap<String,String> map = mapString;
                return params;
            }
        };
        MySingleton.getInstance().addToRequestQueue(stringRequest);//3.添加请求到队列中


    }


}
