package com.xiaohuai.loadingbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

public class HLoadingBar extends LinearLayout{
	private float density = 0f;
	public HLoadingBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		density = context.getResources().getDisplayMetrics().density;
		
		this.setPadding((int)(12*density), (int)(12*density), (int)(12*density), (int)(12*density));
		this.setGravity(Gravity.CENTER);
		this.setOrientation(LinearLayout.VERTICAL);
		this.addView(new HLoadingBarView(context), new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

}
