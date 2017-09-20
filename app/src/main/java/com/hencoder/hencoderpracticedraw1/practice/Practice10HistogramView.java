package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);

        int originX = 100, originY = 600;
        int spaceOffset = 20, rectWidth = 100;

        canvas.drawLine(originX, spaceOffset, originX, originY, paint);
        canvas.drawLine(originX, originY, 960, originY, paint);

        int[] data = {1, 10, 10, 100, 170, 210, 90};
        String[] name = {"Froyo", "GB", "ICB", "JB", "KitKat", "L", "M"};

        for (int i = 0; i < data.length; i++) {
            int left = originX + spaceOffset * (i + 1) + rectWidth * i;
            int top = originY - data[i];

            paint.setColor(Color.GREEN);
            canvas.drawRect(left, top, left + rectWidth, originY, paint);

            int textSize = 20;
            paint.setTextSize(textSize);
            paint.setColor(Color.WHITE);
            canvas.drawText(name[i], left + (10 - name[i].length()) / 2 * textSize / 2, originY + 20, paint);
        }
    }
}
