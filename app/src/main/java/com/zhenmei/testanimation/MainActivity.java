package com.zhenmei.testanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 动画练习，在代码中实现动画
 */
public class MainActivity extends Activity implements View.OnClickListener {

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
        switch (v.getId()) {
            case R.id.btn_rotate:
                initRotateAnima();
                break;
            case R.id.btn_scale:
                initScalAnima();
                break;
            case R.id.btn_alpha:
                initAlphaAnima();
                break;
            case R.id.btn_translant:
                initTranslantAnima();
                break;
            case R.id.btn_anima:
                initAnima();
                break;
            case R.id.btn_activity:
                startActivity(new Intent(this,AnimaActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 旋转动画
     */
    private void initRotateAnima() {
        /**
         * 创建一个AnimationSet对象，参数为Boolean型，
         * true表示使用Animation的interpolator，false则是使用自己的
         */
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 创建一个RotateAnimation，接收6个参数
         * 参数1：从哪个角度开始旋转
         * 参数2：旋转转到什么角度
         * 后4个参数用于设置围绕着旋转的圆的圆心在哪里
         * 参数3：确定x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
         * 参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
         * 参数5：确定y轴坐标的类型
         * 参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
         */
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        /**
         * 设置动画执行的时间
         */
        rotateAnimation.setDuration(3000);
//        /**
//         *如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态
//         */
//        rotateAnimation.setFillAfter(true);
//        /**
//         * 如果fillBefore的值为true，则动画执行后，控件将回到动画执行之前的状态
//         */
//        rotateAnimation.setFillBefore(true);
//        /**
//         * 设置动画执行之前的等待时间
//         */
//        rotateAnimation.setStartOffset(3000);
//        /**
//         * 设置动画重复执行的次数
//         */
//        rotateAnimation.setRepeatCount(3);
        /**
         * 将动画放进AnimationSet中
         */
        animationSet.addAnimation(rotateAnimation);
        /**
         * 控件开启动画
         */
        ivImg.startAnimation(animationSet);
    }

    /**
     * 缩放动画
     */
    private void initScalAnima() {
        /**
         * 创建一个AnimationSet对象，参数为Boolean型，
         * true表示使用Animation的interpolator，false则是使用自己的
         */
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 创建一个ScaleAnimation，接收8个参数
         * 参数1：x轴的初始值
         * 参数2：x轴缩放后的值
         * 参数3：y轴的初始值
         * 参数4：y轴缩放后的值
         * 参数5：确定x轴坐标的类型
         * 参数6：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
         * 参数7：确定y轴坐标的类型
         * 参数8：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        /**
         * 设置动画执行的时间
         */
        scaleAnimation.setDuration(3000);
        /**
         * 将动画放进AnimationSet中
         */
        animationSet.addAnimation(scaleAnimation);
        /**
         * 控件开启动画
         */
        ivImg.startAnimation(animationSet);
    }

    /**
     * 渐变动画，淡入淡出
     */
    private void initAlphaAnima() {
        /**
         * 创建一个AnimationSet对象，参数为Boolean型，
         * true表示使用Animation的interpolator，false则是使用自己的
         */
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 创建一个AlphaAnimation，接收2个参数
         * 1代表不透明
         * 0代表全透明
         * 参数1：动画开始的透明度
         * 参数2：动画结束的透明度
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        /**
         * 设置动画执行的时间
         */
        alphaAnimation.setDuration(3000);
        /**
         * 将动画放进AnimationSet中
         */
        animationSet.addAnimation(alphaAnimation);
        /**
         * 控件开启动画
         */
        ivImg.startAnimation(animationSet);
    }

    /**
     * 移动动画
     */
    private void initTranslantAnima() {
        /**
         * 创建一个AnimationSet对象，参数为Boolean型，
         * true表示使用Animation的interpolator，false则是使用自己的
         */
        AnimationSet animationSet = new AnimationSet(true);
        /**
         * 创建一个TranslateAnimation，接收8个参数
         * 参数1～2：x轴的开始位置
         * 参数3～4：y轴的开始位置
         * 参数5～6：x轴的结束位置
         * 参数7～8：y轴的结束位置
         */
        TranslateAnimation translateAnimation =
                new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
        /**
         * 设置动画执行的时间
         */
        translateAnimation.setDuration(3000);
        /**
         * 将动画放进AnimationSet中
         */
        animationSet.addAnimation(translateAnimation);
        /**
         * 控件开启动画
         */
        ivImg.startAnimation(animationSet);
    }

    /**
     * 旋转+缩放+渐变
     */
    private void initAnima() {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        animationSet.addAnimation(alphaAnimation);
        ivImg.startAnimation(animationSet);
    }
}
