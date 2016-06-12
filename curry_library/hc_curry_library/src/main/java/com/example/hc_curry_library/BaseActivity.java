package com.example.hc_curry_library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hc_curry_library.util.ToastUtil;

/**
 * Created by huangchao on 6/12/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int NET_CONNECT = 1;
    public static final int UN_NET_CONNECT = 2;
    private MonitorNetChangeReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","onCreate");
        startNetChangeReceiver();
    }

    /**
     * 开启网络变化监听广播
     */
    private void startNetChangeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new MonitorNetChangeReceiver();
        registerReceiver(receiver, filter);
    }


    /**
     * 监听网络变化
     *
     * @return
     */
    public abstract int  network_statu(int statu);

    /**
     * 获取内容view
     *
     * @return
     */
    public abstract View getContentView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public class MonitorNetChangeReceiver extends BroadcastReceiver {



        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {
                    ToastUtil.toast(context,"网络不可以用");
                    //改变背景或者 处理网络的全局变量
                    network_statu(UN_NET_CONNECT);
                } else {
                    //改变背景或者 处理网络的全局变量、
                    ToastUtil.toast(context,"网络可以用");
                    network_statu(NET_CONNECT);
                }
            }

        }

    }
}
