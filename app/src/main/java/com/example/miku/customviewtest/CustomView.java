package com.example.miku.customviewtest;

import android.content.Context;
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
            result = 200;
            if (Mode == MeasureSpec.AT_MOST) {
                result = Math.min(200, Size);
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
            result = 200;
            if (Mode == MeasureSpec.AT_MOST) {
                result = Math.min(result, Size);
            }
        }
        return result;
    }
}
