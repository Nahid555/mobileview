package com.example.mobiledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MyDisplay extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        webView=findViewById(R.id.webView);
        webView.loadUrl("https://www.samsung.com/in/smartphones/all-smartphones/");
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.aboutId) {
        Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
        startActivity(intent);

        }else if (id==R.id.feedbackId){
            Intent intent=new Intent(getApplicationContext(),FeedbackActivity.class);
            startActivity(intent);

        }else if(id==R.id.exit){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Exit me", true);
            startActivity(intent);
            finish();
        }
        else if (id==R.id.share1){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject="You can see any mobile\n";
            String body="This app is very use full for buy nay mobile phone.\n";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"share with"));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Samsung) {
            webView.loadUrl("https://www.samsung.com/in/smartphones/all-smartphones/");
        } else if (id == R.id.apple) {
            webView.loadUrl("https://gadgets.ndtv.com/mobiles/apple-phones"); }
            else if (id == R.id.Nokia) {
            webView.loadUrl("https://www.nokia.com/phones/en_us/");
        } else if (id == R.id.Xiaomi) {
           webView.loadUrl("https://www.mi.com/bd/");
        } else if (id == R.id.Symphony) {
            webView.loadUrl("https://www.symphony-mobile.com/product.php?cat=1&sub_cat=5");
        } else if (id == R.id.Walton) {
            webView.loadUrl("https://www.waltonbd.com/?route=product/category&path=24_85");
        } else if (id == R.id.HTC){
                webView.loadUrl("https://gadgets.ndtv.com/mobiles/htc-phones");
        } else if (id == R.id.OnePlus) {
            webView.loadUrl("https://gadgets.ndtv.com/mobiles/oneplus-phones");
        } else if (id == R.id.Oppo) {
            webView.loadUrl("https://www.oppo.com/bd/smartphones/");
        }else if (id == R.id.blackbary) {
            webView.loadUrl("https://gadgets.ndtv.com/mobiles/blackberry-phones");
        } else if (id == R.id.Alcatel) {
            webView.loadUrl("https://www.buymobile.com.bd/Alcatel");
        } else if (id == R.id.Asus) {
            webView.loadUrl("https://www.asus.com/Phone/");
        } else if (id == R.id.Micromax) {
            webView.loadUrl("https://gadgets.ndtv.com/mobiles/micromax-phones");
        } else if (id == R.id.lenovo) {
            webView.loadUrl("https://www.lenovo.com/bd/en/smartphones/c/smartphones");
        } else if (id == R.id.vivo) {
            webView.loadUrl("https://gadgets.ndtv.com/mobiles/vivo-phones");
        }else if (id == R.id.google) {
            webView.loadUrl("https://gadgets.ndtv.com/mobiles/google-phones");
        }else if (id==R.id.nav_share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject="You can see any mobile\n";
            String body="This app is very use full for buy nay mobile phone.\n";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"share with"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Exit me", true);
            startActivity(intent);
            finish();
        }
    }
}
