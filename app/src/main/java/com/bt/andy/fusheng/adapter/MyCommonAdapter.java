package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bt.andy.fusheng.adapterViewHolder.MyCommonViewHolder;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/10/11 13:29
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public abstract class MyCommonAdapter extends BaseAdapter {
    private Context            mContext;
    private List               mList;
    private int                mLayout;
    private MyCommonViewHolder mViewHolder;

    public MyCommonAdapter(Context context, List list, int layout, MyCommonViewHolder viewHolder) {
        this.mContext = context;
        this.mList = list;
        this.mLayout = layout;
        this.mViewHolder = viewHolder;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
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
        if (null == view) {
            view = View.inflate(mContext, mLayout, null);
            mViewHolder = new MyCommonViewHolder();
            bindView(view);
            view.setTag(mViewHolder);
        } else {
            mViewHolder = (MyCommonViewHolder) view.getTag();
        }
        setData(i);
        return view;
    }

    public abstract void bindView(View view);

    public abstract void setData(int position);

    //    public void setInit(Context context, List list, int layout, MyCommonViewHolder viewHolder){
    //        this.mContext = context;
    //        this.mList = list;
    //        this.mLayout = layout;
    //        this.mViewHolder = viewHolder;
    //    }
}
