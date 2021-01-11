package com.example.shoptext.detailslist.view;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoptext.R;
import com.youth.banner.Banner;

public class DetailsContentActivity extends AppCompatActivity {

    private Banner bannerDetailsContent;
    private LinearLayout llDetailsContent;
    private TextView tvDetailsContentTitle;
    private TextView tvDetailsContentSubtitle;
    private TextView tvDetailsContentPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_content);
        initView();
    }

    private void initView() {
        bannerDetailsContent = findViewById(R.id.banner_details_content);
        llDetailsContent = findViewById(R.id.ll_details_content);
        tvDetailsContentTitle = findViewById(R.id.tv_details_content_title);
        tvDetailsContentSubtitle = findViewById(R.id.tv_details_content_subtitle);
        tvDetailsContentPrice = findViewById(R.id.tv_details_content_price);
    }
}