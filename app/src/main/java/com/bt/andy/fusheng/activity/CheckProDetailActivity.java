package com.bt.andy.fusheng.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.utils.HttpOkhUtils;
import com.bt.andy.fusheng.utils.RequestParamsFM;

import java.io.IOException;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/27 10:06
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckProDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_back;
    private TextView  tv_title;
    private TextView  tv_submit;//提交
    private String    orderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_check_detail);
        setView();
        setData();
    }

    private void setView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("检验单详情");
        img_back.setOnClickListener(this);
        orderID = getIntent().getStringExtra("orderID");

        getCheckDetail();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }

    private void getCheckDetail() {
        RequestParamsFM params = new RequestParamsFM();
        params.put("id", orderID);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.INSPECTIONLISTDE, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {

            }

            @Override
            public void onSuccess(int code, String resbody) {

            }
        });
    }
}
