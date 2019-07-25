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

package aboutMe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.tarekmabdallah91.aboutme.R;

import static android.view.View.GONE;

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener {

    private String cvName, cvJobTitle, cvMobileNumber, cvEmail, cvLinkedIn, cvGithub;
    private static final String CV_DATA = "CV_DATA", EMPTY_STRING = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        ImageView callIcon = findViewById(R.id.mobile);
        ImageView emailIcon = findViewById(R.id.email);
        ImageView linkedinIcon = findViewById(R.id.linkedin);
        ImageView githubIcon = findViewById(R.id.github);
        TextView nameTV = findViewById(R.id.cv_name_tv);
        TextView jobTitleTV = findViewById(R.id.cv_job_tv);
        setOnClickListenerForViews(callIcon, emailIcon, linkedinIcon, githubIcon);
        getComingIntent();
        if (isValidInput(cvName)) nameTV.setText(cvName);
        else letViewGone(nameTV);

        if (isValidInput(cvJobTitle)) jobTitleTV.setText(cvJobTitle);
        else letViewGone(jobTitleTV);

        if (!isValidInput(cvMobileNumber)) letViewGone(callIcon);
        if (!isValidInput(cvEmail)) letViewGone(emailIcon);
        if (!isValidInput(cvLinkedIn)) letViewGone(linkedinIcon);
        if (!isValidInput(cvGithub)) letViewGone(githubIcon);

    }

    private void getComingIntent (){
        Intent comingIntent = getIntent();
        String[] cvData = comingIntent.getStringArrayExtra(CV_DATA);
        cvName = cvData[0];
        cvJobTitle = cvData[1];
        cvMobileNumber = cvData[2];
        cvEmail = cvData[3];
        cvLinkedIn = cvData[4];
        cvGithub = cvData[5];
    }

    /**
     * @param input-
     * @return true if valid or false if not valid
     */
    private boolean isValidInput (String input){
        return !(input == null || input.equals(EMPTY_STRING));
    }

    private void letViewGone (View view){
        view.setVisibility(GONE);
    }

    void onClickCallIcon() {
        Intent callNumber = new Intent(Intent.ACTION_DIAL);
        final String TEL = "tel:%s";
        String uriData = String.format(TEL, cvMobileNumber);
        callNumber.setData(Uri.parse(uriData));
        startActivity(callNumber);
    }

    @SuppressLint("IntentReset")
    void onClickEmailIcon() {
        final String EMAIL_INTENT = "mailto:";
        final String TEXT_TYPE = "text/plain";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse(EMAIL_INTENT));
        emailIntent.setType(TEXT_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{cvEmail});
        startActivity(emailIntent);
    }

    private void onClickLinkedinIcon() {
        final String linkedinPackage = "vnd.linkedin:";
        startExternalIntent(linkedinPackage, cvLinkedIn);
    }

    private void onClickGithubIcon() {
        final String githubPackage = "vnd.github:";
        startExternalIntent(githubPackage, cvGithub);
    }

    private Intent setExternalIntent(String externalAppPackage, String pageUrl) {
        Uri uri = Uri.parse(pageUrl);
        Intent externalIntent = new Intent(Intent.ACTION_VIEW);
        externalIntent.setPackage(externalAppPackage);
        externalIntent.setData(uri);
        return externalIntent;
    }

    private void startExternalIntent(String externalAppPackage, String pageUrl) {
        Intent intent = setExternalIntent(externalAppPackage, pageUrl);
        if (!isPackageInstalled(this, externalAppPackage))
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pageUrl));
        startActivity(intent);
    }

    private boolean isPackageInstalled(Context c, String targetPackage) {
        PackageManager pm = c.getPackageManager();
        try {
            pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.mobile == id) onClickCallIcon();
        else if (R.id.email == id) onClickEmailIcon();
        else if (R.id.linkedin == id) onClickLinkedinIcon();
        else if (R.id.github == id) onClickGithubIcon();
    }

    private void setOnClickListenerForViews(View... views) {
        for (View view : views) view.setOnClickListener(this);
    }

    /**
     * open CV screen
     * @param context -
     * @param cvData put your values in this order cvName, cvJobTitle, cvMobileNumber, cvEmail, cvLinkedIn, cvGithub
     *               you should put empty string ("") if there was not a value for any of them
     */
    public static void openAboutMeActivity(Context context, String...cvData) {
        Intent openAboutMeActivity = new Intent(context, AboutMeActivity.class);
        openAboutMeActivity.putExtra(CV_DATA, cvData);
        context.startActivity(openAboutMeActivity);
    }
}
