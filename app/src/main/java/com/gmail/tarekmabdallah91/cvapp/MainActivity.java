/*
 *
 * Copyright 2019 tarekmabdallah91@gmail.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

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
                openAboutMeActivity(v.getContext(),
                        "Tarek AbdAllah",
                        "Android Developer",
                        "+201096071130",
                        "tarekmabdallah91@gmail.com",
                        "http://bit.ly/2kfdLeB",
                        "http://bit.ly/2Pi2h84");
            }
        });
    }
}