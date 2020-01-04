package com.densoft.feature;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cilenco.discoveryview.DiscoveryView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements DiscoveryView.OnDiscoveryViewClickListener {
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.btn_fab);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               fabClicked(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                final View v = findViewById(R.id.info);
                DiscoveryView infoView = new DiscoveryView.Builder(MainActivity.this, v)
                        .setPrimaryText("Densoft Developers")
                        .setSecondaryText("This is a sample application for the Feature Discovery Library.Tab other view on the screen to explore the scopes of this library")
                        .setOnClickListener(MainActivity.this)
                        .usePrimaryColorAsFilter(true)
                        .build();

                infoView.show();
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.info:

                DiscoveryView infoView = new DiscoveryView.Builder(this, findViewById(R.id.info))
                        .setPrimaryText("Densoft Developers")
                        .setSecondaryText("This is a sample application for the Feature Discovery Library.Tab other view on the screen to explore the scopes of this library")
                        .setOnClickListener(this)
                        .usePrimaryColorAsFilter(true)
                        .build();

                infoView.show();
                return true;

            case R.id.star:

                DiscoveryView starView = new DiscoveryView.Builder(this, findViewById(R.id.star))
                        .setPrimaryText("Densoft Developers")
                        .setSecondaryText("This is a sample application for the Feature Discovery Library.Tab other view on the screen to explore the scopes of this library")
                        .setOnClickListener(this)
                        .usePrimaryColorAsFilter(true)
                        .build();

                starView.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fabClicked(View v) {
        DiscoveryView discoveryView = new DiscoveryView.Builder(MainActivity.this,v)
                .setPrimaryText("Densoft Developers")
                .setSecondaryText("Where technology meets passion")
                .setOnClickListener(MainActivity.this)
                .build();
        discoveryView.show();
    }


    @Override
    public void onDiscoveryViewClicked(DiscoveryView discoveryView) {
        discoveryView.dismiss();
    }

    @Override
    public void onDiscoveryViewDismissed(DiscoveryView discoveryView) {

    }
}
