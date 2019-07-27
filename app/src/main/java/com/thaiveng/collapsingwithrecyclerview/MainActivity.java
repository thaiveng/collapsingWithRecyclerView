package com.thaiveng.collapsingwithrecyclerview;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    AppBarLayout appBar;
    Toolbar toolbar;
    private boolean isHide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CollapsingToolbarLayout collapsingToolbarLayout =findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle("");

        toolbar = findViewById(R.id.toolBarFeed);

        appBar = findViewById(R.id.app_bar);
        appBar.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

        int maxScroll = appBar.getTotalScrollRange();
        float percentage = (float) Math.abs(i)/(float)maxScroll;

        if (percentage == 1f && isHide){
            isHide = !isHide;

        }
    }
}
