package com.bt.andy.fusheng.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.bt.andy.fusheng.MainActivity;
import com.bt.andy.fusheng.MyApplication;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.LoginInfo;
import com.bt.andy.fusheng.utils.HttpOkhUtils;
import com.bt.andy.fusheng.utils.ProgressDialogUtil;
import com.bt.andy.fusheng.utils.RequestParamsFM;
import com.bt.andy.fusheng.utils.SpUtils;
import com.bt.andy.fusheng.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2018/5/22 9:05
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LoginActivity extends Activity implements View.OnClickListener {
    private CheckBox ck_remPas;
    private EditText mEdit_num;
    private EditText mEdit_psd;
    private boolean isRem = false;//是否记录密码
    private Button mBt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_actiivty);
        MyApplication.flag = 0;
        getView();
        setData();
    }

    private void getView() {
        mEdit_num = (EditText) findViewById(R.id.edit_num);
        mEdit_psd = (EditText) findViewById(R.id.edit_psd);
        ck_remPas = (CheckBox) findViewById(R.id.ck_remPas);
        mBt_submit = (Button) findViewById(R.id.bt_login);
    }

    private void setData() {
        Boolean isRemem = SpUtils.getBoolean(LoginActivity.this, "isRem", false);
        if (isRemem) {
            isRem = true;
            ck_remPas.setChecked(true);
            String name = SpUtils.getString(LoginActivity.this, "name");
            String psd = SpUtils.getString(LoginActivity.this, "psd");
            mEdit_num.setText(name);
            mEdit_psd.setText(psd);
        }
        ck_remPas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isRem = b;
            }
        });
        mBt_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String number = mEdit_num.getText().toString().trim();
                String pass = mEdit_psd.getText().toString().trim();
                if ("".equals(number) || "请输入工号".equals(number)) {
                    ToastUtils.showToast(LoginActivity.this, "请输入工号");
                    return;
                }
                if ("请输入密码".equals(pass) || "".equals(pass)) {
                    ToastUtils.showToast(LoginActivity.this, "请输入密码");
                    return;
                }
                //是否记住账号密码
                isNeedRem(number, pass);
                //登录
                loginToService(number, pass);
                //                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //                startActivity(intent);
                break;
        }
    }

    private void isNeedRem(String name, String psd) {
        SpUtils.putBoolean(LoginActivity.this, "isRem", isRem);
        if (isRem) {
            SpUtils.putString(LoginActivity.this, "name", name);
            SpUtils.putString(LoginActivity.this, "psd", psd);
        }
    }

    private void loginToService(String name, String psd) {
        ProgressDialogUtil.startShow(LoginActivity.this, "正在登录请稍后");
        //测试地址，需修改
        RequestParamsFM params = new RequestParamsFM();
        params.put("username", name);
        params.put("pwd", psd);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.LOGIN, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(LoginActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(LoginActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                LoginInfo loginInfo = gson.fromJson(resbody, LoginInfo.class);
                ToastUtils.showToast(LoginActivity.this, loginInfo.getMessage());
                int result = loginInfo.getResult();
                if (result == 1) {
                    LoginInfo.LoginlistBean bean = loginInfo.getLoginlist().get(0);
                    MyApplication.isLogin = 1;
                    MyApplication.userName = bean.getFusername();
                    MyApplication.userID = bean.getId();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
