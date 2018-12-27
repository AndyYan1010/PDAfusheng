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
import com.bt.andy.fusheng.adapter.LvRecDetailAdapter;
import com.bt.andy.fusheng.messegeInfo.LoginInfo;
import com.bt.andy.fusheng.messegeInfo.ReceiveDetailInfo;
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
 * @创建时间 2018/10/9 10:11
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class RecSheetDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                                                          img_back;
    private TextView                                                           tv_title;
    private TextView                                                           tv_order_code;
    private TextView                                                           tv_company;
    private TextView                                                           tv_contacter;
    private TextView                                                           tv_tel;
    private TextView                                                           tv_hycompany;
    private TextView                                                           tv_date;
    private ListView                                                           lv_sheet_detail;
    private String                                                             orderID;
    private List<ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean> mData;
    private LvRecDetailAdapter                                                 detailAdapter;
    private TextView                                                           tv_submit;//提交
    private String                                                             shouhuoid;//收货id
    private String                                                             huoyunid;//货运id


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
        tv_order_code = (TextView) findViewById(R.id.tv_order_code);
        tv_company = (TextView) findViewById(R.id.tv_company);
        tv_contacter = (TextView) findViewById(R.id.tv_contacter);
        tv_tel = (TextView) findViewById(R.id.tv_tel);
        tv_hycompany = (TextView) findViewById(R.id.tv_hycompany);
        tv_date = (TextView) findViewById(R.id.tv_date);
        lv_sheet_detail = (ListView) findViewById(R.id.lv_sheet_detail);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("收料单详情");
        img_back.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
        orderID = getIntent().getStringExtra("orderID");
        mData = new ArrayList();
        ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean bean = new ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean();
        mData.add(bean);
        detailAdapter = new LvRecDetailAdapter(this, mData);
        lv_sheet_detail.setAdapter(detailAdapter);
        //获取收料单详情
        getRecevieDetailInfo();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_submit:
                //提交收料信息
                sendRecInfo();
                break;
        }
    }

    private void sendRecInfo() {
        /*{"fstatus":"1","userid":"40288ace665b7ab501665b7f9da10005","chdate":"",
        "shouhuoid":"40288a0967defead0167df15eb480001","huoyunid":"","jlh":"",
        "list":[{"receive_id":"40288a0967defead0167df15eb480002","songhuonum":"1"."fnote":"","respectarrivedate":""}]}*/
        JSONArray jsonArray = new JSONArray();
        for (ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean bean : mData) {
            if (null != bean.getId()) {
                JSONObject object = new JSONObject();
                object.put("receive_id", bean.getId());
                object.put("songhuonum", "" + bean.getSjsum());
                object.put("fnote", null == bean.getMineMark() ? "" : bean.getMineMark());
                object.put("respectarrivedate", bean.getRespectarrivedate());
                jsonArray.add(object);
            }
        }
        ProgressDialogUtil.startShow(this, "正在提交...");
        RequestParamsFM params = new RequestParamsFM();
        params.put("fstatus", "1");
        params.put("userid", MyApplication.userID);
        params.put("chdate", "");
        params.put("jlh", orderID);
        params.put("shouhuoid", shouhuoid);
        params.put("huoyunid", huoyunid);
        params.put("list", jsonArray);
        params.setUseJsonStreamer(true);
        HttpOkhUtils.getInstance().doPost(NetConfig.INSERTSONGHUO, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(RecSheetDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(RecSheetDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                LoginInfo loginInfo = gson.fromJson(resbody, LoginInfo.class);
                ToastUtils.showToast(RecSheetDetailActivity.this, loginInfo.getMessage());
                if (1 == loginInfo.getResult()) {
                    finish();
                }
            }
        });
    }

    private void getRecevieDetailInfo() {
        RequestParamsFM params = new RequestParamsFM();
        params.put("jlh", orderID);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.SELECTCGORDER, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(RecSheetDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(RecSheetDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                ReceiveDetailInfo receiveDetailInfo = gson.fromJson(resbody, ReceiveDetailInfo.class);
                ToastUtils.showToast(RecSheetDetailActivity.this, receiveDetailInfo.getMessage());
                if (1 == receiveDetailInfo.getResult()) {
                    List<ReceiveDetailInfo.InspectionlistBean> receivelist = receiveDetailInfo.getInspectionlist();
                    if (receivelist.size() > 0) {
                        shouhuoid = receivelist.get(0).getId();
                        huoyunid = receivelist.get(0).getCgorderno();
                        tv_order_code.setText(receivelist.get(0).getOrderno());
                        tv_company.setText(receivelist.get(0).getProviderfullname());
                        tv_contacter.setText(receivelist.get(0).getProviderproxy());
                        tv_tel.setText(receivelist.get(0).getTel());
                        tv_hycompany.setText(receivelist.get(0).getProviderfullname());
                        for (ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean bean : receivelist.get(0).getInspectionlistentry()) {
                            bean.setSjsum(0);
                        }
                        mData.addAll(receivelist.get(0).getInspectionlistentry());
                        detailAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    public void upDataListInfo(int i, int num) {
        mData.get(i).setSjsum(num);
    }
}
