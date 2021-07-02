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

public class DetailActivity2 extends AppCompatActivity {

    private CircleMenuLayout circleMenuLayout;

    List<Item> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
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
        item.imageRes = R.drawable.grade3dongtang;
        item.text = "东堂";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade2zhenyi;
        item.text = "真依";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade2jixiewan;
        item.text = "机械丸";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade3jiamao;
        item.text = "加茂";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade3xigong;
        item.text = "西宫";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.grade2sanlun;
        item.text = "三轮";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.teacherleyansi;
        item.text = "乐岩寺";
        mList.add(item);
        item = new Item();
        item.imageRes = R.drawable.teachergeji;
        item.text = "歌姬";
        mList.add(item);


        circleMenuLayout.setAdapter(new DetailActivity2.MyAdapter());

        circleMenuLayout.setOnItemClickListener(new CircleMenuLayout.OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Intent detailIntent = new Intent(DetailActivity2.this, PersonDetailActivity.class);
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
