package com.example.hdstv.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class RoundImageView extends AppCompatImageView {

    //定义画笔，消除锯齿
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //定义位图
    private Bitmap mBitmap;
    //图片渲染器，是shader渲染的子类，主要是对图片进行渲染的
    private BitmapShader bitmapShader;
    //定义矩阵，可以对矩阵内的图片进行缩放，渲染，裁剪，拉伸等操作
    private Matrix matrix = new Matrix();

    public RoundImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap nBitmap = getBitmap(getDrawable());
        if (nBitmap != null){
            int viewWidth = getWidth();
            int viewHeight = getHeight();
            int viewMinSize = Math.min(viewWidth, viewHeight);
            float destWidth = viewMinSize;
            float destHeight = viewHeight;
            if(bitmapShader == null || !nBitmap.equals(mBitmap)) {
                mBitmap = nBitmap;
                bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if (bitmapShader != null){
                matrix.setScale(destWidth / nBitmap.getWidth(), destHeight / nBitmap.getHeight());
                bitmapShader.setLocalMatrix(matrix);
            }
            paint.setShader(bitmapShader);
            float radius = viewMinSize / 2.0f;
            canvas.drawCircle(radius, radius, radius, paint);
        }else{
            super.onDraw(canvas);
        }
    }

    private Bitmap getBitmap(Drawable drawable){
        if(drawable instanceof BitmapDrawable){
            return ((BitmapDrawable) drawable).getBitmap();
        }
        else if (drawable instanceof ColorDrawable){
            //获取边界
            Rect rect = drawable.getBounds();
            int width = rect.right - rect.left;
            int height = rect.bottom - rect.top;
            //获取图片颜色
            int color = ((ColorDrawable) drawable).getColor();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
            return bitmap;
        }else {
            return null;
        }
    }
}
