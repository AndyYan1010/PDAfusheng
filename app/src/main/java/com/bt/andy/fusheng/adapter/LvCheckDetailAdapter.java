package com.bt.andy.fusheng.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.messegeInfo.CheckDetailInfo;
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

public class LvCheckDetailAdapter extends BaseAdapter {
    private Context                                               mContext;
    private List<CheckDetailInfo.ReceivelistBean.SonghuolistBean> mList;
    private MyAlertDialogHelper                                   dialogHelper;

    public LvCheckDetailAdapter(Context context, List<CheckDetailInfo.ReceivelistBean.SonghuolistBean> list) {
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
            view = View.inflate(mContext, R.layout.lv_check_detail_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.cb_choice = view.findViewById(R.id.cb_choice);
            viewHolder.tv_order = view.findViewById(R.id.tv_order);
            viewHolder.tv_unit = view.findViewById(R.id.tv_unit);
            viewHolder.tv_cz = view.findViewById(R.id.tv_cz);
            viewHolder.tv_guige = view.findViewById(R.id.tv_guige);
            viewHolder.tv_sum = view.findViewById(R.id.tv_sum);
            viewHolder.tv_hgnum = view.findViewById(R.id.tv_hgnum);
            viewHolder.tv_bhgnum = view.findViewById(R.id.tv_bhgnum);
            viewHolder.tv_mark = view.findViewById(R.id.tv_mark);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        viewHolder.tv_order.setText(mList.get(i).getCadno());
        viewHolder.tv_unit.setText(mList.get(i).getUnits());
        viewHolder.tv_cz.setText(mList.get(i).getCadlist());
        viewHolder.tv_guige.setText(mList.get(i).getAutomemo());
        viewHolder.tv_sum.setText("" + mList.get(i).getNum());
        viewHolder.tv_hgnum.setText("" + mList.get(i).getGoodnum());
        viewHolder.tv_bhgnum.setText("" + mList.get(i).getCnum());
        viewHolder.tv_hgnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //填写合格数
                openInputNumDailog(viewHolder.tv_hgnum, i,1);
            }
        });
        viewHolder.tv_bhgnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //填写不合格数
                openInputNumDailog(viewHolder.tv_bhgnum, i,2);
            }
        });
        viewHolder.tv_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出dialog填写备注
                openInputDailog(viewHolder.tv_mark, i);
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
        TextView tv_order, tv_unit, tv_cz, tv_guige, tv_sum, tv_hgnum,tv_bhgnum, tv_mark;
    }

    private int mSjnum;

    private void openInputNumDailog(final TextView tv_sjnum, final int i, final int kind) {
        dialogHelper = new MyAlertDialogHelper();
        View view = View.inflate(mContext, R.layout.dialog_input_pass, null);
        dialogHelper.setDIYView(mContext, view);
        dialogHelper.show();
        TextView tv_title = view.findViewById(R.id.tv_title);
        final EditText et_input = view.findViewById(R.id.et_input);
        TextView tv_cancle = view.findViewById(R.id.tv_cancle);
        TextView tv_sure = view.findViewById(R.id.tv_sure);
        tv_title.setText("检测合格数");
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
                if (1==kind){
                    mList.get(i).setGoodnum(mSjnum);
                }else {
                    mList.get(i).setCnum(mSjnum);
                }
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
                String word = String.valueOf(et_input.getText()).trim();
                tv_mark.setText(word);
                mList.get(i).setMineReason(word);
                MyCloseKeyBoardUtil.closeKeyBoard((Activity) mContext, view);
                dialogHelper.disMiss();
            }
        });
    }
}
