package com.bt.andy.fusheng.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bt.andy.fusheng.R;
import com.bt.andy.fusheng.activity.RecSheetDetailActivity;
import com.bt.andy.fusheng.messegeInfo.ReceiveDetailInfo;

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
    private Context                                                 mContext;
    private List<ReceiveDetailInfo.ReceivelistBean.SonghuolistBean> mList;
    private RecSheetDetailActivity                                  mActivity;

    public LvRecDetailAdapter(Context context, List<ReceiveDetailInfo.ReceivelistBean.SonghuolistBean> list) {
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
            view = View.inflate(mContext, R.layout.lv_detail_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.cb_choice = view.findViewById(R.id.cb_choice);
            viewHolder.tv_dcode = view.findViewById(R.id.tv_dcode);
            viewHolder.tv_unit = view.findViewById(R.id.tv_unit);
            viewHolder.tv_shrec = view.findViewById(R.id.tv_shrec);
            viewHolder.et_real = view.findViewById(R.id.et_real);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (i != 0) {
                    String text = String.valueOf(viewHolder.et_real.getText()).trim();
                    if (!"".equals(text) && !"实收数".equals(text)) {
                        int num;
                        try {
                            num = Integer.parseInt(text);
                        } catch (Exception e) {
                            num = 0;
                        }
                        mList.get(i).setSjnum(num);
                        ((RecSheetDetailActivity) mContext).upDataListInfo(i, num);
                    }
                }
            }
        };
        viewHolder.et_real.removeTextChangedListener(textWatcher);
        viewHolder.cb_choice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mList.get(i).setIsMSelect(b);
            }
        });
        if (i == 0) {
            viewHolder.cb_choice.setVisibility(View.INVISIBLE);
            viewHolder.tv_dcode.setText("物料代码");
            viewHolder.tv_unit.setText("单位");
            viewHolder.tv_shrec.setText("应收数");
            viewHolder.et_real.setText("实收数");
            viewHolder.et_real.setBackground(null);
        } else {
            viewHolder.cb_choice.setVisibility(View.VISIBLE);
            viewHolder.tv_dcode.setText(mList.get(i).getCadno());
            viewHolder.tv_unit.setText(mList.get(i).getUnits());
            viewHolder.tv_shrec.setText("" + mList.get(i).getSonghuonum());
            viewHolder.et_real.setBackground(mContext.getResources().getDrawable(R.drawable.bg_round_frame_02));
            viewHolder.et_real.setText("" + mList.get(i).getSjnum());
            viewHolder.et_real.addTextChangedListener(textWatcher);
        }

        return view;
    }

    private class MyViewHolder {
        CheckBox cb_choice;
        TextView tv_dcode, tv_unit, tv_shrec;
        EditText et_real;
    }
}
