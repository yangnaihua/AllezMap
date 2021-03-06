package com.helloworld.lyz.allezmap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created at 2017/1/11 20:19
 *程序主页面
 * @Version 1.0
 * @Author paul (yangnaihua.2008at163.com)
 * @desc: MainActivity
 */

public class MainActivity extends Activity {

    // 程序刚启动时启动页面显示的时间
    private static final long SPLASH_DELAY_MILLIS = 2000;
    //Sharepreferences 名称
    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Toast.makeText(MainActivity.this, "MainActivity", Toast.LENGTH_LONG).show();
        init();
    }

    public void init() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(SHAREDPREFERENCES_NAME, MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (isFirstRun) {
int d = Log.d("debug", "第一次运行");
Toast.makeText(MainActivity.this, "第一次运行", Toast.LENGTH_LONG).show();
            editor.putBoolean("isFirstRun", false);
            editor.commit();

            //如果是程序首次安装，那么进去引导页面
            goGuide();
        } else {
Toast.makeText(MainActivity.this, "不是第一次运行", Toast.LENGTH_LONG).show();
Log.d("debug", "不是第一次运行");
            //如果程序不是首次安装
            goHome();
        }
    }

    //直接进去到主程序页面 方法
    private void goHome() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Intent intent = new Intent(MainActivity.this, ProgrammeActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }, SPLASH_DELAY_MILLIS);


    }
    // 进入引导页面
    private void goGuide() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }, SPLASH_DELAY_MILLIS);

    }


}
