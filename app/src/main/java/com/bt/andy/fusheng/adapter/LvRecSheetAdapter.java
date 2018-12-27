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
    private Context                                  mContext;
    private List<ReceivelistInfo.InspectionlistBean> mList;

    public LvRecSheetAdapter(Context context, List<ReceivelistInfo.InspectionlistBean> list) {
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
            view = View.inflate(mContext, R.layout.lv_rec_all_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.tv_order = view.findViewById(R.id.tv_order);
            viewHolder.tv_comname = view.findViewById(R.id.tv_comname);
            viewHolder.tv_address = view.findViewById(R.id.tv_address);
            viewHolder.tv_tel = view.findViewById(R.id.tv_tel);
            viewHolder.tv_person = view.findViewById(R.id.tv_person);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        viewHolder.tv_order.setText(mList.get(i).getOrderno());
        viewHolder.tv_comname.setText(mList.get(i).getProviderfullname());
        viewHolder.tv_address.setText(mList.get(i).getAddress());
        viewHolder.tv_tel.setText(mList.get(i).getTel());
        viewHolder.tv_person.setText(mList.get(i).getProviderproxy());

        return view;
    }

    private class MyViewHolder {
        TextView tv_order, tv_comname, tv_address, tv_tel, tv_person;
    }
}
