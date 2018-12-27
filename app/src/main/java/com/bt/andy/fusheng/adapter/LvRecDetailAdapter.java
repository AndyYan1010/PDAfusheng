package com.bt.andy.fusheng.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.ReceiveDetailInfo;
import com.bt.andy.fusheng.utils.MyAlertDialogHelper;
import com.bt.andy.fusheng.utils.MyCloseKeyBoardUtil;

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
    private Context                                                            mContext;
    private List<ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean> mList;
    private MyAlertDialogHelper                                                dialogHelper;

    public LvRecDetailAdapter(Context context, List<ReceiveDetailInfo.InspectionlistBean.InspectionlistentryBean> list) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final MyViewHolder viewHolder;
        if (null == view) {
            view = View.inflate(mContext, R.layout.lv_rec_detail_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.cb_choice = view.findViewById(R.id.cb_choice);
            viewHolder.tv_order = view.findViewById(R.id.tv_order);
            viewHolder.tv_unit = view.findViewById(R.id.tv_unit);
            viewHolder.tv_cz = view.findViewById(R.id.tv_cz);
            viewHolder.tv_guige = view.findViewById(R.id.tv_guige);
            viewHolder.tv_sum = view.findViewById(R.id.tv_sum);
            viewHolder.tv_dsnum = view.findViewById(R.id.tv_dsnum);
            viewHolder.tv_sjnum = view.findViewById(R.id.tv_sjnum);
            viewHolder.tv_mark = view.findViewById(R.id.tv_mark);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        viewHolder.cb_choice.setVisibility(View.VISIBLE);
        viewHolder.tv_order.setText(mList.get(i).getCadno());
        viewHolder.tv_unit.setText(mList.get(i).getUnits());
        viewHolder.tv_cz.setText(mList.get(i).getUnits());
        viewHolder.tv_guige.setText(mList.get(i).getUnits());
        viewHolder.tv_sum.setText(mList.get(i).getUnits());
        viewHolder.tv_dsnum.setText(mList.get(i).getUnits());
        viewHolder.tv_sjnum.setText(mList.get(i).getSjsum());
        viewHolder.tv_sjnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //填写实际接收数
                openInputNumDailog(viewHolder.tv_sjnum, i);
            }
        });
        viewHolder.tv_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出dialog填写备注
                openInputDailog(viewHolder.tv_mark, i);
            }
        });

        return view;
    }


    private class MyViewHolder {

        CheckBox cb_choice;
        TextView tv_order, tv_unit, tv_cz, tv_guige, tv_sum, tv_dsnum, tv_sjnum, tv_mark;
    }

    private int mSjnum;

    private void openInputNumDailog(final TextView tv_sjnum, final int i) {
        dialogHelper = new MyAlertDialogHelper();
        View view = View.inflate(mContext, R.layout.dialog_input_pass, null);
        dialogHelper.setDIYView(mContext, view);
        dialogHelper.show();
        TextView tv_title = view.findViewById(R.id.tv_title);
        final EditText et_input = view.findViewById(R.id.et_input);
        TextView tv_cancle = view.findViewById(R.id.tv_cancle);
        TextView tv_sure = view.findViewById(R.id.tv_sure);
        tv_title.setText("实际接收数");
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
                tv_sjnum.setText("" + mSjnum);
                mList.get(i).setSjsum(mSjnum);
                MyCloseKeyBoardUtil.closeKeyBoard((Activity) mContext, view);
                dialogHelper.disMiss();
            }
        });
    }

    private void openInputDailog(final TextView tv_mark, final int i) {
        dialogHelper = new MyAlertDialogHelper();
        View view = View.inflate(mContext, R.layout.dialog_input_word, null);
        dialogHelper.setDIYView(mContext, view);
        dialogHelper.show();
        final EditText et_input = view.findViewById(R.id.et_input);
        TextView tv_cancle = view.findViewById(R.id.tv_cancle);
        TextView tv_sure = view.findViewById(R.id.tv_sure);
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
                String word = String.valueOf(et_input.getText()).trim();
                tv_mark.setText(word);
                mList.get(i).setMineMark(word);
                MyCloseKeyBoardUtil.closeKeyBoard((Activity) mContext, view);
                dialogHelper.disMiss();
            }
        });
    }
}
