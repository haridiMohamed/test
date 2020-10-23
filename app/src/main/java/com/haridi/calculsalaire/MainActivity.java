package com.haridi.calculsalaire;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public List<YouTubeVideos> mList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private VideoAdapter Recycler_view_Adapter;
   // RecyclerView recyclerView;
  //  Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();
    SharedPreferences shared;
    private AdView adView;
    private InterstitialAd interstitialAd;
    private AdRequest adRequestFull;
    boolean locked  ;
    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.inflateMenu(R.menu.main);
       // toolbar.inflateMenu(R.menu.activity_main_drawer);
        setSupportActionBar(toolbar);
        ViewTarget target = new ViewTarget(toolbar.findViewById(R.id.action_settings1));


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        mList = new ArrayList<>();
        System.out.println("mList"+mList.size());

        Recycler_view_Adapter = new VideoAdapter(mList, this);
        recyclerView.setAdapter(Recycler_view_Adapter);

        LoadData();


        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-2195728537410789/6842312541");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });




//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager( new LinearLayoutManager(this));
//
//      //  youtubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VHPDQxvILm4\" frameborder=\"0\" allowfullscreen></iframe>") );
//
//        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
//
//        recyclerView.setAdapter(videoAdapter);






       // TextView titelApp = (TextView) findViewById(R.id.titelApp);
        shared = getSharedPreferences("Mypref", MODE_PRIVATE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View navView =  navigationView.inflateHeaderView(R.layout.nav_header_main);

        Menu menu = navigationView.getMenu();


        if (shared!=null) {
            int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);


            if (checkedRadioButtonId == 2131230886   ) {
                System.out.println("checkedRadioButtonIdFrance" + checkedRadioButtonId);


//maybe you want to check it by getting the sharedpreferences. Use this instead if (locked)
                if (shared.getBoolean("locked", locked)==false) {
    System.out.println("jh--------------"+  locked);
                    new ShowcaseView.Builder(this)
                            .withMaterialShowcase()
                            .setContentTitle("Vous pouvez éditer les données ici")
                            .setContentText("Si le programme n'est pas compatible avec le système de votre pays, veuillez envoyer le nom du pays et des informations sur les réductions pour nous aider à développer le programme.")
                            .useDecorViewAsParent() //this is the difference
                            .setTarget(target)
                            .build();
                    shared.edit().putBoolean("locked", true).commit();

                }

                MenuItem home = menu.findItem(R.id.home);
                home.setTitle("Home");

                MenuItem calcul1 = menu.findItem(R.id.calcul1);
                calcul1.setTitle("Duree du travail 8h par jour");
                MenuItem calcul2 = menu.findItem(R.id.calcul2);
                calcul2.setTitle("Duree du travail 9h par jour");
              //  MenuItem calcul3 = menu.findItem(R.id.calcul3);
               // calcul3.setTitle("Calculer Fix");
                MenuItem help = menu.findItem(R.id.help);
                help.setTitle("Explication detallee");
                MenuItem nav_send = menu.findItem(R.id.nav_send);
                nav_send.setTitle("Send Email");
                MenuItem nav_share = menu.findItem(R.id.nav_share);
                nav_share.setTitle("Share Application");
                //inflate header layout
               //reference to views
                TextView tv = navView.findViewById(R.id.titelApp);
             //set views
                tv.setText("Calculer Salaire");

            }else if(checkedRadioButtonId == 2131230888){

                System.out.println("checkedRadioButtonIdArab" + checkedRadioButtonId);

                TextView tv = navView.findViewById(R.id.titelApp);
              //set views
                tv.setText("حساب الراتب");
                if (shared.getBoolean("locked", locked)==false) {
                    System.out.println("jh--------------"+  locked);
                    new ShowcaseView.Builder(this)
                            .withMaterialShowcase()
                            .setContentTitle("يمكنك التعديل على البيانات من هنا")
                            .setContentText("ان كان البرنامج لا يتوافق مع نظام الحساب في دولتك المرجوا من الراغبين استعمال البرنامج ارسال اسم الدولة ومعلومات حول الاقتطاعات ليساعدنا في تطوير البرنامج")
                            .useDecorViewAsParent() //this is the difference
                            .setTarget(target)
                            .build();
                    shared.edit().putBoolean("locked", true).commit();

                }

            }
            else{
                TextView tv = navView.findViewById(R.id.titelApp);
                //set views
                tv.setText("حساب الراتب");
                if (shared.getBoolean("locked", locked)==false) {
                    System.out.println("jh--------------"+  locked);
                    new ShowcaseView.Builder(this)
                            .withMaterialShowcase()
                            .setContentTitle("يمكنك التعديل على البيانات من هنا")
                            .setContentText("ان كان البرنامج لا يتوافق مع نظام الحساب في دولتك المرجوا من الراغبين استعمال البرنامج ارسال اسم الدولة ومعلومات حول الاقتطاعات ليساعدنا في تطوير البرنامج")
                            .useDecorViewAsParent() //this is the difference
                            .setTarget(target)
                            .build();
                    shared.edit().putBoolean("locked", true).commit();

                }
            }
        }

        navigationView.setNavigationItemSelectedListener(this);
    }
        //admob
    private void requestNewInterstitial() {
        adRequestFull = new AdRequest.Builder()
               // .addTestDevice("ad_unit_full")
                .build();

        interstitialAd.loadAd(adRequestFull);
    }

    private void showFullAds(){

        if(interstitialAd != null && interstitialAd.isLoaded())
        {
            interstitialAd.show();
        }
    }



    @Override
    public void onBackPressed() {
        showFullAds();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new SettingsCalcul())
                    .commit();
            return true;
        }//else if(id == R.id.action_exit){
//            finish();
//            System.exit(0);
//
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.calcul1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new ClaculOne())
                    .commit();
            showFullAds();

        } else if (id == R.id.calcul2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new CalculTwo())
                    .commit();
            showFullAds();
//       }
// else if (id == R.id.calcul3) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame, new FixCalcul())
//                    .commit();
//            int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
//            System.out.println("checkedRadioButtonId" + checkedRadioButtonId);
//            if (checkedRadioButtonId == 2131230876) {
//                Toast.makeText(MainActivity.this, "Les Information pour cette partie seront collectees", Toast.LENGTH_SHORT).show();
//
//            }else {
//                Toast.makeText(MainActivity.this, "سيتم انشاءه بعد تجميع المعلومات", Toast.LENGTH_SHORT).show();
//            }
        } else if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.help) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HelpScrene())
                    .commit();

        } else if (id == R.id.nav_share) {
        //   Toast.makeText(this, "Come Soon On Play Store", Toast.LENGTH_SHORT).show();
            shareTextUrl();


        } else if (id == R.id.nav_send) {
           // Toast.makeText(this, "Come Soon", Toast.LENGTH_SHORT).show();
            sendEmail();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @SuppressLint("LongLogTag")
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"devandnet86@gmail.com"};
//        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
       // emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
      //  share.putExtra(Intent.EXTRA_TEXT, "https://doc-0k-6k-docs.googleusercontent.com/docs/securesc/nlcnd63rh52ilr7pdce7ti7oaic9shut/mjsig76968g9dkvjfl4kl66f5arr8ae0/1544954400000/08731744390496010957/08731744390496010957/1mGI3GRLFpUVUVDr0lbPnfkrTd8lf_xnc?e=download");
        share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.haridi.calculsalaire");

        startActivity(Intent.createChooser(share, "Share link!"));
    }

    public void LoadData() {

       // for (int i = 1; i < 2; i++) {
            YouTubeVideos list_item = new YouTubeVideos();
            list_item.setVideoUrl("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eIqm9f5Uhko\" frameborder=\"0\" allowfullscreen></iframe>");
            list_item.setViewType(1);
            list_item.setImgUrl("");
            mList.add(list_item);

        //}

        ////
        YouTubeVideos list_item2 = new YouTubeVideos();
        list_item2.setViewType(2);
        mList.add(0, list_item2);
        Recycler_view_Adapter.notifyDataSetChanged();
    }
}
