package com.bt.andy.fusheng.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.LvStoreAdapter;
import com.bt.andy.fusheng.messegeInfo.CheckListInfo;
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
 * @创建时间 2018/10/9 13:21
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckProListActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                           img_back;
    private ImageView                           img_refresh;
    private TextView                            tv_title;
    private ListView                            lv_store;
    private List<CheckListInfo.ReceivelistBean> mData;
    private LvStoreAdapter                      sheetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_product);
        setView();
        setData();
    }

    private void setView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_refresh = (ImageView) findViewById(R.id.img_refresh);
        tv_title = (TextView) findViewById(R.id.tv_title);
        lv_store = (ListView) findViewById(R.id.lv_store);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        img_refresh.setVisibility(View.VISIBLE);
        tv_title.setText("产品检测列表");
        img_back.setOnClickListener(this);
        img_refresh.setOnClickListener(this);
        mData = new ArrayList();
        sheetAdapter = new LvStoreAdapter(this, mData);
        lv_store.setAdapter(sheetAdapter);
        lv_store.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转检验单详情
                Intent intent = new Intent(CheckProListActivity.this, CheckDetailActivity.class);
                intent.putExtra("orderID", mData.get(i).getSonghuono());
                startActivity(intent);
            }
        });
        //获取检验列表
        getCheckListInfo();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_refresh:
                //获取检验列表
                getCheckListInfo();
                break;
        }
    }

    private void getCheckListInfo() {
        ProgressDialogUtil.startShow(this, "正在查询...");
        HttpOkhUtils.getInstance().doGet(NetConfig.SHELVESLIST, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(CheckProListActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(CheckProListActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                CheckListInfo compeleteListInfo = gson.fromJson(resbody, CheckListInfo.class);
                ToastUtils.showToast(CheckProListActivity.this, compeleteListInfo.getMessage());
                if (1 == compeleteListInfo.getResult()) {
                    if (null == mData) {
                        mData = new ArrayList();
                    } else {
                        mData.clear();
                    }
                    mData.addAll(compeleteListInfo.getReceivelist());
                    sheetAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
