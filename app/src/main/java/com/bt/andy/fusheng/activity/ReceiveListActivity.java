package com.bt.andy.fusheng.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.LvRecSheetAdapter;
import com.bt.andy.fusheng.messegeInfo.ReceivelistInfo;
import com.bt.andy.fusheng.utils.HttpOkhUtils;
import com.bt.andy.fusheng.utils.ProgressDialogUtil;
import com.bt.andy.fusheng.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/8 15:44
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class ReceiveListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                                img_back;
    private ImageView                                img_refresh;
    private TextView                                 tv_title;
    private LinearLayout                             lin_empty;
    private ListView                                 lv_rece_sheet;
    private List<ReceivelistInfo.InspectionlistBean> mData;
    private LvRecSheetAdapter                        sheetAdapter;
    private int REQUEST_REC_DETAIL = 1001;
    private int RESULT_REC_DETAIL  = 10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_receipt_actiivty);
        setView();
        setData();
    }

    private void setView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_refresh = (ImageView) findViewById(R.id.img_refresh);
        tv_title = (TextView) findViewById(R.id.tv_title);
        lin_empty = (LinearLayout) findViewById(R.id.lin_empty);
        lv_rece_sheet = (ListView) findViewById(R.id.lv_rece_sheet);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        img_refresh.setVisibility(View.VISIBLE);
        tv_title.setText("原料配送单列表");
        img_back.setOnClickListener(this);
        img_refresh.setOnClickListener(this);
        mData = new ArrayList();
        sheetAdapter = new LvRecSheetAdapter(this, mData);
        lv_rece_sheet.setAdapter(sheetAdapter);
        lv_rece_sheet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转收料单详情
                Intent intent = new Intent(ReceiveListActivity.this, RecSheetDetailActivity.class);
                intent.putExtra("orderID", ""+mData.get(i).getJlh());
                startActivityForResult(intent, REQUEST_REC_DETAIL);
            }
        });
        //获取查找校验单列表
        getRecevieListInfo();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_refresh:
                //获取查找校验单列表
                getRecevieListInfo();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_REC_DETAIL == requestCode && RESULT_REC_DETAIL == resultCode) {
            //获取查找校验单列表
            getRecevieListInfo();
        }
    }

    private void getRecevieListInfo() {
        HttpOkhUtils.getInstance().doGet(NetConfig.SELECTCGORDEROR, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(ReceiveListActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(ReceiveListActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                ReceivelistInfo receivelistInfo = gson.fromJson(resbody, ReceivelistInfo.class);
                ToastUtils.showToast(ReceiveListActivity.this, receivelistInfo.getMessage());
                if (1 == receivelistInfo.getResult()) {
                    if (null == mData) {
                        mData = new ArrayList<>();
                    } else {
                        mData.clear();
                    }
                    if (null != receivelistInfo.getInspectionlist() && receivelistInfo.getInspectionlist().size() > 0) {
                        lin_empty.setVisibility(View.GONE);
                    } else {
                        lin_empty.setVisibility(View.VISIBLE);
                    }
                    if (null != receivelistInfo.getInspectionlist()) {
                        mData.addAll(receivelistInfo.getInspectionlist());
                    }
                    sheetAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
