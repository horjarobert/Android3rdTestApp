package com.stufflex.digimotion;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    // Declarations
    private TextView txt_b, txt_y, txt_s, txt_t, txt_u, txt_f1, txt_f2, txt_l, txt_e, txt_x;
    private ImageView img_logo;
    private Animation anim_txt_b, anim_txt_y, anim_txt_s, anim_txt_t, anim_txt_u, anim_txt_f1, anim_txt_f2, anim_txt_l, anim_txt_e, anim_txt_x;
    private Handler handler_the_special_one;
    private Runnable runnable_the_special_one;
    private Boolean isTheSpecialOneON = false;
    private ConstraintLayout goingOutLayout;
    private Animator scaleDown_img_logo, scaleUp_img_logo, getScaleDown_img_logo_reverse, getScaleUp_img_logo_reverse;
    private AnimatorSet setDownAndUp_img_logo, setDownAndUp_img_logo_reverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Navbar-fullscreen
        hideNavigationBar();

        // Initializations
        txt_b = findViewById(R.id.txt_b);
        txt_y = findViewById(R.id.txt_y);
        txt_s = findViewById(R.id.txt_s);
        txt_t = findViewById(R.id.txt_t);
        txt_u = findViewById(R.id.txt_u);
        txt_f1 = findViewById(R.id.txt_f1);
        txt_f2 = findViewById(R.id.txt_f2);
        txt_l = findViewById(R.id.txt_l);
        txt_e = findViewById(R.id.txt_e);
        txt_x = findViewById(R.id.txt_x);

        img_logo = findViewById(R.id.img_logo);

        goingOutLayout = findViewById(R.id.goingOutLayout);

        // Set them invisible
        img_logo.setVisibility(View.INVISIBLE);
        txt_s.setVisibility(View.INVISIBLE);
        txt_t.setVisibility(View.INVISIBLE);
        txt_u.setVisibility(View.INVISIBLE);
        txt_f1.setVisibility(View.INVISIBLE);
        txt_f2.setVisibility(View.INVISIBLE);
        txt_l.setVisibility(View.INVISIBLE);
        txt_e.setVisibility(View.INVISIBLE);
        txt_x.setVisibility(View.INVISIBLE);

        // Set animations
        anim_txt_b = AnimationUtils.loadAnimation(this, R.anim.anim_txt_b);
        anim_txt_y = AnimationUtils.loadAnimation(this, R.anim.anim_txt_y);
        anim_txt_s = AnimationUtils.loadAnimation(this, R.anim.anim_txt_s);
        anim_txt_t = AnimationUtils.loadAnimation(this, R.anim.anim_txt_up);
        anim_txt_u = AnimationUtils.loadAnimation(this, R.anim.anim_txt_down);
        anim_txt_f1 = AnimationUtils.loadAnimation(this, R.anim.anim_txt_up);
        anim_txt_f2 = AnimationUtils.loadAnimation(this, R.anim.anim_txt_down);
        anim_txt_l = AnimationUtils.loadAnimation(this, R.anim.anim_txt_up);
        anim_txt_e = AnimationUtils.loadAnimation(this, R.anim.anim_txt_down);
        anim_txt_x = AnimationUtils.loadAnimation(this, R.anim.anim_txt_x);

        txt_b.setAnimation(anim_txt_b);
        txt_y.setAnimation(anim_txt_y);

        // Special guest | Animation for img_logo
        scaleDown_img_logo = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_img_logo.setTarget(img_logo);

        scaleUp_img_logo = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_img_logo = new AnimatorSet();
        setDownAndUp_img_logo.playSequentially(scaleDown_img_logo, scaleUp_img_logo);

        // Special guest | Animation for img_logo | REVERSE
        getScaleDown_img_logo_reverse = AnimatorInflater.loadAnimator(this, R.animator.scale_down);

        getScaleUp_img_logo_reverse = AnimatorInflater.loadAnimator(this, R.animator.scale_up);
        getScaleUp_img_logo_reverse.setTarget(img_logo);

        setDownAndUp_img_logo_reverse = new AnimatorSet();
        setDownAndUp_img_logo_reverse.playSequentially(getScaleDown_img_logo_reverse, getScaleUp_img_logo_reverse);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_s.setVisibility(View.VISIBLE);
                txt_s.setAnimation(anim_txt_s);
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_t.setVisibility(View.VISIBLE);
                txt_t.setAnimation(anim_txt_t);
            }
        }, 600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_u.setVisibility(View.VISIBLE);
                txt_u.setAnimation(anim_txt_u);
            }
        }, 700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_f1.setVisibility(View.VISIBLE);
                txt_f1.setAnimation(anim_txt_f1);
            }
        }, 800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_f2.setVisibility(View.VISIBLE);
                txt_f2.setAnimation(anim_txt_f2);
            }
        }, 900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_l.setVisibility(View.VISIBLE);
                txt_l.setAnimation(anim_txt_l);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_e.setVisibility(View.VISIBLE);
                txt_e.setAnimation(anim_txt_e);
            }
        }, 1100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_x.setVisibility(View.VISIBLE);
                txt_x.setAnimation(anim_txt_x);
            }
        }, 1200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img_logo.setVisibility(View.VISIBLE);
                setDownAndUp_img_logo.start();
            }
        }, 2200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setDownAndUp_img_logo_reverse.start();
            }
        }, 3200);

        handler_the_special_one = new Handler();
        runnable_the_special_one = new Runnable() {
            @Override
            public void run() {
                Intent goingOut = new Intent(SplashScreenActivity.this, MainActivity.class);
                SplashScreenActivity.this.startActivity(goingOut);
                SplashScreenActivity.this.finish();
            }
        };
        handler_the_special_one.postDelayed(runnable_the_special_one, 4000);

        goingOutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isTheSpecialOneON = true;
                if (isTheSpecialOneON) {
                    handler_the_special_one.removeCallbacksAndMessages(null);
                    GoingOut();
                }
            }
        });

    }

    // Hide the navigation bar and make the entire app full-screen
    private void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

    // When I exit for a moment from the app and I'll come back, the same effect must be continue
    @Override
    protected void onResume() {
        super.onResume();

        hideNavigationBar();
    }

    public void GoingOut() {
        Intent goingOut = new Intent(SplashScreenActivity.this, MainActivity.class);
        SplashScreenActivity.this.startActivity(goingOut);
        SplashScreenActivity.this.finish();
    }
}