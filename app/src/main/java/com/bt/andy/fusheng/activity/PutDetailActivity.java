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
import com.bt.andy.fusheng.adapter.PutProDetailAdapter;
import com.bt.andy.fusheng.messegeInfo.LoginInfo;
import com.bt.andy.fusheng.messegeInfo.PositionDetailInfo;
import com.bt.andy.fusheng.messegeInfo.PutDetailInfo;
import com.bt.andy.fusheng.messegeInfo.StoreDetailInfo;
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

public class PutDetailActivity extends BaseActivity implements View.OnClickListener {
    private ImageView                                           img_back;
    private ImageView                                           img_refresh;
    private TextView                                            tv_title;
    private TextView                                            tv_order;
    private TextView                                            tv_member;
    private TextView                                            tv_date;
    private TextView                                            tv_company;
    private ListView                                            lv_store;
    private String                                              orderID;
    private String                                              orderNO;
    private List<PutDetailInfo.ReceivelistBean.SonghuolistBean> mData;
    private List<StoreDetailInfo.WarehouselistBean>             mStoreData;
    private List<PositionDetailInfo.PositionslistBean>          mPositionData;
    private PutProDetailAdapter                                 putListAdapter;
    private TextView                                            tv_submit;
    private int RESULTCODE_ISREFRESH = 1003;

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
        lv_store = (ListView) findViewById(R.id.lv_store);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        img_refresh.setVisibility(View.VISIBLE);
        tv_title.setText("上架入库详情");
        img_back.setOnClickListener(this);
        img_refresh.setOnClickListener(this);
        tv_submit.setOnClickListener(this);

        orderID = getIntent().getStringExtra("orderID");
        mData = new ArrayList<>();
        mStoreData = new ArrayList<>();
        mPositionData = new ArrayList<>();
        putListAdapter = new PutProDetailAdapter(this, mData, mStoreData, mPositionData);
        lv_store.setAdapter(putListAdapter);

        //获取检测品详情信息
        getPutDetailInfo();

        //获取仓库数据
        getStoreInfo();
        //获取货位信息
        getPositionInfo();
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

    private boolean isChoice;
    private boolean isChoiceStoreOrPosition;

    private void submitInfo() {
        isChoiceStoreOrPosition = true;
        JSONArray jsonArray = new JSONArray();
        for (PutDetailInfo.ReceivelistBean.SonghuolistBean bean : mData) {
            if (bean.isIsMSelect()) {
                isChoice = true;
                JSONObject object = new JSONObject();
                object.put("receive_id", bean.getId());
                object.put("djjlh", bean.getDjjlh());
                object.put("rknum", "" + bean.getSjnum());
                object.put("housecode", bean.getSelectStoreID());
                object.put("entrepot", bean.getSelectStoreName());
                object.put("fcode", bean.getSelectPositionID());
                object.put("place", bean.getSelectPositionName());
                if (null == bean.getSelectStoreID() || null == bean.getSelectPositionID()) {
                    isChoiceStoreOrPosition = false;
                }
                jsonArray.add(object);
            }
        }
        if (!isChoice) {
            ToastUtils.showToast(this, "请选择要提交的子表");
            return;
        }
        if (!isChoiceStoreOrPosition) {
            ToastUtils.showToast(this, "有子表未选择仓库或仓位");
            return;
        }
        RequestParamsFM params = new RequestParamsFM();
        params.put("fstatus", "1");
        params.put("userid", MyApplication.userID);
        params.put("id", orderID);
        params.put("cgorderno", orderNO);
        params.put("list", jsonArray);
        params.setUseJsonStreamer(true);
        HttpOkhUtils.getInstance().doPost(NetConfig.UPDATESHELVES, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(PutDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(PutDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                LoginInfo loginInfo = gson.fromJson(resbody, LoginInfo.class);
                ToastUtils.showToast(PutDetailActivity.this, loginInfo.getMessage());
                if (1 == loginInfo.getResult()) {
                    setResult(RESULTCODE_ISREFRESH);
                    finish();
                }
            }
        });
    }

    private void getStoreInfo() {
        HttpOkhUtils.getInstance().doGet(NetConfig.SELECTWAREHOUSE, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ToastUtils.showToast(PutDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(PutDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                StoreDetailInfo storeDetailInfo = gson.fromJson(resbody, StoreDetailInfo.class);
                ToastUtils.showToast(PutDetailActivity.this, storeDetailInfo.getMessage());
                if (1 == storeDetailInfo.getResult()) {
                    if (null != storeDetailInfo.getWarehouselist() && storeDetailInfo.getWarehouselist().size() > 0)
                        mStoreData.addAll(storeDetailInfo.getWarehouselist());
                }
            }
        });
    }

    private void getPositionInfo() {
        HttpOkhUtils.getInstance().doGet(NetConfig.SELECTPOSITIONS, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ToastUtils.showToast(PutDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(PutDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                PositionDetailInfo positionDetailInfo = gson.fromJson(resbody, PositionDetailInfo.class);
                ToastUtils.showToast(PutDetailActivity.this, positionDetailInfo.getMessage());
                if (1 == positionDetailInfo.getResult()) {
                    if (null != positionDetailInfo.getPositionslist() && positionDetailInfo.getPositionslist().size() > 0)
                        mPositionData.addAll(positionDetailInfo.getPositionslist());

                }
            }
        });
    }

    private void getPutDetailInfo() {
        ProgressDialogUtil.startShow(this, "正在查询...");
        RequestParamsFM params = new RequestParamsFM();
        params.put("songhuoid", orderID);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.SHELVESLISTDE, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(PutDetailActivity.this, "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(PutDetailActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                PutDetailInfo complDetailInfo = gson.fromJson(resbody, PutDetailInfo.class);
                ToastUtils.showToast(PutDetailActivity.this, complDetailInfo.getMessage());
                if (1 == complDetailInfo.getResult()) {
                    List<PutDetailInfo.ReceivelistBean> receivedetail = complDetailInfo.getReceivelist();
                    if (receivedetail.size() > 0) {
                        orderNO = receivedetail.get(0).getCgorderno();
                        tv_order.setText(receivedetail.get(0).getSonghuono());
                        tv_company.setText(receivedetail.get(0).getProviderfullname());
                        tv_member.setText(MyApplication.userName);
                        tv_date.setText(receivedetail.get(0).getChdate());

                        List<PutDetailInfo.ReceivelistBean.SonghuolistBean> songhuolist = receivedetail.get(0).getSonghuolist();
                        if (null != songhuolist && songhuolist.size() > 0) {
                            mData.addAll(songhuolist);
                            putListAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }
    //        mSpCompanyData = new ArrayList();
    //        TransPortCompanyInfo companyInfo = new TransPortCompanyInfo();
    //        companyInfo.setCompany_name("请选择货运公司");
    //        mSpCompanyData.add(companyInfo);
    //        final MyCommonViewHolder mViewHolder = new MyCommonViewHolder();
    //        MyCommonAdapter postAdapter = new MyCommonAdapter(PutDetailActivity.this, mSpCompanyData, R.layout.sp_position_item, mViewHolder) {//PutDetailActivity.this, mStoreData, R.layout.sp_position_item, mViewHolder
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
}
