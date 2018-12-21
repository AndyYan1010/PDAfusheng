package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.PositionDetailInfo;
import com.bt.andy.fusheng.messegeInfo.PutDetailInfo;
import com.bt.andy.fusheng.messegeInfo.StoreDetailInfo;
import com.bt.andy.fusheng.utils.PopupOpenHelper;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2018/12/19 16:04
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class PutProDetailAdapter extends BaseAdapter {
    private Context                                             mContext;
    private List<PutDetailInfo.ReceivelistBean.SonghuolistBean> mList;
    private List<StoreDetailInfo.WarehouselistBean>             mStoreList;
    private List<PositionDetailInfo.PositionslistBean>          mPosList;

    public PutProDetailAdapter(Context context, List<PutDetailInfo.ReceivelistBean.SonghuolistBean> list, List storeList, List posList) {
        this.mContext = context;
        this.mList = list;
        this.mStoreList = storeList;
        this.mPosList = posList;
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
        final MyViewHolder viewHolder;
        if (null == view) {
            view = View.inflate(mContext, R.layout.adapter_item_putdetail, null);
            viewHolder = new MyViewHolder();
            viewHolder.cb_choice = view.findViewById(R.id.cb_choice);
            viewHolder.tv_order = view.findViewById(R.id.tv_order);
            viewHolder.tv_unit = view.findViewById(R.id.tv_unit);
            viewHolder.tv_sum = view.findViewById(R.id.tv_sum);
            viewHolder.tv_store = view.findViewById(R.id.tv_store);
            viewHolder.tv_position = view.findViewById(R.id.tv_position);
            viewHolder.tv_sjsum = view.findViewById(R.id.tv_sjsum);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        viewHolder.tv_order.setText(mList.get(i).getCadno());
        viewHolder.tv_unit.setText(mList.get(i).getUnits());
        viewHolder.tv_sum.setText("" + mList.get(i).getSjnum());
        viewHolder.tv_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开选择仓库
                openSelectStore(viewHolder.tv_store);
            }
        });
        viewHolder.tv_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        viewHolder.tv_sjsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    private class MyViewHolder {
        CheckBox cb_choice;
        TextView tv_store, tv_position, tv_sjsum;
        TextView tv_order, tv_unit, tv_sum;
    }

    private PopupOpenHelper openHelper;

    private void openSelectStore(View view) {
        openHelper = new PopupOpenHelper(mContext, view, R.layout.popup_select_store);

    }
}