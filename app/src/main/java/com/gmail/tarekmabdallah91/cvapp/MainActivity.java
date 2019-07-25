package com.gmail.tarekmabdallah91.cvapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static aboutMe.AboutMeActivity.openAboutMeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showCV = findViewById(R.id.show_cv_tv);
        showCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutMeActivity(v.getContext());
            }
        });
    }
}

/*
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
	        implementation 'com.github.tarekmabdallah91:CVapp:Tag'
	}

*/
