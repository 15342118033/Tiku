package com.yu.test.tiku.activitc.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.yu.test.tiku.R;
import com.yu.test.tiku.activitc.sideslip.Sideslip;
import com.yu.test.tiku.pojo.UserBean;
import com.yu.test.tiku.pojo.Users;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

@ContentView(value = R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
@ViewInject(value = R.id.login_image)
private ImageView login_image;
    @ViewInject(value = R.id.user)
    private EditText login_user;
    @ViewInject(R.id.password)
    private EditText login_pass;
    @ViewInject(R.id.email_sign_in_button)
    private Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
    @Event(value = {R.id.email_sign_in_button},type = View.OnClickListener.class)
    private void btnOkClick(View view){
        switch (view.getId()){
            case R.id.email_sign_in_button:{
//                Toast.makeText(this,"登录",Toast.LENGTH_LONG).show();
                if(isEmpty()){
                    login();
                }
            }
            break;
        }



    }
    private void login(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("username",);
//        map.put("password",);
        String url="http://115.29.136.118:8080/web-question/app/login?username="
                +login_user.getText().toString()+"&password="+login_pass.getText().toString();
        RequestParams params=new RequestParams(url);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("tag",result);
//                JSONObjectnew JSONObject(result);
                UserBean bean=JSON.parseObject(result, UserBean.class);
                if(bean.getSuccess().equals("true")){
                    Users user=bean.getUser();
                    SharedPreferences user1 = getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = user1.edit();
                    edit.putString("username",user.getUsername());
                    edit.putString("userpass",user.getPassword());
                    edit.putString("userid",user.getId());
                    edit.putString("nickname",user.getNickname());
                    edit.putString("telephone",user.getTelephone());
                    edit.putString("picurl",user.getPicurl());
                    edit.commit();

                    Intent intent = new Intent(LoginActivity.this, Sideslip.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,bean.getReason(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {


            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    public boolean isEmpty(){
        if (TextUtils.isEmpty(login_user.getText().toString())){
            Toast.makeText(this,"用户不能为空",Toast.LENGTH_LONG).show();
            return false;
        }
        if (TextUtils.isEmpty(login_pass.getText().toString())){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
