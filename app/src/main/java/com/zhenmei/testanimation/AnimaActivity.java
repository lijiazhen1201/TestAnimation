package com.zhenmei.testanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimaActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private Button btnRotate;
    private Button btnScale;
    private Button btnAlpha;
    private Button btnTranslant;
    private Button btnAnima;
    private Button btnActivity;
    private ImageView ivImg;

    private void initView() {
        btnRotate = (Button) findViewById(R.id.btn_rotate);
        btnScale = (Button) findViewById(R.id.btn_scale);
        btnAlpha = (Button) findViewById(R.id.btn_alpha);
        btnTranslant = (Button) findViewById(R.id.btn_translant);
        btnAnima = (Button) findViewById(R.id.btn_anima);
        btnActivity = (Button) findViewById(R.id.btn_activity);
        ivImg = (ImageView) findViewById(R.id.iv_img);


        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnTranslant.setOnClickListener(this);
        btnAnima.setOnClickListener(this);
        btnActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ivImg.setImageResource(R.drawable.img_test);
        Animation animation = null;
        switch (v.getId()) {
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            case R.id.btn_alpha:
                animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;
            case R.id.btn_translant:
                animation = AnimationUtils.loadAnimation(this, R.anim.translant);
                break;
            case R.id.btn_anima:
                animation = AnimationUtils.loadAnimation(this, R.anim.anima);
                break;
            case R.id.btn_activity:

                break;
            default:
                break;
        }
        if (animation != null) {
            ivImg.startAnimation(animation);
        }
    }

}