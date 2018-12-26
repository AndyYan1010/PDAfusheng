package com.bt.andy.fusheng.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.PositionDetailInfo;
import com.bt.andy.fusheng.messegeInfo.PutDetailInfo;
import com.bt.andy.fusheng.messegeInfo.StoreDetailInfo;
import com.bt.andy.fusheng.utils.MyAlertDialogHelper;
import com.bt.andy.fusheng.utils.MyCloseKeyBoardUtil;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
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
                openSelectStore(i, viewHolder.tv_store, 0);
            }
        });
        viewHolder.tv_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开选择仓库
                openSelectStore(i, viewHolder.tv_position, 1);
            }
        });
        viewHolder.tv_sjsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开输入按钮
                openInputDailog(viewHolder.tv_sjsum, i);
            }
        });
        viewHolder.cb_choice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mList.get(i).setIsMSelect(b);
            }
        });
        return view;
    }

    private class MyViewHolder {
        CheckBox cb_choice;
        TextView tv_store, tv_position, tv_sjsum;
        TextView tv_order, tv_unit, tv_sum;
    }

    private MyAlertDialogHelper dialogHelper;
    private int                 mSjnum;

    private void openInputDailog(final TextView tv_sjsum, final int position) {
        dialogHelper = new MyAlertDialogHelper();
        View view = View.inflate(mContext, R.layout.dialog_input_pass, null);
        dialogHelper.setDIYView(mContext, view);
        dialogHelper.show();
        TextView tv_title = view.findViewById(R.id.tv_title);
        final EditText et_input = view.findViewById(R.id.et_input);
        TextView tv_cancle = view.findViewById(R.id.tv_cancle);
        TextView tv_sure = view.findViewById(R.id.tv_sure);
        tv_title.setText("实入库数");
        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogHelper.disMiss();
            }
        });
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //先比对下账户密码
                String pass = String.valueOf(et_input.getText()).trim();
                if ("".equals(pass) || "请输入数值".equals(pass)) {
                    mSjnum = 0;
                } else {
                    mSjnum = Integer.parseInt(pass);
                }
                tv_sjsum.setText("" + mSjnum);
                mList.get(position).setSjnum(mSjnum);
                MyCloseKeyBoardUtil.closeKeyBoard((Activity) mContext,view);
                dialogHelper.disMiss();
            }
        });
    }

    private PopupOpenHelper openHelper;

    private void openSelectStore(final int position, final TextView contview, final int kind) {
        openHelper = new PopupOpenHelper(mContext, contview, R.layout.popup_select_store);
        openHelper.openPopupWindow(true, Gravity.CENTER);
        openHelper.setOnPopupViewClick(new PopupOpenHelper.ViewClickListener() {
            @Override
            public void onViewClickListener(PopupWindow popupWindow, View inflateView) {
                ListView lv_store = inflateView.findViewById(R.id.lv_store);
                LvNameAndIDAdapter nameAndIDAdapter;
                if (0 == kind) {
                    nameAndIDAdapter = new LvNameAndIDAdapter(mContext, mStoreList, kind);//0仓库，1仓位
                } else {
                    nameAndIDAdapter = new LvNameAndIDAdapter(mContext, mPosList, kind);//0仓库，1仓位
                }
                lv_store.setAdapter(nameAndIDAdapter);
                lv_store.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (0 == kind) {
                            contview.setText(mStoreList.get(i).getHousename());
                            mList.get(position).setSelectStoreID(mStoreList.get(i).getHousecode());
                            mList.get(position).setSelectStoreName(mStoreList.get(i).getHousename());
                        } else {
                            contview.setText(mPosList.get(i).getFname());
                            mList.get(position).setSelectPositionID(mPosList.get(i).getFcode());
                            mList.get(position).setSelectPositionName(mPosList.get(i).getFname());
                        }
                        openHelper.dismiss();
                    }
                });
            }
        });
    }
}
