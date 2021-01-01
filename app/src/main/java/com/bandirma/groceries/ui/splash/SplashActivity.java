package com.bandirma.groceries.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bandirma.groceries.R;
import com.bandirma.groceries.ui.onboarding.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread logoAnimation = new Thread() {
            @Override
            public void run() {
                ImageView logo = findViewById(R.id.intro_logo);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_intro_logo);
                logo.startAnimation(animation);
            }
        };
        logoAnimation.start();
        Thread redirect = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent i = new Intent(getApplicationContext(), OnboardingActivity.class);
                    startActivity(i);
                    finish();
                    super.run();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}