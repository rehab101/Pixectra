package com.vikkyb.Picx.pixectra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



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

        gv = (GridView) findViewById(R.id.gv);
b1=(Button)findViewById(R.id.button);
        Format formatter = new SimpleDateFormat("MMMM");
        String s = formatter.format(new Date());
        t1 = (TextView) findViewById(R.id.textView);
        t1.setText(s);
        Format formatter2 = new SimpleDateFormat("dd");
        String s2 = formatter2.format(new Date());
        t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(s2);
        Format formatter3 = new SimpleDateFormat("EEEE-yyyy");
        String s3 = formatter3.format(new Date());
        t3 = (TextView) findViewById(R.id.textView3);
        t3.setText(s3);
        t4 = (TextView) findViewById(R.id.textView4);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,imagepicker.class));
        }
    });
    }

}