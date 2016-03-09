package com.zhenmei.testanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 帧动画
 */
@SuppressWarnings("ALL")
public class FrameAnimaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anima);
        initView();
    }


    private ImageView ivFrame;
    private AnimationDrawable animationDrawable;

    private void initView() {
        ivFrame = (ImageView) findViewById(R.id.iv_frame);
        //设置背景
        ivFrame.setBackgroundResource(R.anim.component_tip_loading);
        //得到AnimationDrawable对象
        animationDrawable = (AnimationDrawable) ivFrame.getBackground();
        ivFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }else{
                    animationDrawable.start();
                }
            }
        });
    }


}
