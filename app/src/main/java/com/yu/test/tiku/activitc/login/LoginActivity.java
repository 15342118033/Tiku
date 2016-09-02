package com.yu.test.tiku.activitc.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yu.test.tiku.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

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
                Toast.makeText(this,"登录",Toast.LENGTH_LONG).show();

                System.out.println("    ");
            }
            break;
        }



    }
}
