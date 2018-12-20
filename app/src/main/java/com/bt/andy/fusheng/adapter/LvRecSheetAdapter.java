package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.ReceivelistInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/9 9:05
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LvRecSheetAdapter extends BaseAdapter {
    private Context                               mContext;
    private List<ReceivelistInfo.ReceivelistBean> mList;

    public LvRecSheetAdapter(Context context, List<ReceivelistInfo.ReceivelistBean> list) {
        this.mContext = context;
        this.mList = list;
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
            view = View.inflate(mContext, R.layout.lv_store_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.tv_shname = view.findViewById(R.id.tv_shname);
            viewHolder.tv_comname = view.findViewById(R.id.tv_comname);
            viewHolder.tv_order = view.findViewById(R.id.tv_order);
            viewHolder.tv_date = view.findViewById(R.id.tv_date);
            viewHolder.tv_time = view.findViewById(R.id.tv_time);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
//        viewHolder.tv_shname.setText(mList.get(i).getHuoyun());
//        viewHolder.tv_comname.setText(mList.get(i).getProviderfullname());
//        viewHolder.tv_order.setText(mList.get(i).getOrderno());
//        if (null != mList.get(i).getChdate() && mList.get(i).getChdate().length() > 12) {
//            viewHolder.tv_date.setText(mList.get(i).getChdate().substring(0, 10));
//            viewHolder.tv_time.setText(mList.get(i).getChdate().substring(11));
//        } else {
//            viewHolder.tv_date.setText(mList.get(i).getChdate());
//            viewHolder.tv_time.setText("时间获取失败");
//
//        }
        return view;
    }

    private class MyViewHolder {
        TextView tv_comname, tv_order, tv_time, tv_shname, tv_date;
    }
}
