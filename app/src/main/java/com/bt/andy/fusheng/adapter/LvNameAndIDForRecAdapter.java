package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.RecAddressInfo;
import com.bt.andy.fusheng.messegeInfo.SendByCompanyInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/23 18:24
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LvNameAndIDForRecAdapter extends BaseAdapter {
    private Context mContext;
    private List    mList;
    private int     mKind;

    public LvNameAndIDForRecAdapter(Context context, List list, int kind) {
        this.mContext = context;
        this.mList = list;
        this.mKind = kind;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if (null == view) {
            view = View.inflate(mContext, R.layout.lv_store_name, null);
            viewHolder = new MyViewHolder();
            viewHolder.tv_name = view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        if (0==mKind){
            viewHolder.tv_name.setText(((RecAddressInfo.ShouhuolistBean)mList.get(i)).getShaddress());
        }else {
            viewHolder.tv_name.setText(((SendByCompanyInfo.HuoyunlistBean)mList.get(i)).getHuoyunname());
        }
        return view;
    }

    private class MyViewHolder {
        TextView tv_name;
    }
}
