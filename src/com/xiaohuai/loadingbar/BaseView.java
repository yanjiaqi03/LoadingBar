package com.xiaohuai.loadingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseView extends View {
	private Rect mRect = new Rect(0, 0, 720, 1280);
	private float ratioX, ratioY;
	protected Boolean threadRun = false;
	protected Boolean endRun = false;
	private LogicThread mThread = null;

	public BaseView(Context context) {
		super(context);
	}

	public BaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		ratioX = this.getMeasuredWidth() * 1f / 720;
		ratioY = this.getMeasuredHeight() * 1f / 1280;
		
		reset();
	}

	protected abstract void drawSub(Rect mRect, Canvas canvas, float ratioX, float ratioY);

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		drawSub(mRect, canvas, ratioX, ratioY);
		if (mThread == null) {
			mThread = new LogicThread();
			mThread.start();
		}
	}

	protected abstract void logic();

	private class LogicThread extends Thread {
		@Override
		public void run() {
			while(endRun){
				while (threadRun) {
					logic();
					postInvalidate();
					try {
						SystemClock.sleep(30);
					} catch (Exception e) {

					}
				}
				try {
					SystemClock.sleep(30);
				} catch (Exception e) {

				}
			}
		}
	}

	public void setThreadRun(Boolean run) {
		threadRun = true;
		endRun = true;
		threadRun = run;
		invalidate();
	}
	
	protected abstract void reset();
	
	public void resetThread()
	{
		endRun = true;
		threadRun = true;
		mThread = null;
		reset();
		invalidate();
	}
	
	public void overThread(){
		threadRun = false;
		endRun = false;
		reset();
		invalidate();
	}
}
