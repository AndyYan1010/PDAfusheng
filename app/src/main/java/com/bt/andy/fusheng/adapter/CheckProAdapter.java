package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.CheckDetailInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/19 16:04
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class CheckProAdapter extends BaseAdapter {
    private Context                                                  mContext;
    private List<CheckDetailInfo.ShelvesdetailBean.ShelvesentryBean> mList;

    public CheckProAdapter(Context context, List<CheckDetailInfo.ShelvesdetailBean.ShelvesentryBean> list) {
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
            view = View.inflate(mContext, R.layout.adapter_item_store, null);
            viewHolder = new MyViewHolder();
            viewHolder.tv_order = view.findViewById(R.id.tv_order);
            viewHolder.tv_unit = view.findViewById(R.id.tv_unit);
            viewHolder.tv_sum = view.findViewById(R.id.tv_sum);
            viewHolder.et_qualified = view.findViewById(R.id.et_qualified);
            viewHolder.et_unqualified = view.findViewById(R.id.et_unqualified);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        viewHolder.tv_order.setText(mList.get(i).getCheckno());
        viewHolder.tv_unit.setText(mList.get(i).getUnits());
        viewHolder.tv_sum.setText("" + mList.get(i).getChecknum());
        viewHolder.et_qualified.setText("" + mList.get(i).getGoodnum());
        viewHolder.et_unqualified.setText("" + mList.get(i).getBadnum());

        return view;
    }

    private class MyViewHolder {
        EditText et_qualified, et_unqualified;
        TextView tv_order, tv_unit, tv_sum;
    }
}
