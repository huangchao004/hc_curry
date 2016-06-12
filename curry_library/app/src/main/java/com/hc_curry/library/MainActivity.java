package com.hc_curry.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.hc_curry_library.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

    }

    @Override
    public View getContentView() {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        return view;
    }

    @Override
    public int network_statu(int statu) {
        return statu;
    }
}
