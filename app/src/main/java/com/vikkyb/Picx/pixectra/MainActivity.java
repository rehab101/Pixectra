package com.vikkyb.Picx.pixectra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    TextView t1, t2, t3, t4;
    Button b1;
    private static final int galleryrequest = 1;
    ArrayList<String> filePaths = new ArrayList<String>();
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}