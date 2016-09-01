package com.yu.test.tiku.activitc.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import com.yu.test.tiku.R;
import com.yu.test.tiku.activitc.login.LoginActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;


@ContentView(value = R.layout.welcome)
public class WelcomeActivity extends AppCompatActivity {
    @ViewInject(value = R.id.welcome_001)
    private View welcome_001;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
       /*
       new Thread(new Runnable() {
            @Override
            public void run() {
             子线程
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                         主线程
                            alpha();
                        }
                    });
            }
        }).start();*/
        alpha();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        doall();
                    }
                });

            }
        },3000);


    }

    /*透明度变化动画*/
    private void alpha(){
        Animation animation = new AlphaAnimation(0,1);
        animation.setDuration(3000);
        welcome_001.startAnimation(animation);
        System.out.println("执行欢迎界面");
    }
    /*执行转跳或者打开程序*/
    private void doall(){
        if (first()){
            doJump();
        }else {
            doStart();
        }
    }
    /*通过首选项判断是否第一次打开*/
    private boolean first(){
        /*获取一个首选项，参数：（位置，权限-Context.(*)）*/
        SharedPreferences preferences =getSharedPreferences("first",Context.MODE_PRIVATE);

        /*获取首选项中的值,获取是用首选项的对象.get，get后的值也存放的值有关*/
        String f = preferences.getString("f", "");

        if (TextUtils.isEmpty(f)){
            /*对首选项操作的准备，即准备一个编辑类*/
            SharedPreferences.Editor edit = preferences.edit();
            /*使用编辑类对首选项操作，参数：键值，键必须是String类型，值随意*/
            edit.putString("f","firsttest");
            edit.commit();
            return true;
        }
        return false;
    }

//    /*判断是否第一次打开程序*/
//    private boolean first() throws IOException {
//        boolean first = true;
//        File f = new File("firsttest.txt");
//        /*如果在当前文件夹中找到文件“firsttest”，说明不是第一次打开，
//            first置为true，如果没有找到，first置为false，并且创建文件*/
//        if(f.exists()){
//            first = true;
//        }else {
//            first = false;
//            f.createNewFile();
//        }
//        return first;
//    }



    /*跳转到启动页面*/
    private void doJump() {

        Toast.makeText(this,"第一次启动",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(WelcomeActivity.this,GuideActivity.class);
        startActivity(intent);
        finish();


    }
    /*打开程序*/
    private void doStart() {
        Toast.makeText(this,"不是第一次启动",Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(WelcomeActivity.this,LoginActivity.class);
        startActivity(intent1);
        finish();
    }
}
