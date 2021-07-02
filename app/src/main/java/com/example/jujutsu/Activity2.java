package com.example.jujutsu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

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
        //圆角矩形！！！
        ImageView pic1 = findViewById(R.id.pic1);
        ImageView pic2 = findViewById(R.id.pic2);
        ImageView pic4 = findViewById(R.id.pic3);

        Drawable drawable1 = getResources().getDrawable(R.drawable.bwjingdugrade1);
        BitmapDrawable bitmapDrawable1 = (BitmapDrawable) drawable1;
        Bitmap bitmap1 = bitmapDrawable1.getBitmap();


        Drawable drawable2 = getResources().getDrawable(R.drawable.bwjingdugrade2);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) drawable2;
        Bitmap bitmap2 = bitmapDrawable2.getBitmap();


        Drawable drawable3 = getResources().getDrawable(R.drawable.bwdongjingteacher);
        BitmapDrawable bitmapDrawable3 = (BitmapDrawable) drawable3;
        Bitmap bitmap3 = bitmapDrawable3.getBitmap();


        pic1.setImageBitmap(roundBitmapByXfermode(bitmap1,1000,600, 50));
        pic2.setImageBitmap(roundBitmapByXfermode(bitmap2,1000,600, 50));
        pic4.setImageBitmap(roundBitmapByXfermode(bitmap3,1000,600, 50));
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

    public void launchdetail(View view) {
        Intent intent = new Intent(this, DetailActivity2.class);
        startActivity(intent);
    }
    //圆角矩形函数end


}