package com.bt.andy.fusheng.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bt.andy.fusheng.BaseActivity;
import com.bt.andy.fusheng.MyApplication;
import com.bt.andy.fusheng.NetConfig;
import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.adapter.LvNameAndIDForRecAdapter;
import com.bt.andy.fusheng.adapter.LvRecDetailAdapter;
import com.bt.andy.fusheng.messegeInfo.LoginInfo;
import com.bt.andy.fusheng.messegeInfo.RecAddressInfo;
import com.bt.andy.fusheng.messegeInfo.ReceiveDetailInfo;
import com.bt.andy.fusheng.messegeInfo.SendByCompanyInfo;
import com.bt.andy.fusheng.utils.HttpOkhUtils;
import com.bt.andy.fusheng.utils.PopupOpenHelper;
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
    private TextView                                                           tv_shcompany;
    private TextView                                                           tv_hycompany;
    private TextView                                                           tv_date;
    private ListView                                                           lv_sheet_detail;
    private String                                                             orderID;
    private List<ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean> mData;
    private List<RecAddressInfo.ShouhuolistBean>                               mSHCompanyList;//收货地址
    private List<SendByCompanyInfo.HuoyunlistBean>                             mHYCompanyList;//货运公司
    private LvRecDetailAdapter                                                 detailAdapter;
    private TextView                                                           tv_submit;//提交
    private String                                                             mShouhuoid;//收货id
    private String                                                             mHuoyunid;//货运id
    private int RESULT_REC_DETAIL = 10001;

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
        tv_shcompany = (TextView) findViewById(R.id.tv_shcompany);
        tv_hycompany = (TextView) findViewById(R.id.tv_hycompany);
        lv_sheet_detail = (ListView) findViewById(R.id.lv_sheet_detail);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
    }

    private void setData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("原料配送详情");
        img_back.setOnClickListener(this);
        tv_shcompany.setOnClickListener(this);
        tv_hycompany.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
        orderID = getIntent().getStringExtra("orderID");
        mData = new ArrayList();
        mSHCompanyList = new ArrayList();
        mHYCompanyList = new ArrayList();
        detailAdapter = new LvRecDetailAdapter(this, mData);
        lv_sheet_detail.setAdapter(detailAdapter);
        //获取收料单详情
        getRecevieDetailInfo();
        //获取收货单位
        getSHAddressInfo();
        //获取货运公司
        getHYCompanyInfo();

        //填写PDA当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        tv_date.setText(formatter.format(curDate));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_shcompany:
                //打开选择送货公司
                openSelectStore(tv_shcompany, 0);
                break;
            case R.id.tv_hycompany:
                //打开选择货运公司
                openSelectStore(tv_hycompany, 1);
                break;
            case R.id.tv_submit:
                //提交收料信息
                sendRecInfo();
                break;
        }
    }

    private PopupOpenHelper openHelper;

    private void openSelectStore(final TextView contview, final int kind) {
        openHelper = new PopupOpenHelper(this, contview, R.layout.popup_select_store);
        openHelper.openPopupWindow(true, Gravity.CENTER);
        openHelper.setOnPopupViewClick(new PopupOpenHelper.ViewClickListener() {
            @Override
            public void onViewClickListener(PopupWindow popupWindow, View inflateView) {
                ListView lv_store = inflateView.findViewById(R.id.lv_store);
                LvNameAndIDForRecAdapter nameAndIDAdapter;
                if (0 == kind) {
                    nameAndIDAdapter = new LvNameAndIDForRecAdapter(RecSheetDetailActivity.this, mSHCompanyList, kind);//0地址，1货运
                } else {
                    nameAndIDAdapter = new LvNameAndIDForRecAdapter(RecSheetDetailActivity.this, mHYCompanyList, kind);
                }
                lv_store.setAdapter(nameAndIDAdapter);
                lv_store.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (0 == kind) {
                            contview.setText(mSHCompanyList.get(i).getShaddress());
                            mShouhuoid = mSHCompanyList.get(i).getId();
                        } else {
                            contview.setText(mHYCompanyList.get(i).getHuoyunname());
                            mHuoyunid = mHYCompanyList.get(i).getId();
                        }
                        openHelper.dismiss();
                    }
                });
            }
        });
    }

    private void getSHAddressInfo() {
        HttpOkhUtils.getInstance().doGet(NetConfig.SELECTSH, new HttpOkhUtils.HttpCallBack() {
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
                RecAddressInfo recAddressInfo = gson.fromJson(resbody, RecAddressInfo.class);
                ToastUtils.showToast(RecSheetDetailActivity.this, recAddressInfo.getMessage());
                if (1 == recAddressInfo.getResult()) {
                    if (null != recAddressInfo.getShouhuolist())
                        mSHCompanyList.addAll(recAddressInfo.getShouhuolist());
                }
            }
        });
    }

    private void getHYCompanyInfo() {
        HttpOkhUtils.getInstance().doGet(NetConfig.SELECTHUOYUN, new HttpOkhUtils.HttpCallBack() {
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
                SendByCompanyInfo sendByCompanyInfo = gson.fromJson(resbody, SendByCompanyInfo.class);
                ToastUtils.showToast(RecSheetDetailActivity.this, sendByCompanyInfo.getMessage());
                if (1 == sendByCompanyInfo.getResult()) {
                    if (null != sendByCompanyInfo.getHuoyunlist())
                        mHYCompanyList.addAll(sendByCompanyInfo.getHuoyunlist());
                }
            }
        });
    }

    private boolean isChoice;

    private void sendRecInfo() {
        /*{"fstatus":"1","userid":"40288ace665b7ab501665b7f9da10005","shouhuoid":"40288a0967defead0167df15eb480001","huoyunid":"40288a0966ccc4820166ccc5528e0001","jlh":"15326355","list":[{"receive_id":"798C7013-03D9-4E72-9E32-F0FF04C76CE7","songhuonum":"1","fnote":""}]}*/
        if (null == mShouhuoid || "".equals(mShouhuoid)) {
            ToastUtils.showToast(this, "请选择配送地址");
            return;
        }
        if (null == mHuoyunid || "".equals(mHuoyunid)) {
            ToastUtils.showToast(this, "请选择货运公司");
            return;
        }
        JSONArray jsonArray = new JSONArray();
        for (ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean bean : mData) {
            if (null != bean.getId()) {
                if (bean.isIsMSelect()) {
                    isChoice = true;
                    JSONObject object = new JSONObject();
                    object.put("receive_id", bean.getId());
                    object.put("djjlh", bean.getDjjlh());
                    object.put("songhuonum", "" + bean.getSjsum());
                    object.put("fnote", null == bean.getMineMark() ? "" : bean.getMineMark());
                    jsonArray.add(object);
                }
            }
        }
        if (!isChoice) {
            ToastUtils.showToast(this, "请选择要提交的子表");
            return;
        }
        ProgressDialogUtil.startShow(this, "正在提交...");
        RequestParamsFM params = new RequestParamsFM();
        params.put("fstatus", "1");
        params.put("userid", MyApplication.userID);
        params.put("jlh", orderID);
        params.put("shouhuoid", mShouhuoid);
        params.put("huoyunid", mHuoyunid);
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
                    setResult(RESULT_REC_DETAIL);
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
                        tv_order_code.setText(receivelist.get(0).getOrderno());
                        tv_company.setText(receivelist.get(0).getProviderfullname());
                        tv_contacter.setText(receivelist.get(0).getProviderproxy());
                        tv_tel.setText(receivelist.get(0).getTel());
                        for (ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean bean : receivelist.get(0).getInspectionlistentry()) {
                            bean.setSjsum(0);
                        }
                        if (null != receivelist.get(0).getInspectionlistentry())
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
