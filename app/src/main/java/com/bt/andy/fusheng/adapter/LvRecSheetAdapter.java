package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.andy.fusheng.R;

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
    private Context mContext;
    private List    mList;

    public LvRecSheetAdapter(Context context, List list) {
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
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        return view;
    }

    private class MyViewHolder {
        ImageView img_icon;
        TextView  tv_title;
    }
}
