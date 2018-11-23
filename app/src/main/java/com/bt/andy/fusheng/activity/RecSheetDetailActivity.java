package com.bt.andy.fusheng.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.LvRecDetailAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/9 10:11
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class RecSheetDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_back;
    private TextView  tv_title;
    private ListView  lv_sheet_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_detail_actiivty);
        setView();
        setData();
    }

    private void setView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        tv_title = (TextView) findViewById(R.id.tv_title);
        lv_sheet_detail = (ListView) findViewById(R.id.lv_sheet_detail);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("收料单详情");
        img_back.setOnClickListener(this);
        List mData = new ArrayList();
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        LvRecDetailAdapter detailAdapter = new LvRecDetailAdapter(this, mData);
        lv_sheet_detail.setAdapter(detailAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
