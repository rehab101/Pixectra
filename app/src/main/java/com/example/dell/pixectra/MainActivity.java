package com.example.dell.pixectra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class MainActivity extends AppCompatActivity {
TextView t1,t2,t3,t4;
    private static final int galleryrequest=1;
    ArrayList<String> filePaths=new ArrayList<String>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gv= (GridView) findViewById(R.id.gv);

        Format formatter = new SimpleDateFormat("MMMM");
        String s = formatter.format(new Date());
        t1=(TextView)findViewById(R.id.textView);
        t1.setText(s);
        Format formatter2 = new SimpleDateFormat("dd");
        String s2 = formatter2.format(new Date());
        t2=(TextView)findViewById(R.id.textView2);
        t2.setText(s2);
        Format formatter3 = new SimpleDateFormat("EEEE-yyyy");
        String s3 = formatter3.format(new Date());
        t3=(TextView)findViewById(R.id.textView3);
        t3.setText(s3);
        t4=(TextView)findViewById(R.id.textView4);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filePaths.clear();

                FilePickerBuilder.getInstance().setMaxCount(100)
                        .setSelectedFiles(filePaths)
                        .setActivityTheme(R.style.AppTheme)
                        .pickPhoto(MainActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case FilePickerConst.REQUEST_CODE:

                if(resultCode==RESULT_OK && data!=null)
                {
                    filePaths = data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_PHOTOS);
                    Spacecraft s;
                    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

                    try
                    {
                        for (String path:filePaths) {
                            s=new Spacecraft();
                            s.setName(path.substring(path.lastIndexOf("/")+1));

                            s.setUri(Uri.fromFile(new File(path)));
                            spacecrafts.add(s);
                        }

                        gv.setAdapter(new CustomAdapter(this,spacecrafts));
                        Toast.makeText(MainActivity.this, "Total = "+String.valueOf(spacecrafts.size()), Toast.LENGTH_SHORT).show();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }



                }

        }}}