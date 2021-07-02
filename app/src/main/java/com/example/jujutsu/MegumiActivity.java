package com.example.jujutsu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jujutsu.entity.Item;
import com.example.jujutsu.widget.CircleMenuLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MegumiActivity extends AppCompatActivity {
    private CircleMenuLayout circleMenuLayout;

    List<Item> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_megumi);
        //一条toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏标题
        toolbar.setNavigationIcon(R.drawable.ic_back);       //加载图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {   //为图标设置监听器
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //toolbar end
        circleMenuLayout = (CircleMenuLayout) findViewById(R.id.cm);

        Item item = new Item();
        item.imageRes = R.drawable.icezhenren;
        item.text = "虎杖";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade1fuhei;
        item.text = "伏黑";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade1dingqi;
        item.text = "钉崎";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade2goujuan;
        item.text = "狗卷";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade2zhenxi;
        item.text = "真希";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade2panda;
        item.text = "熊猫";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.teacherqihai;
        item.text = "七海";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.teacherwutiao;
        item.text = "五条";
        mList.add(item);


        circleMenuLayout.setAdapter(new MegumiActivity.MyAdapter());

        circleMenuLayout.setOnItemClickListener(new CircleMenuLayout.OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Toast.makeText(MegumiActivity.this, mList.get(position).text + "", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    public class  MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            View itemView = mInflater.inflate(R.layout.circle_menu_item, parent, false);
            initMenuItem(itemView, position);
            return itemView;
        }

        // 初始化菜单项
        private void initMenuItem(View itemView, int position) {
            // 获取数据项
            final Item item = (Item) getItem(position);
            ImageView iv = (ImageView) itemView
                    .findViewById(R.id.iv_icon);
            TextView tv = (TextView) itemView
                    .findViewById(R.id.tv_text);
            // 数据绑定
            iv.setImageResource(item.imageRes);
            tv.setText(item.text);
        }
    }
}
