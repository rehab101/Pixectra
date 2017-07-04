/*
 * Copyright (c) 2017. Truiton (http://www.truiton.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * Mohit Gupt (https://github.com/mohitgupt)
 *
 */

package com.vikkyb.Picx.pixectra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemOneFragment extends Fragment {
    TextView t1, t2, t3, t4;
    Button b1;

    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_one, container, false);


        b1 = (Button) view.findViewById(R.id.button);
        t1 = (TextView) view.findViewById(R.id.textView);
        t2 = (TextView) view.findViewById(R.id.textView2);
        t3 = (TextView) view.findViewById(R.id.textView3);
        Format formatter = new SimpleDateFormat("MMMM");
        String s = formatter.format(new Date());

        t1.setText(s);
        Format formatter2 = new SimpleDateFormat("dd");
        String s2 = formatter2.format(new Date());

        t2.setText(s2);
        Format formatter3 = new SimpleDateFormat("EEEE-yyyy");
        String s3 = formatter3.format(new Date());

        t3.setText(s3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FirebaseActivity.class));
            }
        });

        return view;
    }
}
