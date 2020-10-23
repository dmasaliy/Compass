package com.compass.arrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView arrow;
    private Random random = new Random();
    private int lastDir;
    private boolean spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrow = findViewById(R.id.arrow);
    }

    public void spinArrow(View view){
        if(!spin){
            int newDir = random.nextInt(1500);

            float pivotX = arrow.getWidth() >> 1;
            float pivotY = arrow.getHeight() >> 1;

            final Animation spiner = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            spiner.setDuration(2200);
            spiner.setFillAfter(true);
            spiner.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spin = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            arrow.startAnimation(spiner);
        }
    }
}