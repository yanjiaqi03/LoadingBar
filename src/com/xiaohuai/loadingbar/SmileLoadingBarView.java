package com.xiaohuai.loadingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class SmileLoadingBarView extends BaseView{
	private Paint mPaint = null;
	private final int speed = 5;
	private float circleRadius = 0f;
	private float rotate = 0f;
	private int valueFlag = speed;
	private float centerX = 0f;
	private float centerY = 0f;
	private RectF arcRect = new RectF(0f, 0f, 0f, 0f);
	
	public SmileLoadingBarView(Context context) {
		super(context);
		
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaint.setColor(0xffd2d2d2);
		
		setThreadRun();
	}

	@Override
	protected void drawSub(Rect mRect, Canvas canvas, float ratioX, float ratioY) {
		circleRadius = Math.min(mRect.width()/2 * ratioX, mRect.height()/2 * ratioY)/5;
		centerX = mRect.width()/2 * ratioX;
		centerY =  mRect.height()/2 * ratioY;
		arcRect.left = mRect.left *ratioX + circleRadius;
		arcRect.right = mRect.right*ratioX  - circleRadius;
		arcRect.top = mRect.top*ratioY + circleRadius;
		arcRect.bottom = mRect.bottom*ratioY - circleRadius;		
		
		canvas.save();
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaint.setStrokeWidth(0f);
		mPaint.setAlpha(255);
		canvas.rotate(rotate,centerX,centerY);
		canvas.drawCircle(centerX, mRect.height()*ratioY - circleRadius, circleRadius, mPaint);
		canvas.restore();
		
		canvas.save();
		canvas.rotate(0f,centerX,centerY);
		mPaint.setAlpha(Math.abs((int)(rotate))*255/60);
		canvas.drawCircle(mRect.width()/4*ratioX, mRect.height()/4*ratioY, circleRadius, mPaint);
		mPaint.setAlpha(255-Math.abs((int)(rotate))*255/60);
		canvas.drawCircle(mRect.width()/4*3*ratioX, mRect.height()/4*ratioY, circleRadius, mPaint);
		canvas.restore();
		
		canvas.save();
		canvas.rotate(0f,centerX,centerY);
		mPaint.setAlpha(Math.abs((int)(rotate))*255/60);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(circleRadius/2);
		canvas.drawArc(arcRect, 30f, 120f, false, mPaint);
		canvas.restore();
		
	}

	@Override
	protected void logic() {
		rotate += valueFlag;
		if(rotate>=60f){
			valueFlag = -1*speed;
		}else if(rotate<=-60){
			valueFlag = speed;
		}
		Log.i("Jiaqi", "rotate = " + rotate);
	}

	@Override
	protected void reset() {
		rotate = 0;
	}
	
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		overThread();
	}
}
