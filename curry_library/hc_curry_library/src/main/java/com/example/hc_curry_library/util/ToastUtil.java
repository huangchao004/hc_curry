package com.example.hc_curry_library.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by huangchao on 6/12/16.
 */
public class ToastUtil {
    private  static Toast toast;
    private static long oneTime,twoTime;
    private static String oldMsg;
    /**
     * 显示toast
     * @param content  内容
     * @param duration  持续时间
     */
    public  static  void toast(Context mContext,String content , int duration){
        if (content == null) {
            return;
        }else {
            Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 显示默认持续时间为short的Toast
     * @param content  内容
     */
    public  static void toast(Context mContext,String content){
        if (content == null) {
            return;
        }else {
            showToast(mContext,content);
        }
    }
    private   static void showToast(Context context, String s){
        if(toast==null){
            toast =Toast.makeText(context, s, Toast.LENGTH_SHORT);
            toast.show();
            oneTime=System.currentTimeMillis();
        }else{
            twoTime=System.currentTimeMillis();
            if(s.equals(oldMsg)){
                if(twoTime-oneTime>Toast.LENGTH_SHORT){
                    toast.show();
                }
            }else{
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime=twoTime;
    }

}
