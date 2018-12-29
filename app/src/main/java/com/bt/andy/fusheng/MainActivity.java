package com.bt.andy.fusheng;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.bt.andy.fusheng.activity.CheckProListActivity;
import com.bt.andy.fusheng.activity.PutProListActivity;
import com.bt.andy.fusheng.activity.ReceiveListActivity;
import com.bt.andy.fusheng.adapter.MenuGridviewApater;
import com.bt.andy.fusheng.messegeInfo.MainMenuEntity;
import com.bt.andy.fusheng.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private long exitTime = 0;//记录点击物理返回键的时间
    private GridView           mGridViewMenu;
    private MenuGridviewApater menuAdapter;
    private int[]    resArr  = new int[]{R.drawable.shouliao, R.drawable.pinzhijianyan, R.drawable.shangjia, R.drawable.zhijian, R.drawable.chaipi, R.drawable.kucun, R.drawable.pandian
            , R.drawable.baozhuang, R.drawable.fahuo, R.drawable.kusun, 0, 0};
    private String[] textArr = new String[]{"原料配送",  "品质检验", "上架入库","物料质检", "截料拆批", "库存查询", "盘点", "包装追溯", "成品发货", "库损处理", "", ""};
    private List<MainMenuEntity> dadaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setView();
        setData();
    }

    private void setView() {
        mGridViewMenu = findViewById(R.id.gv_menu);
    }

    private void setData() {
        dadaList = new ArrayList<>();
        for (int i = 0; i < resArr.length; i++) {
            MainMenuEntity data = new MainMenuEntity();
            data.setResId(resArr[i]);
            data.setText(textArr[i]);
            dadaList.add(data);
        }
        menuAdapter = new MenuGridviewApater(this, dadaList);
        mGridViewMenu.setAdapter(menuAdapter);
        mGridViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //跳转收料界面
                    Intent intent = new Intent(MainActivity.this, ReceiveListActivity.class);
                    startActivity(intent);
                } else if (i == 1) {
                    //跳转品质检验界面
                    Intent intent = new Intent(MainActivity.this, CheckProListActivity.class);
                    startActivity(intent);
                } else if (i == 2) {
                    //跳转上架入库界面
                    Intent intent = new Intent(MainActivity.this, PutProListActivity.class);
                    startActivity(intent);
                } else if (i == 3) {
                    ToastUtils.showToast(MainActivity.this, "暂未开通");
                } else {

                    ToastUtils.showToast(MainActivity.this, "暂未开通");
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出应用",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            MyApplication.exit();
        }
    }
}
