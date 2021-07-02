package com.example.jujutsu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jujutsu.entity.Item;
import com.example.jujutsu.widget.CircleMenuLayout;

import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    private CircleMenuLayout circleMenuLayout;

    List<Item> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
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
        item.imageRes = R.drawable.huayu;
        item.text = "花御";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.zhenren;
        item.text = "真人";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.louhu;
        item.text = "漏瑚";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.xiayou;
        item.text = "夏油";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.xiongdi;
        item.text = "九相图";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.tuotuo;
        item.text = "陀艮";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.teacherqihai;
        item.text = "宿傩";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.rouzao;
        item.text = "鞣造";
        mList.add(item);


        circleMenuLayout.setAdapter(new Activity3.MyAdapter());

        circleMenuLayout.setOnItemClickListener(new CircleMenuLayout.OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Intent detailIntent = new Intent(Activity3.this, PersonDetailActivity.class);
                detailIntent.putExtra("title", mList.get(position).text);
                startActivity(detailIntent);
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
