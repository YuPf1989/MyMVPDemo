package com.rain.mymvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rain.mymvpdemo.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, MainFragment.newInstance()).commit();
    }
}
