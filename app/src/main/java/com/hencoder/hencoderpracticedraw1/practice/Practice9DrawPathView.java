package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.STROKE);

//        练习内容：使用 canvas.drawPath() 方法画心形
        path.addArc(0, 0, 200, 200, -220, 220);
        path.arcTo(200, 0, 400, 200, -180, 220, false);
        path.lineTo(200, 400);
        path.close();

        canvas.drawPath(path, paint);
    }
}
