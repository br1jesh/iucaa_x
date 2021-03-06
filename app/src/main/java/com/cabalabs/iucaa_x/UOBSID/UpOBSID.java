package com.cabalabs.iucaa_x.UOBSID;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cabalabs.iucaa_x.MGPROLG.MergedProLog;
import com.cabalabs.iucaa_x.MainActivity;
import com.cabalabs.iucaa_x.PROBPGS.ProblemPg;
import com.cabalabs.iucaa_x.PXHIST.PixHistory;
import com.cabalabs.iucaa_x.R;
import com.cabalabs.iucaa_x.THRESHIST.ModThresAct;
import com.cabalabs.iucaa_x.UOBSID.Adapter.MyAdapter;
import com.cabalabs.iucaa_x.UOBSID.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class UpOBSID extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView list;
    RecyclerView.LayoutManager layoutManager;
    List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_obsid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        list = (RecyclerView)findViewById(R.id.recycler);
        list.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        setData();

    }

    private void setData() {
        for(int i=0;i<20;i++)
        {

            Item item = new Item("This is item "+(i+1),"LEVEL1AS1CZT20190209C04_009T03_9000002714.tar_V1.2", true);
            items.add(item);
//            if(i%2==0)
//            {
//                Item item = new Item("This is item "+(i+1),"LEVEL1AS1CZT20190209C04_009T03_9000002714.tar_V1.2", true);
//                items.add(item);
//            }
//            else
//            {
//                Item item = new Item("This is item "+(i+1),"",false);
//                items.add(item);
//            }
        }
        MyAdapter adapter = new MyAdapter(items);
        list.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.up_obsid, menu);
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
            Intent intent = new Intent(UpOBSID.this,MainActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.merged_obsid_wise) {
            Intent intent = new Intent(UpOBSID.this, MergedProLog.class);
            startActivity(intent);
        } else if (id == R.id.upload_obsid_wise) {
            Intent intent = new Intent(UpOBSID.this, UpOBSID.class);
            startActivity(intent);
        } else if (id == R.id.merged_processing_logs) {
            Intent intent = new Intent(UpOBSID.this,MergedProLog.class);
            startActivity(intent);
        } else if (id == R.id.problem_pages) {
            Intent intent = new Intent(UpOBSID.this, ProblemPg.class);
            startActivity(intent);
        } else if (id == R.id.pixel_enable) {
            Intent intent = new Intent(UpOBSID.this, PixHistory.class);
            startActivity(intent);
        } else if (id == R.id.module_threshold_history) {
            Intent intent = new Intent(UpOBSID.this, ModThresAct.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
