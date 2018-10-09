package com.a27club.khronos.a27club.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a27club.khronos.a27club.R;
import com.a27club.khronos.a27club.constants.AppConstants;
import com.a27club.khronos.a27club.utils.SpUtils;

public class SpalashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isFirstTimeOpen = SpUtils.getBoolean(this, AppConstants.FIRST_OPEN);
        if (!isFirstTimeOpen){
            Intent intent = new Intent(this,WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_spalash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHomeActivity();
            }
        },2000);
    }

    private void enterHomeActivity() {
        Intent intent = new Intent(this,NavigationActivity.class);
        startActivity(intent);
        return;
    }
}
