package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.andy.fusheng.R;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/9 11:10
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LvRecDetailAdapter extends BaseAdapter {
    private Context mContext;
    private List    mList;

    public LvRecDetailAdapter(Context context, List list) {
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
            view = View.inflate(mContext, R.layout.lv_detail_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.tv_dcode = view.findViewById(R.id.tv_dcode);
            viewHolder.tv_name = view.findViewById(R.id.tv_name);
            viewHolder.tv_shrec = view.findViewById(R.id.tv_shrec);
            viewHolder.et_real = view.findViewById(R.id.et_real);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        if (i >= 1) {
            viewHolder.tv_dcode.setText("LJ023-568");
            viewHolder.tv_name.setText("压机螺杆");
            viewHolder.tv_shrec.setText("10");
            viewHolder.et_real.setText("8");
        } else {
            viewHolder.tv_dcode.setText("物料代码");
            viewHolder.tv_name.setText("名称");
            viewHolder.tv_shrec.setText("应收数");
            viewHolder.et_real.setBackground(null);
            viewHolder.et_real.setText("实收数");
        }
        return view;
    }

    private class MyViewHolder {
        ImageView img_icon;
        TextView  tv_title, tv_dcode, tv_name, tv_shrec;
        EditText et_real;
    }
}
