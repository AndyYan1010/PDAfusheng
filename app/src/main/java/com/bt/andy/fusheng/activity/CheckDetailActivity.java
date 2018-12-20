package com.bt.andy.fusheng.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.MyApplication;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.CheckProAdapter;
import com.bt.andy.fusheng.messegeInfo.CheckDetailInfo;
import com.bt.andy.fusheng.utils.HttpOkhUtils;
import com.bt.andy.fusheng.utils.ProgressDialogUtil;
import com.bt.andy.fusheng.utils.RequestParamsFM;
import com.bt.andy.fusheng.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/9 16:05
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                                                img_back;
    private ImageView                                                img_refresh;
    private TextView                                                 tv_title;
    private TextView                                                 tv_order;
    private TextView                                                 tv_member;
    private TextView                                                 tv_date;
    private TextView                                                 tv_company;
    private ListView                                                 lv_store;
    private String                                                   orderID;
    private List<CheckDetailInfo.ShelvesdetailBean.ShelvesentryBean> mData;
    private CheckProAdapter                                          checkListAdapter;
    private TextView                                                 tv_submit;
    //    private EditText                                                 et_recunit;
    //    private EditText                                                 et_address;
    //    private EditText                                                 et_contact;
    //    private EditText                                                 et_phone;
    //    private Spinner                                                  sp_company;
    //    private List<TransPortCompanyInfo>                               mSpCompanyData;
    //    private String                                                   selectCompanyID;


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
        tv_order = (TextView) findViewById(R.id.tv_order);
        tv_member = (TextView) findViewById(R.id.tv_member);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_company = (TextView) findViewById(R.id.tv_company);
        //        et_recunit = (EditText) findViewById(R.id.et_recunit);
        //        et_address = (EditText) findViewById(R.id.et_address);
        //        et_contact = (EditText) findViewById(R.id.et_contact);
        //        et_phone = (EditText) findViewById(R.id.et_phone);
        //        sp_company = (Spinner) findViewById(R.id.sp_company);
        lv_store = (ListView) findViewById(R.id.lv_store);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        img_refresh.setVisibility(View.VISIBLE);
        tv_title.setText("任务单汇报详情");
        img_back.setOnClickListener(this);
        img_refresh.setOnClickListener(this);
        tv_submit.setOnClickListener(this);

        orderID = getIntent().getStringExtra("orderID");
        mData = new ArrayList<>();
        checkListAdapter = new CheckProAdapter(this, mData);
        lv_store.setAdapter(checkListAdapter);


        //        mSpCompanyData = new ArrayList();
        //        TransPortCompanyInfo companyInfo = new TransPortCompanyInfo();
        //        companyInfo.setCompany_name("请选择货运公司");
        //        mSpCompanyData.add(companyInfo);
        //        final MyCommonViewHolder mViewHolder = new MyCommonViewHolder();
        //        MyCommonAdapter postAdapter = new MyCommonAdapter(CheckDetailActivity.this, mSpCompanyData, R.layout.sp_position_item, mViewHolder) {//CheckDetailActivity.this, mStoreData, R.layout.sp_position_item, mViewHolder
        //
        //            @Override
        //            public void bindView(View view) {
        //                mViewHolder.tv_title = view.findViewById(R.id.tv_title);
        //            }
        //
        //            @Override
        //            public void setData(int position) {
        //                mViewHolder.tv_title.setText(mSpCompanyData.get(position).getCompany_name());
        //                selectCompanyID = mSpCompanyData.get(position).getCompany_id();
        //            }
        //
        //        };
        //        sp_company.setAdapter(postAdapter);

        //获取检测品详情信息
        getCheckDetailInfo();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_submit:
                submitInfo();
                break;
        }
    }

    private void submitInfo() {

    }

    private void getCheckDetailInfo() {
        ProgressDialogUtil.startShow(this, "正在查询...");
        RequestParamsFM params = new RequestParamsFM();
        params.put("shelvesid", orderID);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.SHELVESDETAIL, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(CheckDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(CheckDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                CheckDetailInfo complDetailInfo = gson.fromJson(resbody, CheckDetailInfo.class);
                ToastUtils.showToast(CheckDetailActivity.this, complDetailInfo.getMessage());
                if (1 == complDetailInfo.getResult()) {
                    List<CheckDetailInfo.ShelvesdetailBean> shelvesdetail = complDetailInfo.getShelvesdetail();
                    if (shelvesdetail.size() > 0) {
                        tv_order.setText(shelvesdetail.get(0).getCheckno());
                        tv_company.setText(shelvesdetail.get(0).getProviderfullname());
                        tv_member.setText(MyApplication.userName);
                        tv_date.setText(shelvesdetail.get(0).getCheck_date());

                        CheckDetailInfo.ShelvesdetailBean shelvesdetailBean = shelvesdetail.get(0);
                        List<CheckDetailInfo.ShelvesdetailBean.ShelvesentryBean> shelvesentry = shelvesdetailBean.getShelvesentry();
                        if (null != shelvesentry && shelvesentry.size() > 0) {
                            mData.addAll(shelvesentry);
                            checkListAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }
}
