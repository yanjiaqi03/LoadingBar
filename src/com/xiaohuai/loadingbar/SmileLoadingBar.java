package com.xiaohuai.loadingbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

public class SmileLoadingBar extends LinearLayout{
	private float density = 0f;
	public SmileLoadingBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		density = context.getResources().getDisplayMetrics().density;
		
		this.setPadding((int)(15*density), (int)(15*density), (int)(15*density), (int)(15*density));
		this.setGravity(Gravity.CENTER);
		this.setOrientation(LinearLayout.VERTICAL);
		this.addView(new SmileLoadingBarView(context), new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

}
