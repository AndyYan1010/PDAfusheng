package com.bt.andy.fusheng.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.MyCommonAdapter;
import com.bt.andy.fusheng.adapterViewHolder.MyCommonViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/9 16:05
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class StoreDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_back;
    private ImageView img_refresh;
    private TextView  tv_title;
    private Spinner   spn_store;
    private Spinner   spn_position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_store_detail);
        setView();
        setData();
    }

    private void setView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_refresh = (ImageView) findViewById(R.id.img_refresh);
        tv_title = (TextView) findViewById(R.id.tv_title);
        spn_store = (Spinner) findViewById(R.id.spn_store);
        spn_position = (Spinner) findViewById(R.id.spn_position);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        img_refresh.setVisibility(View.VISIBLE);
        tv_title.setText("任务单汇报详情");
        img_back.setOnClickListener(this);
        img_refresh.setOnClickListener(this);
        final List<String> mStoreData = new ArrayList();
        mStoreData.add("请选择仓库");
        mStoreData.add("1");
        mStoreData.add("2");
        final MyCommonViewHolder mViewHolder = new MyCommonViewHolder();
        MyCommonAdapter postAdapter = new MyCommonAdapter(StoreDetailActivity.this, mStoreData, R.layout.sp_position_item, mViewHolder) {//StoreDetailActivity.this, mStoreData, R.layout.sp_position_item, mViewHolder

            @Override
            public void bindView(View view) {
                mViewHolder.tv_title = view.findViewById(R.id.tv_title);
            }

            @Override
            public void setData(int position) {
                mViewHolder.tv_title.setText(mStoreData.get(position));
            }

        };
        spn_store.setAdapter(postAdapter);
        spn_position.setAdapter(postAdapter);
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
