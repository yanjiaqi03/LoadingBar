package com.xiaohuai.loadingbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;

public class HLoadingBarView extends BaseView {
	private RectF mRectF = new RectF(0f, 0f, 0f, 0f);
	private float width = 500f;
	private float height = 160f;
	private Paint mPaint = null;
	private int number = 4;
	private float centerX, centerY;
	private float radius = 0f;

	private float radius_anim = 0f;
	private Boolean runFlag = true;
	private int radiusK = -1;
	private int changeFlag = 0;

	public HLoadingBarView(Context context) {
		super(context);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaint.setColor(0xffd2d2d2);
		setNumber(8);
	}

	private void setNumber(int number) {
		this.number = number;
		invalidate();
	}

	private void setRadius(float radius) {
		this.radius = radius;
		invalidate();
	}

	@Override
	protected void drawSub(Rect mRect, Canvas canvas, float ratioX, float ratioY) {
		width = mRect.width()*ratioX / 4f;
		height = width/3;
		mRectF.left = (mRect.width() / 2f * ratioX - width) / 2;
		mRectF.right = (mRect.width() / 2f * ratioX - width) / 2 + width;
		mRectF.top = (mRect.height() * ratioY - height) / 2;
		mRectF.bottom = (mRect.height() * ratioY - height) / 2 + height;
		centerX = mRect.width() * ratioX / 2;
		centerY = mRect.height() * ratioY / 2;
		switch (number) {
		case -8:
			canvas.save();
			mPaint.setAlpha(55);
			canvas.rotate(315f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -7:
			canvas.save();
			mPaint.setAlpha(80);
			canvas.rotate(270f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -6:
			canvas.save();
			mPaint.setAlpha(105);
			canvas.rotate(225f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -5:
			canvas.save();
			mPaint.setAlpha(130);
			canvas.rotate(180f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -4:
			canvas.save();
			mPaint.setAlpha(155);
			canvas.rotate(135f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -3:
			canvas.save();
			mPaint.setAlpha(180);
			canvas.rotate(90f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -2:
			canvas.save();
			mPaint.setAlpha(205);
			canvas.rotate(45f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case -1:
			canvas.save();
			mPaint.setAlpha(230);
			canvas.rotate(0f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
			break;
		case 8:
			canvas.save();
			mPaint.setAlpha(55);
			canvas.rotate(-315f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 7:
			canvas.save();
			mPaint.setAlpha(80);
			canvas.rotate(-270f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 6:
			canvas.save();
			mPaint.setAlpha(105);
			canvas.rotate(-225f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 5:
			canvas.save();
			mPaint.setAlpha(130);
			canvas.rotate(-180f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 4:
			canvas.save();
			mPaint.setAlpha(155);
			canvas.rotate(-135f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 3:
			canvas.save();
			mPaint.setAlpha(180);
			canvas.rotate(-90f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 2:
			canvas.save();
			mPaint.setAlpha(205);
			canvas.rotate(-45f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
		case 1:
			canvas.save();
			mPaint.setAlpha(230);
			canvas.rotate(0f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
			break;
		case 0:
			canvas.save();
			mPaint.setAlpha(255);
			canvas.rotate(0f, centerX, centerY);
			canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
			canvas.restore();
			break;
		default:
			break;
		}
		canvas.save();
		switch (number) {
		case 0:
			mPaint.setAlpha(230);
			break;
		case 1:
			mPaint.setAlpha(205);
			break;
		case -1:
			mPaint.setAlpha(205);
			break;
		case 2:
			mPaint.setAlpha(180);
			break;
		case -2:
			mPaint.setAlpha(180);
			break;
		case 3:
			mPaint.setAlpha(155);
			break;
		case -3:
			mPaint.setAlpha(155);
			break;
		case 4:
			mPaint.setAlpha(130);
			break;
		case -4:
			mPaint.setAlpha(130);
			break;
		case 5:
			mPaint.setAlpha(105);
			break;
		case -5:
			mPaint.setAlpha(105);
			break;
		case 6:
			mPaint.setAlpha(80);
			break;
		case -6:
			mPaint.setAlpha(80);
			break;
		case 7:
			mPaint.setAlpha(55);
			break;
		case -7:
			mPaint.setAlpha(55);
			break;
		case 8:
			mPaint.setAlpha(0);
			break;
		case -8:
			mPaint.setAlpha(0);
			break;
		default:
			mPaint.setAlpha(0);
			break;
		}
		canvas.rotate(-radius, centerX, centerY);
		canvas.drawRoundRect(mRectF, height / 2, height / 2, mPaint);
		canvas.restore();
	}

	@Override
	protected void logic() {

	}

	@Override
	protected void reset() {

	}

	private void loading() {
		ValueAnimator rotateAnim = ValueAnimator.ofFloat(0f, 359f);
		rotateAnim.setDuration(1500);
		rotateAnim.setInterpolator(new AccelerateDecelerateInterpolator());
		rotateAnim.setRepeatCount(-1);
		rotateAnim.setRepeatMode(Animation.REVERSE);
		rotateAnim.start();
		rotateAnim.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {
				runFlag = true;
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				changeFlag++;
				if (changeFlag % 2 == 0) {
					changeFlag = 0;
					runFlag = true;
				}
			}

			@Override
			public void onAnimationEnd(Animator animation) {

			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}
		});
		rotateAnim.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				radius_anim = (Float) animation.getAnimatedValue();
				if (runFlag) {
					if (radiusK == 1) {
						radiusK = -1;
					} else if (radiusK == -1) {
						radiusK = 1;
					}
					runFlag = false;
				}

				setRotation(radius_anim * radiusK);
				if ((int) radius_anim / 45 < 9 && (int) radius_anim / 45 > -9) {
					setRadius(radius_anim * radiusK);
				}
				if (radiusK == 1) {
					setNumber((int) radius_anim / 45 + 1);
				} else if (radiusK == -1) {
					setNumber(-(int) radius_anim / 45 - 1);
				}
			}
		});
	}
	
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		loading();
	}
	
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		clearAnimation();
	}
}
