package com.example.jujutsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载启动页
        initRequestStartUpView();

    }
    private void initRequestStartUpView() {//并加载网络请求
        new Thread(new Runnable() {//开启子线程
            @Override
            public void run() {
                //在子线程中执行一个耗时任务，比如加载网络请求

                runOnUiThread(new Runnable() {//回到主线程更新UI
                    @Override
                    public void run() {
                        try {
                            sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(StartPageActivity.this, MainActivity.class);//从当前Activity跳转至首页的MainActivity
                        startActivity(intent);//开启一个新意图
                        StartPageActivity.this.finish();//关闭当前的Activity
                    }
                });
            }
        }).start();//启动子线程
    }


}