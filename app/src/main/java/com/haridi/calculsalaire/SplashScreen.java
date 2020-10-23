package com.haridi.calculsalaire;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;


public class SplashScreen extends Activity {
    SharedPreferences shared,shared1;
    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

    // toolbar.inflateMenu(R.menu.activity_main_drawer);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final TextView loding = (TextView) findViewById(R.id.load);
        final TextView title = (TextView) findViewById(R.id.title);

        shared = getSharedPreferences("Mypref", MODE_PRIVATE);
        if (shared!=null) {
            int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
            System.out.println("checkedRadioButtonId" + checkedRadioButtonId);
            if (checkedRadioButtonId == 2131230886) {
                 loding.setText("Telecharger Les Donnees");
                      title.setText("Calculer Salaire");
                title.setTextSize(40);
                loding.setTextSize(15);


            }
        }
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(1500);
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        thread.start();
    }
}