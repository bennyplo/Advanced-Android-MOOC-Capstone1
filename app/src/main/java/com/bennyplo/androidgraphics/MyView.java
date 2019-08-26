package com.bennyplo.androidgraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by benlo on 26/08/2019.
 */

public class MyView extends View {
    private Paint redPaint;
    private int viewheight,viewwidth;//screen dimension
    public MyView(Context context) {
        super(context, null);
        //Add your initialisation code here
        redPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        redPaint.setColor(0xffff0000);//color red
        redPaint.setStrokeWidth(5);//set the line stroke width to 5

        //find the screen size
        viewheight = getResources().getDisplayMetrics().heightPixels - 70;//70 is the bottom control
        viewwidth = getResources().getDisplayMetrics().widthPixels;

        int ecg_data[]={1539,1531,1547,1539,1543,1531,1575,1591,1543,1539,1523,1539,1543,1539,1859,2587,1455,1539,1523,1527,1543,1587,1619,1635,1655,1659,1639,1639,1579,1547,1527,1527,1547,1543,1551,1547,1547,1563,1539,1527,1523,1543,1539,1575,1599,1555,1531,1539,1551,1547,1487,1995,2331,1563,1539,1523,1563,1559,1591,1615,1635,1659,1651,1675,1631,1567,1531,1519,1527,1511,1531,1527,1539,1539,1527,1539,1543,1547,1547,1571,1603,1571,1539,1551,1547,1559,1487,1927,2475,1491,1531,1503,1551,1559,1571,1599,1623,1663,1659,1659,1615,1547,1519,1519,1511,1523,1539,1543,1551,1567,1563,1551,1555,1547,1587,1579,1567,1559,1539,1559,1555,1563};
        Timer timer=new Timer();
        final MyView thisview=this;
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
              //add your rotation functions here to spin the virtual objects
                thisview.invalidate();//update the view
            }
        };
        timer.scheduleAtFixedRate(task,1000,100);

    }

      @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Add your drawing code here
        canvas.drawRect(0,0,600,600,redPaint);
    }
}
