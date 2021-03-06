package com.cabalabs.iucaa_x.PROBPGS;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cabalabs.iucaa_x.MGPROLG.MergedProLog;
import com.cabalabs.iucaa_x.MOBSID.MergOBSID;
import com.cabalabs.iucaa_x.MainActivity;
import com.cabalabs.iucaa_x.PXHIST.PixHistory;
import com.cabalabs.iucaa_x.R;
import com.cabalabs.iucaa_x.THRESHIST.ModThresAct;
import com.cabalabs.iucaa_x.UOBSID.UpOBSID;

public class ProblemPg extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_pg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.iucaa.in/~astrosat/czti_dqr/problem.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if(webView.canGoBack()){
                webView.goBack();
            }
            else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.problem_pg, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.orbit_wise) {
            Intent intent = new Intent(ProblemPg.this,MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.merged_obsid_wise) {
            Intent intent = new Intent(ProblemPg.this, MergOBSID.class);
            startActivity(intent);
        } else if (id == R.id.upload_obsid_wise) {
            Intent intent = new Intent(ProblemPg.this, UpOBSID.class);
            startActivity(intent);
        } else if (id == R.id.merged_processing_logs) {
            Intent intent = new Intent(ProblemPg.this,MergedProLog.class);
            startActivity(intent);
        } else if (id == R.id.problem_pages) {
            Intent intent = new Intent(ProblemPg.this, ProblemPg.class);
            startActivity(intent);
        } else if (id == R.id.pixel_enable) {
            Intent intent = new Intent(ProblemPg.this, PixHistory.class);
            startActivity(intent);
        } else if (id == R.id.module_threshold_history) {
            Intent intent = new Intent(ProblemPg.this, ModThresAct.class);
            startActivity(intent);
        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
