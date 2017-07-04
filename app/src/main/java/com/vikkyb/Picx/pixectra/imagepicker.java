package com.vikkyb.Picx.pixectra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;


@SuppressWarnings("deprecation")
public class imagepicker extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_MEDIA = 3;
    ArrayList<String> filePaths=new ArrayList<String>();
    GridView gv;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagepicker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
textView=(TextView)findViewById(R.id.tr);
        textView.setText("Select 100 Photos as much as u can as much as u can as much as u can as much as u can as much as u can");

        gv= (GridView) findViewById(R.id.gv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filePaths.clear();

                FilePickerBuilder.getInstance().setMaxCount(100)
                        .setSelectedFiles(filePaths)
                        .setActivityTheme(R.style.AppTheme)
                        .pickPhoto(imagepicker.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case FilePickerConst.REQUEST_CODE:

                if(resultCode==RESULT_OK && data!=null) {

                        filePaths = data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_PHOTOS);
                        Spacecraft s;
                        ArrayList<Spacecraft> spacecrafts = new ArrayList<>();

                        try {
                            for (String path : filePaths) {
                                s = new Spacecraft();
                                s.setName(path.substring(path.lastIndexOf("/") + 1));

                                s.setUri(Uri.fromFile(new File(path)));
                                spacecrafts.add(s);
                            }
                            gv.setAdapter(new CustomAdapter(this, spacecrafts));
                            textView.setVisibility(View.GONE);
                            Toast.makeText(imagepicker.this, "Total Image Selected= " + String.valueOf(spacecrafts.size()), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                }
                }




