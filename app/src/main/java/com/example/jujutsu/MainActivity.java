package com.example.jujutsu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.navigation.NavigationView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView img_menuBtn;
    /**导航栏左侧的侧边栏的父容器*/
    private DrawerLayout mDrawerLayout;
    //导航视图
    private NavigationView mNavigationView;

    //轮播图
    private XBanner xBanner;
    private List<Integer> img_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();

        //轮播图
        xBanner = findViewById(R.id.xbanner);
        img_list.add(R.drawable.bwswiperfuhei);
        img_list.add(R.drawable.bwswiperwutiao);
        img_list.add(R.drawable.bwswiperdingqi);
        img_list.add(R.drawable.bwswiperqihai);
        img_list.add(R.drawable.bwswiperxiongmao);
        img_list.add(R.drawable.bwswiperzhenre);
        img_list.add(R.drawable.bwswiperzhenxi);
        img_list.add(R.drawable.bwswipersanlun);
        img_list.add(R.drawable.bwswiperxiayou);
        img_list.add(R.drawable.bwswipersunuo);

//        img_list.add(R.drawable.swiper11);
//        img_list.add(R.drawable.swiper12);
//        img_list.add(R.drawable.swiper13);

        xBanner.setData(img_list,null);

        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                banner.setPageChangeDuration(1000);
                RequestOptions myOptions = new RequestOptions()
                        .transform(new GlideRoundTransform(MainActivity.this,10));

                Glide
                        .with(MainActivity.this)
                        .load(img_list.get(position))
                        .apply(myOptions)
                        .into((ImageView) view);


            }
        });
        // XBanner中某一项的点击事件
        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Intent detailIntent;
                switch (position){
                    case 0:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "伏黑");
                        startActivity(detailIntent);
                        break;
                    case 1:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "五条");
                        startActivity(detailIntent);
                        break;
                    case 2:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "钉崎");
                        startActivity(detailIntent);
                        break;
                    case 3:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "七海");
                        startActivity(detailIntent);
                        break;
                    case 4:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "熊猫");
                        startActivity(detailIntent);
                        break;
                    case 5:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "真人");
                        startActivity(detailIntent);
                        break;
                    case 6:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "真希");
                        startActivity(detailIntent);
                        break;
                    case 7:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "三轮");
                        startActivity(detailIntent);
                        break;
                    case 8:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "夏油");
                        startActivity(detailIntent);
                        break;
                    case 9:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "宿傩");
                        startActivity(detailIntent);
                        break;
                }
//                Toast.makeText(MainActivity.this, "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
        //轮播图end

        //圆角矩形！！！
//        ImageView pic1 = findViewById(R.id.pic1);
        ImageView dongjingxiao = findViewById(R.id.dongjingxiao);
        ImageView jingduxiao = findViewById(R.id.jingduxiao);
        ImageView fanpaijuese = findViewById(R.id.fanpaijuese);

//        Drawable drawable1 = getResources().getDrawable(R.drawable.picture1);
//        BitmapDrawable bitmapDrawable1 = (BitmapDrawable) drawable1;
//        Bitmap bitmap1 = bitmapDrawable1.getBitmap();


        Drawable drawable2 = getResources().getDrawable(R.drawable.bwjingduxiao);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) drawable2;
        Bitmap bitmap2 = bitmapDrawable2.getBitmap();

        Drawable drawable3 = getResources().getDrawable(R.drawable.bwfanpaijuese);
        BitmapDrawable bitmapDrawable3 = (BitmapDrawable) drawable3;
        Bitmap bitmap3 = bitmapDrawable3.getBitmap();

        Drawable drawable4 = getResources().getDrawable(R.drawable.bwdongjingxiao);
        BitmapDrawable bitmapDrawable4 = (BitmapDrawable) drawable4;
        Bitmap bitmap4 = bitmapDrawable4.getBitmap();


//        pic1.setImageBitmap(roundBitmapByXfermode(bitmap1,1000,600, 50));
        jingduxiao.setImageBitmap(roundBitmapByXfermode(bitmap2,1000,600, 50));
        fanpaijuese.setImageBitmap(roundBitmapByXfermode(bitmap3,1000,600, 50));
        dongjingxiao.setImageBitmap(roundBitmapByXfermode(bitmap4,1000,600, 50));
        //圆角矩形end
    }

    //圆角矩形函数
    private Bitmap roundBitmapByXfermode(Bitmap bitmap, int outWidth, int outHeight, int radius) {
        if(bitmap == null) {
            throw new NullPointerException("Bitmap can't be null");
        }

        // 等比例缩放拉伸
        float widthScale = outWidth * 1.0f / bitmap.getWidth();
        float heightScale = outHeight * 1.0f / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(widthScale, heightScale);
        Bitmap newBt = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        // 初始化目标bitmap
        Bitmap targetBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        canvas.drawARGB(0, 0, 0, 0);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        RectF rectF = new RectF(0f, 0f, (float) outWidth, (float) outHeight);

        // 在画布上绘制圆角图
        canvas.drawRoundRect(rectF, radius, radius, paint);

        // 设置叠加模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // 在画布上绘制原图片
        Rect ret = new Rect(0, 0, outWidth, outHeight);
        canvas.drawBitmap(newBt, ret, ret, paint);

        return targetBitmap;
    }
    //圆角矩形函数end

    //轮播图所需函数
    @Override
    protected void onResume() {
        super.onResume();
        xBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        xBanner.stopAutoPlay();
    }

    //轮播图所需函数end

    //侧边栏所需函数

    /**
     * 初始化视图
     * */
    private void initViews() {
        // 侧滑视图
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mNavigationView = findViewById(R.id.nav_view);

        // 侧滑按钮
        img_menuBtn = findViewById(R.id.img_menuBtn);
        meunClick();
        mNavigationView.setItemIconTintList(null);
    }


    /**
     * 侧滑按钮点击事件
     * */
    private void meunClick(){
        //用户图标的点击事件
        img_menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    /**
     * 侧滑栏点击事件
     * */
    private void initEvents() {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent detailIntent;
                switch(item.getItemId()){
                    case R.id.menu1:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "伏黑");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu2:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "虎杖");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu3:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "五条");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu4:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "狗卷");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu5:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "钉崎");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu6:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "宿傩");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu7:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "七海");
                        startActivity(detailIntent);
                        break;
                    case R.id.menu8:
                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
                        detailIntent.putExtra("title", "夏油");
                        startActivity(detailIntent);
                        break;
//                    case R.id.menu9:
//                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
//                        detailIntent.putExtra("title", "东堂");
//                        startActivity(detailIntent);
//                        break;
//                    case R.id.menu10:
//                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
//                        detailIntent.putExtra("title", "三轮");
//                        startActivity(detailIntent);
//                        break;
//                    case R.id.menu11:
//                        detailIntent = new Intent(MainActivity.this, PersonDetailActivity.class);
//                        detailIntent.putExtra("title", "真依");
//                        startActivity(detailIntent);
//                        break;
                }
                //关闭侧滑菜单
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


//    public void setItemIconTintList(@Nullable ColorStateList tint) {
//        mPresenter.setItemIconTintList(tint);
//    }

    //侧边栏所需函数end

    public void launchmegumi(View view) {
        Intent intent = new Intent(this, MegumiActivity.class);
        startActivity(intent);
    }

    public void launchactivity2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void launchactivity3(View view) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    public void launchactivity4(View view) {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void launchactivity5(View view) {
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }

}