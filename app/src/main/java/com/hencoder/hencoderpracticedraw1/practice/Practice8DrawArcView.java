package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(350, 200, 700, 400, -180, 50, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(350, 200, 700, 400, -110, 100, true, paint);

        canvas.drawArc(350, 200, 700, 400, 10, 150, false, paint);
    }
}
