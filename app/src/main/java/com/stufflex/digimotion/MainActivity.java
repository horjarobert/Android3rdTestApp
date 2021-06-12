package com.stufflex.digimotion;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    // Declarations
    private Button btn_a_1, btn_a_2, btn_a_3, btn_a_4, btn_a_5, btn_a_6, btn_a_7;
    private Button btn_b_1, btn_b_2, btn_b_3, btn_b_4, btn_b_5, btn_b_6, btn_b_7;
    private Button btn_c_1, btn_c_2, btn_c_3, btn_c_4, btn_c_5, btn_c_6, btn_c_7;

    private Button btn_sound_on, btn_sound_off, btn_extinguisher, btn_musical_notes, btn_drum, btn_saxophone, btn_trumpet, btn_guitar, btn_violin, btn_piano;

    private TextView txt_title;

    private AnimatorSet setDownAndUp_btn_a_1, setDownAndUp_btn_a_2, setDownAndUp_btn_a_3, setDownAndUp_btn_a_4, setDownAndUp_btn_a_5, setDownAndUp_btn_a_6, setDownAndUp_btn_a_7,
            setDownAndUp_btn_b_1, setDownAndUp_btn_b_2, setDownAndUp_btn_b_3, setDownAndUp_btn_b_4, setDownAndUp_btn_b_5, setDownAndUp_btn_b_6, setDownAndUp_btn_b_7,
            setDownAndUp_btn_c_1, setDownAndUp_btn_c_2, setDownAndUp_btn_c_3, setDownAndUp_btn_c_4, setDownAndUp_btn_c_5, setDownAndUp_btn_c_6, setDownAndUp_btn_c_7,
            setDownAndUp_btn_drum, setDownAndUp_btn_saxophone, setDownAndUp_btn_trumpet, setDownAndUp_btn_guitar, setDownAndUp_btn_violin, setDownAndUp_btn_piano;

    private Animator scaleDown_btn_a_1, scaleDown_btn_a_2, scaleDown_btn_a_3, scaleDown_btn_a_4, scaleDown_btn_a_5, scaleDown_btn_a_6, scaleDown_btn_a_7;
    private Animator scaleDown_btn_b_1, scaleDown_btn_b_2, scaleDown_btn_b_3, scaleDown_btn_b_4, scaleDown_btn_b_5, scaleDown_btn_b_6, scaleDown_btn_b_7;
    private Animator scaleDown_btn_c_1, scaleDown_btn_c_2, scaleDown_btn_c_3, scaleDown_btn_c_4, scaleDown_btn_c_5, scaleDown_btn_c_6, scaleDown_btn_c_7;
    private Animator scaleDown_btn_drum, scaleDown_btn_saxophone, scaleDown_btn_trumpet, scaleDown_btn_guitar, scaleDown_btn_violin, scaleDown_btn_piano;

    private Animator scaleUp_btn_a_1, scaleUp_btn_a_2, scaleUp_btn_a_3, scaleUp_btn_a_4, scaleUp_btn_a_5, scaleUp_btn_a_6, scaleUp_btn_a_7;
    private Animator scaleUp_btn_b_1, scaleUp_btn_b_2, scaleUp_btn_b_3, scaleUp_btn_b_4, scaleUp_btn_b_5, scaleUp_btn_b_6, scaleUp_btn_b_7;
    private Animator scaleUp_btn_c_1, scaleUp_btn_c_2, scaleUp_btn_c_3, scaleUp_btn_c_4, scaleUp_btn_c_5, scaleUp_btn_c_6, scaleUp_btn_c_7;
    private Animator scaleUp_btn_drum, scaleUp_btn_saxophone, scaleUp_btn_trumpet, scaleUp_btn_guitar, scaleUp_btn_violin, scaleUp_btn_piano;

    private ConstraintLayout main_layout, include_layout;

    private static final long TOAST_TIMEOUT_MS = 1000;
    private static long lastToastTime = 0;

    private MediaPlayer sound_extinguisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Navbar-fullscreen
        hideNavigationBar();

        // Initializations
        btn_a_1 = findViewById(R.id.btn_a_1);
        btn_a_2 = findViewById(R.id.btn_a_2);
        btn_a_3 = findViewById(R.id.btn_a_3);
        btn_a_4 = findViewById(R.id.btn_a_4);
        btn_a_5 = findViewById(R.id.btn_a_5);
        btn_a_6 = findViewById(R.id.btn_a_6);
        btn_a_7 = findViewById(R.id.btn_a_7);

        btn_b_1 = findViewById(R.id.btn_b_1);
        btn_b_2 = findViewById(R.id.btn_b_2);
        btn_b_3 = findViewById(R.id.btn_b_3);
        btn_b_4 = findViewById(R.id.btn_b_4);
        btn_b_5 = findViewById(R.id.btn_b_5);
        btn_b_6 = findViewById(R.id.btn_b_6);
        btn_b_7 = findViewById(R.id.btn_b_7);

        btn_c_1 = findViewById(R.id.btn_c_1);
        btn_c_2 = findViewById(R.id.btn_c_2);
        btn_c_3 = findViewById(R.id.btn_c_3);
        btn_c_4 = findViewById(R.id.btn_c_4);
        btn_c_5 = findViewById(R.id.btn_c_5);
        btn_c_6 = findViewById(R.id.btn_c_6);
        btn_c_7 = findViewById(R.id.btn_c_7);

        btn_sound_on = findViewById(R.id.btn_sound_on);
        btn_sound_off = findViewById(R.id.btn_sound_off);
        btn_extinguisher = findViewById(R.id.btn_extinguisher);
        btn_musical_notes = findViewById(R.id.btn_musical_notes);
        btn_drum = findViewById(R.id.btn_drum);
        btn_saxophone = findViewById(R.id.btn_saxophone);
        btn_trumpet = findViewById(R.id.btn_trumpet);
        btn_guitar = findViewById(R.id.btn_guitar);
        btn_violin = findViewById(R.id.btn_violin);
        btn_piano = findViewById(R.id.btn_piano);

        txt_title = findViewById(R.id.txt_title);

        include_layout = findViewById(R.id.include_layout);
        main_layout = findViewById(R.id.main_layout);

        // Set to invisible
        btn_sound_off.setVisibility(View.INVISIBLE);
        btn_drum.setVisibility(View.INVISIBLE);
        btn_saxophone.setVisibility(View.INVISIBLE);
        btn_trumpet.setVisibility(View.INVISIBLE);
        btn_guitar.setVisibility(View.INVISIBLE);
        btn_violin.setVisibility(View.INVISIBLE);
        btn_piano.setVisibility(View.INVISIBLE);

        // Click on main_layout for hiding navbar
        main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navbar-fullscreen
                hideNavigationBar();
            }
        });

        // Sound buttons
        btn_sound_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sound_off.setVisibility(View.VISIBLE);
                btn_sound_on.setVisibility(View.INVISIBLE);

                SoundON();
            }
        });
        btn_sound_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sound_on.setVisibility(View.VISIBLE);
                btn_sound_off.setVisibility(View.INVISIBLE);

                SoundOFF();
            }
        });

        SetAnimators();

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

    // Set animators
    public void SetAnimators() {
        // Special guest | Animation for btn_a_1
        scaleDown_btn_a_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_1.setTarget(btn_a_1);

        scaleUp_btn_a_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_1 = new AnimatorSet();
        setDownAndUp_btn_a_1.playSequentially(scaleDown_btn_a_1, scaleUp_btn_a_1);

        // Special guest | Animation for btn_a_2
        scaleDown_btn_a_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_2.setTarget(btn_a_2);

        scaleUp_btn_a_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_2 = new AnimatorSet();
        setDownAndUp_btn_a_2.playSequentially(scaleDown_btn_a_2, scaleUp_btn_a_2);

        // Special guest | Animation for btn_a_3
        scaleDown_btn_a_3 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_3.setTarget(btn_a_3);

        scaleUp_btn_a_3 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_3 = new AnimatorSet();
        setDownAndUp_btn_a_3.playSequentially(scaleDown_btn_a_3, scaleUp_btn_a_3);

        // Special guest | Animation for btn_a_4
        scaleDown_btn_a_4 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_4.setTarget(btn_a_4);

        scaleUp_btn_a_4 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_4 = new AnimatorSet();
        setDownAndUp_btn_a_4.playSequentially(scaleDown_btn_a_4, scaleUp_btn_a_4);

        // Special guest | Animation for btn_a_5
        scaleDown_btn_a_5 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_5.setTarget(btn_a_5);

        scaleUp_btn_a_5 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_5 = new AnimatorSet();
        setDownAndUp_btn_a_5.playSequentially(scaleDown_btn_a_5, scaleUp_btn_a_5);

        // Special guest | Animation for btn_a_6
        scaleDown_btn_a_6 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_6.setTarget(btn_a_6);

        scaleUp_btn_a_6 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_6 = new AnimatorSet();
        setDownAndUp_btn_a_6.playSequentially(scaleDown_btn_a_6, scaleUp_btn_a_6);

        // Special guest | Animation for btn_a_7
        scaleDown_btn_a_7 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_a_7.setTarget(btn_a_7);

        scaleUp_btn_a_7 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_a_7 = new AnimatorSet();
        setDownAndUp_btn_a_7.playSequentially(scaleDown_btn_a_7, scaleUp_btn_a_7);

        // Special guest | Animation for btn_b_1
        scaleDown_btn_b_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_1.setTarget(btn_b_1);

        scaleUp_btn_b_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_1 = new AnimatorSet();
        setDownAndUp_btn_b_1.playSequentially(scaleDown_btn_b_1, scaleUp_btn_b_1);

        // Special guest | Animation for btn_b_2
        scaleDown_btn_b_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_2.setTarget(btn_b_2);

        scaleUp_btn_b_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_2 = new AnimatorSet();
        setDownAndUp_btn_b_2.playSequentially(scaleDown_btn_b_2, scaleUp_btn_b_2);

        // Special guest | Animation for btn_b_3
        scaleDown_btn_b_3 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_3.setTarget(btn_b_3);

        scaleUp_btn_b_3 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_3 = new AnimatorSet();
        setDownAndUp_btn_b_3.playSequentially(scaleDown_btn_b_3, scaleUp_btn_b_3);

        // Special guest | Animation for btn_b_4
        scaleDown_btn_b_4 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_4.setTarget(btn_b_4);

        scaleUp_btn_b_4 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_4 = new AnimatorSet();
        setDownAndUp_btn_b_4.playSequentially(scaleDown_btn_b_4, scaleUp_btn_b_4);

        // Special guest | Animation for btn_b_5
        scaleDown_btn_b_5 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_5.setTarget(btn_b_5);

        scaleUp_btn_b_5 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_5 = new AnimatorSet();
        setDownAndUp_btn_b_5.playSequentially(scaleDown_btn_b_5, scaleUp_btn_b_5);

        // Special guest | Animation for btn_b_6
        scaleDown_btn_b_6 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_6.setTarget(btn_b_6);

        scaleUp_btn_b_6 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_6 = new AnimatorSet();
        setDownAndUp_btn_b_6.playSequentially(scaleDown_btn_b_6, scaleUp_btn_b_6);

        // Special guest | Animation for btn_b_7
        scaleDown_btn_b_7 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_b_7.setTarget(btn_b_7);

        scaleUp_btn_b_7 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_b_7 = new AnimatorSet();
        setDownAndUp_btn_b_7.playSequentially(scaleDown_btn_b_7, scaleUp_btn_b_7);

        // Special guest | Animation for btn_c_1
        scaleDown_btn_c_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_1.setTarget(btn_c_1);

        scaleUp_btn_c_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_1 = new AnimatorSet();
        setDownAndUp_btn_c_1.playSequentially(scaleDown_btn_c_1, scaleUp_btn_c_1);

        // Special guest | Animation for btn_c_2
        scaleDown_btn_c_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_2.setTarget(btn_c_2);

        scaleUp_btn_c_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_2 = new AnimatorSet();
        setDownAndUp_btn_c_2.playSequentially(scaleDown_btn_c_2, scaleUp_btn_c_2);

        // Special guest | Animation for btn_c_3
        scaleDown_btn_c_3 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_3.setTarget(btn_c_3);

        scaleUp_btn_c_3 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_3 = new AnimatorSet();
        setDownAndUp_btn_c_3.playSequentially(scaleDown_btn_c_3, scaleUp_btn_c_3);

        // Special guest | Animation for btn_c_4
        scaleDown_btn_c_4 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_4.setTarget(btn_c_4);

        scaleUp_btn_c_4 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_4 = new AnimatorSet();
        setDownAndUp_btn_c_4.playSequentially(scaleDown_btn_c_4, scaleUp_btn_c_4);

        // Special guest | Animation for btn_c_5
        scaleDown_btn_c_5 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_5.setTarget(btn_c_5);

        scaleUp_btn_c_5 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_5 = new AnimatorSet();
        setDownAndUp_btn_c_5.playSequentially(scaleDown_btn_c_5, scaleUp_btn_c_5);

        // Special guest | Animation for btn_c_6
        scaleDown_btn_c_6 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_6.setTarget(btn_c_6);

        scaleUp_btn_c_6 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_6 = new AnimatorSet();
        setDownAndUp_btn_c_6.playSequentially(scaleDown_btn_c_6, scaleUp_btn_c_6);

        // Special guest | Animation for btn_c_7
        scaleDown_btn_c_7 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_btn_c_7.setTarget(btn_c_7);

        scaleUp_btn_c_7 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_btn_c_7 = new AnimatorSet();
        setDownAndUp_btn_c_7.playSequentially(scaleDown_btn_c_7, scaleUp_btn_c_7);

    }

    // Click on btn_zero
    public void ClickOnZero(View view) {
        SetAnimators();

        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_2.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_3.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_5.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_6.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnOne(View view) {
        SetAnimators();

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnTwo(View view) {
        SetAnimators();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_5.start();

        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_6.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnThree(View view) {
        SetAnimators();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

    }

    public void ClickOnFour(View view) {
        SetAnimators();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_2.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_3.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnFive(View view) {
        SetAnimators();

        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_2.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_3.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

    }

    public void ClickOnSix(View view) {
        SetAnimators();

        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_2.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_3.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_6.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

    }

    public void ClickOnSeven(View view) {
        SetAnimators();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnEight(View view) {
        SetAnimators();

        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_2.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_3.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_5.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_6.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnNine(View view) {
        SetAnimators();

        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_1.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_1.start();

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_1.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_2.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_2.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_3.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_3.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_4.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_4.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_6.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_a_7.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_b_7.start();

        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background_green);
        setDownAndUp_btn_c_7.start();

    }

    public void ClickOnFireExtinguisher(View view) {
        SetAnimators();
        FireExtinguished();

        include_layout.setBackgroundResource(R.drawable.background_white);

        btn_a_1.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_1.start();

        btn_a_2.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_2.start();

        btn_a_3.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_3.start();

        btn_a_4.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_4.start();

        btn_a_5.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_5.start();

        btn_a_6.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_6.start();

        btn_a_7.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_a_7.start();

        btn_b_1.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_1.start();

        btn_b_2.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_2.start();

        btn_b_3.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_3.start();

        btn_b_4.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_4.start();

        btn_b_5.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_5.start();

        btn_b_6.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_6.start();

        btn_b_7.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_b_7.start();

        btn_c_1.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_c_1.start();

        btn_c_2.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_c_2.start();

        btn_c_3.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_c_3.start();

        btn_c_4.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_c_4.start();

        btn_c_5.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_c_5.start();

        btn_c_6.setBackgroundResource(R.drawable.txt_buttons_background);
        setDownAndUp_btn_c_6.start();

        setDownAndUp_btn_c_7.start();
        btn_c_7.setBackgroundResource(R.drawable.txt_buttons_background);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                include_layout.setBackgroundResource(R.drawable.background_black);
            }
        }, 400);

    }

    public void FireExtinguished() {
        Toast toast = Toast.makeText(this, "Fire extinguished...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);

        // Toast improvement, never click twice, just once after each 3s
        long now = System.currentTimeMillis();

        if (lastToastTime + TOAST_TIMEOUT_MS < now) {
            toast.show();
            lastToastTime = now;
        }

        ExtinguihserSound();

    }

    public void SoundON() {
        Toast toast = Toast.makeText(this, "Sound OFF", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);

        // Toast improvement, never click twice, just once after each 3s
        long now = System.currentTimeMillis();

        if (lastToastTime + TOAST_TIMEOUT_MS < now) {
            toast.show();
            lastToastTime = now;
        }

        Mute();

    }

    public void SoundOFF() {
        Toast toast = Toast.makeText(this, "Sound ON", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);

        // Toast improvement, never click twice, just once after each 3s
        long now = System.currentTimeMillis();

        if (lastToastTime + TOAST_TIMEOUT_MS < now) {
            toast.show();
            lastToastTime = now;
        }

        Unmute();

    }

    public void ClickOnMusicalNotes(View view) {
        btn_drum.setVisibility(View.VISIBLE);
        btn_saxophone.setVisibility(View.VISIBLE);
        btn_trumpet.setVisibility(View.VISIBLE);
        btn_guitar.setVisibility(View.VISIBLE);
        btn_violin.setVisibility(View.VISIBLE);
        btn_piano.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_drum.setVisibility(View.INVISIBLE);
                btn_saxophone.setVisibility(View.INVISIBLE);
                btn_trumpet.setVisibility(View.INVISIBLE);
                btn_guitar.setVisibility(View.INVISIBLE);
                btn_violin.setVisibility(View.INVISIBLE);
                btn_piano.setVisibility(View.INVISIBLE);
            }
        }, 5000);


    }

    public void ExtinguihserSound() {
        sound_extinguisher = MediaPlayer.create(MainActivity.this, R.raw.romane);
        sound_extinguisher.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        sound_extinguisher.start();
    }

    private void Mute() {
        // Mute audio
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            amanager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
        } else {
            amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        }

    }

    private void Unmute() {
        // Unmute audio
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            amanager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0);
        } else {
            amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        }

    }
}