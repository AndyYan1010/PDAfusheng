package com.bt.andy.fusheng.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.LvRecSheetAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/8 15:44
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckReceiptActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_back;
    private ImageView img_refresh;
    private TextView  tv_title;
    private ListView  lv_rece_sheet;

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
        lv_rece_sheet = (ListView) findViewById(R.id.lv_rece_sheet);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        img_refresh.setVisibility(View.VISIBLE);
        tv_title.setText("待检验的收料单");
        img_back.setOnClickListener(this);
        img_refresh.setOnClickListener(this);
        List mData = new ArrayList();
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        LvRecSheetAdapter sheetAdapter = new LvRecSheetAdapter(this, mData);
        lv_rece_sheet.setAdapter(sheetAdapter);
        lv_rece_sheet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转收料单详情
                Intent intent = new Intent(CheckReceiptActivity.this,RecSheetDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_refresh:
                finish();
                break;
        }
    }
}
