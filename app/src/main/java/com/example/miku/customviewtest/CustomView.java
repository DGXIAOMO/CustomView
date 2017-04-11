package com.example.miku.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by miku on 2017/4/10.
 */
public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        // 画基线
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4f);
        canvas.drawLine(0,200,500,200,paint);
        //  注意使用canvas.save()以及canvas.restore()来保存画布status.
        //写文字
        paint.setColor(Color.BLUE);
        paint.setTextSize(40);
        canvas.drawText("Hello World",100,200,paint);
         //画圆
         paint.setColor(Color.YELLOW);
         paint.setStyle(Paint.Style.FILL);
         canvas.drawCircle(100,300,100,paint);
        //平移
         canvas.save();
         canvas.translate(100,0);
         paint.setColor(Color.RED);
         canvas.drawCircle(100,300,100,paint);
        //画矩形
        canvas.restore();
        paint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        canvas.drawRect(new RectF(0, 400, 300, 500), paint);
        //缩放
        canvas.save();
        canvas.scale(0.5f, 1, 0, 400f);
        paint.setColor(Color.RED);
        canvas.drawRect(new RectF(0, 400, 300, 500), paint);
        //利用path画三角，旋转
        canvas.restore();
        Path path = new Path();
        //canvas.drawColor(Color.WHITE);
        // path.moveTo(450,200);
        paint.setStrokeWidth(10f);
        path.lineTo(200,200);
        canvas.drawPath(path,paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureWidth(widthMeasureSpec), MeasureHeigh(heightMeasureSpec));
    }

    private int MeasureWidth(int measurespec) {
        int result = 0;
        int Mode = MeasureSpec.getMode(measurespec);
        //注意这里获取的大小单位为px
        int Size = MeasureSpec.getSize(measurespec);
        if (Mode == MeasureSpec.EXACTLY) {
            result = Size;
        } else {
            result = 600;
            if (Mode == MeasureSpec.AT_MOST) {
                result = Math.min(600, Size);
            }
        }
        return result;
    }

    private int MeasureHeigh(int measurespec) {
        int result=0;
        int Mode = MeasureSpec.getMode(measurespec);
        int Size = MeasureSpec.getSize(measurespec);
        if (Mode == MeasureSpec.EXACTLY) {
            result = Size;
        } else {
            result = 600;
            if (Mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, Size);
            }
        }
        return result;
    }
}
