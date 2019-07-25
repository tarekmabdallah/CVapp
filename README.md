# CV App:

simple app to add easily to my apps to show my CV

# Implementation:

build.gradle (project):

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	

build.gradle (module):

dependencies {
	        implementation 'com.github.tarekmabdallah91:CVapp:version'
	}
	

	
after syncing project:

add this line in manifest file

<
activity android:name="aboutMe.AboutMeActivity" android:theme="@style/Theme.AppCompat.DayNight.NoActionBar" 
/>


# Usage:

call openAboutMeActivity wherever you want to show your CV and put your values in this order 
cvName, cvJobTitle, cvMobileNumber, cvEmail, cvLinkedIn, cvGithub

you should put empty string ("") if there was not a value for any of them 
like:

showCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutMeActivity(v.getContext(),
                        "Tarek AbdAllah",
                        "Android Developer",
                        "+201096071130",
                        "tarekmabdallah91@gmail.com",
                        "http://bit.ly/2kfdLeB",  // Linkedin
                        "http://bit.ly/2Pi2h84"); // Github
            }
        });


# Licence:

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
