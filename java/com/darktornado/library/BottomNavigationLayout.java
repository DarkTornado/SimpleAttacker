package com.darktornado.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomNavigationLayout extends FrameLayout {

    private Context ctx;
    private LinearLayout layout;
    private LinearLayout bottom;

    public BottomNavigationLayout(Context context) {
        super(context);
        init(context);
    }

    public BottomNavigationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context ctx){
        this.ctx = ctx;
        layout = new LinearLayout(ctx);
        layout.setOrientation(1);
        layout.setPadding(0, 0, 0, dip2px(50));
        super.addView(layout);
        bottom = new LinearLayout(ctx);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
        params.gravity = Gravity.BOTTOM;
        bottom.setLayoutParams(params);
        int pad = dip2px(3);
        bottom.setPadding(pad, pad, pad, pad);
        super.addView(bottom);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    public void setBottomBackgroundColor(int color){
        bottom.setBackgroundColor(color);
    }

    public void setBackgroundDrawable(Drawable drawable){
        bottom.setBackgroundDrawable(drawable);
    }

    public void setBackground(Drawable drawable){
        bottom.setBackground(drawable);
    }

    public void addBottomButton(String text, int res, Drawable drawable, View.OnClickListener listener) {
        if (drawable == null) drawable = new ColorDrawable(Color.TRANSPARENT);
        addBottomButton(text, res, drawable, listener, 12, Color.BLACK);
    }

    public void addBottomButton(String text, int res, Drawable drawable, View.OnClickListener listener, float size, int color){
        LinearLayout layout = new LinearLayout(ctx);
        layout.setOrientation(1);
        layout.setGravity(Gravity.CENTER);
        TextView img = new TextView(ctx);
        img.setText("");
        img.setBackgroundResource(res);
        img.setGravity(Gravity.CENTER);
        img.setLayoutParams(new LinearLayout.LayoutParams(dip2px(27), dip2px(27)));
        layout.addView(img);
        TextView txt = new TextView(ctx);
        txt.setText(text);
        txt.setTextSize(size);
        txt.setTextColor(color);
        txt.setGravity(Gravity.CENTER);
        layout.addView(txt);
        layout.setOnClickListener(listener);
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1));
        bottom.addView(layout);
        bottom.setWeightSum(bottom.getChildCount());
        layout.setBackgroundDrawable(drawable);
    }

    public void replace(View view){
        layout.removeAllViews();
        layout.addView(view);
    }

    public void replace(View view, Animation ani) {
        layout.removeAllViews();
        view.startAnimation(ani);
        layout.addView(view);
    }

    @Override
    public void addView(View view){
        layout.addView(view);
    }

    private int dip2px(int dips){
        return (int)Math.ceil(dips*ctx.getResources().getDisplayMetrics().density);
    }

}

