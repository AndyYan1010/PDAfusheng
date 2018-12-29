package com.bt.andy.fusheng.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.MyApplication;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.LvCheckDetailAdapter;
import com.bt.andy.fusheng.messegeInfo.CheckDetailInfo;
import com.bt.andy.fusheng.messegeInfo.LoginInfo;
import com.bt.andy.fusheng.utils.HttpOkhUtils;
import com.bt.andy.fusheng.utils.ProgressDialogUtil;
import com.bt.andy.fusheng.utils.RequestParamsFM;
import com.bt.andy.fusheng.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private ImageView                                             img_back;
    private TextView                                              tv_title;
    private TextView                                              tv_order;
    private TextView                                              tv_company;
    private TextView                                              tv_address;
    private TextView                                              tv_shdate;
    private TextView                                              tv_member;
    private TextView                                              tv_date;
    private List<CheckDetailInfo.ReceivelistBean.SonghuolistBean> mData;
    private ListView                                              lv_store;
    private LvCheckDetailAdapter                                  checkDetailAdapter;
    private TextView                                              tv_submit;//提交
    private String                                                orderID;
    private String                                                mCgorderno;
    private int RESULT_CHECK_DETAIL = 10007;

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
        tv_order = (TextView) findViewById(R.id.tv_order);
        tv_company = (TextView) findViewById(R.id.tv_company);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_shdate = (TextView) findViewById(R.id.tv_shdate);
        tv_member = (TextView) findViewById(R.id.tv_member);
        tv_date = (TextView) findViewById(R.id.tv_date);
        lv_store = (ListView) findViewById(R.id.lv_store);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("检验单详情");
        img_back.setOnClickListener(this);
        orderID = getIntent().getStringExtra("orderID");
        mData = new ArrayList();
        checkDetailAdapter = new LvCheckDetailAdapter(this, mData);
        lv_store.setAdapter(checkDetailAdapter);
        //获取检验单详情
        getCheckDetail();
        //填写PDA当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        tv_date.setText(formatter.format(curDate));
        tv_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_submit:
                //提交信息到服务器
                submitCheckInfo();
                break;
        }
    }

    private boolean isChoice;

    private void submitCheckInfo() {
        /*{"fstatus":"1","userid":"40288ace665b7ab501665b7f9da10005","id":"46709bfa-4359-463b-9b02-18783905e093","list":[{"receive_id":"1B8B5539-ED60-436D-A319-D38CA26B591D","songhuono":"SH20181229016","cgorderno":"PO2018100008","checknum":"1","goodnum":"1","badnum":"0","reason":""}]}*/
        JSONArray jsonArray = new JSONArray();
        for (CheckDetailInfo.ReceivelistBean.SonghuolistBean bean : mData) {
            if (null != bean.getId()) {
                if (bean.isIsMSelect()) {
                    isChoice = true;
                    JSONObject object = new JSONObject();
                    object.put("receive_id", bean.getId());
                    object.put("songhuono", bean.getSonghuono());
                    object.put("cgorderno", mCgorderno);
                    object.put("checknum", "" + bean.getNum());
                    object.put("goodnum", "" + bean.getGoodnum());
                    object.put("badnum", "" + bean.getCnum());
                    object.put("reason", null == bean.getMineReason() ? "" : bean.getMineReason());
                    jsonArray.add(object);
                }
            }
        }
        if (!isChoice) {
            ToastUtils.showToast(this, "请选择要提交的子表");
            return;
        }
        RequestParamsFM params = new RequestParamsFM();
        params.put("fstatus", "1");
        params.put("userid", MyApplication.userID);
        params.put("id", orderID);
        params.put("list", jsonArray);
        params.setUseJsonStreamer(true);
        HttpOkhUtils.getInstance().doPost(NetConfig.UPDATERECEIVE, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(CheckProDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(CheckProDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                LoginInfo loginInfo = gson.fromJson(resbody, LoginInfo.class);
                ToastUtils.showToast(CheckProDetailActivity.this, loginInfo.getMessage());
                if (1 == loginInfo.getResult()) {
                    setResult(RESULT_CHECK_DETAIL);
                    finish();
                }
            }
        });
    }

    private void getCheckDetail() {
        RequestParamsFM params = new RequestParamsFM();
        params.put("songhuoid", orderID);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.RECEIVELISTDE, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(CheckProDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(CheckProDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                CheckDetailInfo checkDetailInfo = gson.fromJson(resbody, CheckDetailInfo.class);
                ToastUtils.showToast(CheckProDetailActivity.this, checkDetailInfo.getMessage());
                if (1 == checkDetailInfo.getResult()) {
                    if (null == mData) {
                        mData = new ArrayList();
                    } else {
                        mData.clear();
                    }
                    mCgorderno = checkDetailInfo.getReceivelist().get(0).getCgorderno();
                    tv_order.setText(checkDetailInfo.getReceivelist().get(0).getCgorderno());
                    tv_company.setText(checkDetailInfo.getReceivelist().get(0).getProviderfullname());
                    tv_address.setText(checkDetailInfo.getReceivelist().get(0).getChaddress());
                    tv_shdate.setText(checkDetailInfo.getReceivelist().get(0).getChdate());
                    tv_member.setText(checkDetailInfo.getReceivelist().get(0).getProviderproxy());
                    for (CheckDetailInfo.ReceivelistBean.SonghuolistBean bean : checkDetailInfo.getReceivelist().get(0).getSonghuolist()) {
                        bean.setGoodnum(0);
                        bean.setCnum(0);
                    }
                    if (null != checkDetailInfo.getReceivelist().get(0).getSonghuolist())
                        mData.addAll(checkDetailInfo.getReceivelist().get(0).getSonghuolist());
                    checkDetailAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
