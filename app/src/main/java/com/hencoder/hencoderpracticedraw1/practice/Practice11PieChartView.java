package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        float[] data = {0.01f, 0.05f, 0.02f, 0.15f, 0.25f, 0.4f, 0.12f};
        String[] name = {"Froyo", "Gingerbread", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow"};
        int[] color = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};

        int currentAngle = 0;
        for (int i = 0; i < data.length; i++) {
            int circleLeft, circleTop, circleX, circleY, radius;
            if (i == data.length - 2) {
                circleLeft = 180;
                circleTop = 30;
                circleX = 480;
                circleY = 330;
                radius = 300;
            } else {
                circleLeft = 200;
                circleTop = 50;
                circleX = 500;
                circleY = 350;
                radius = 300;
            }

            paint.setColor(color[i]);
            canvas.drawArc(circleLeft, circleTop, circleLeft + 2 * radius, circleTop + 2 * radius, currentAngle + 2, 360 * data[i] - 2, true, paint);

            currentAngle += 360 * data[i];

            int lineAngle = (int) (currentAngle - 360 * data[i] / 2);
            int x = (int) (radius * Math.cos(2 * Math.PI / 360 * lineAngle));
            int y = (int) (radius * Math.sin(2 * Math.PI / 360 * lineAngle));
            int endX = 20 * (lineAngle < 90 || lineAngle >= 270 ? 1 : -1);
            int endY = 20 * (lineAngle >= 0 && lineAngle < 180 ? 1 : -1);

            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(3);
            canvas.drawLine(circleX + x, circleY + y, circleX + x + endX, circleY + y + endY, paint);
            canvas.drawLine(circleX + x + endX, circleY + y + endY, (lineAngle < 90 || lineAngle >= 270) ? 850 : 120, circleY + y + endY, paint);

            paint.setTextSize(20);
            canvas.drawText(name[i], (lineAngle < 90 || lineAngle >= 270) ? 860 : (120 - name[i].length() * 10 - 10), circleY + y + endY, paint);
        }
    }
}
