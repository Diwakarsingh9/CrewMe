package com.example.apporio6.crewme.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.apporio6.crewme.R;

import java.util.ArrayList;




/**
 * Created by saifi45 on 8/9/2015.
 */

    public class Basefragmentforphotoopen extends Fragment {
        static String ds2;
        public  static  int y;
    TextView title, copy;
    int d;
//    private ImageLoader mImageLoader;
    ArrayList<String> photos = new ArrayList<>();
//
public  static ImageView img;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layoutforphotoopen, null);

           img = (ImageView)root.findViewById(R.id.imageView);

            d= getArguments().getInt("msg");
//            photos = getArguments().getStringArrayList("msg3");
            int de= getArguments().getInt("msg2");
//            mImageLoader = VolleySingleton.getInstance(getContext())
//                    .getImageLoader();
//            mImageLoader.get(""+de.replace(" ","%20"), ImageLoader.getImageListener(img,
//                    R.drawable.stub, R.drawable
//                            .errorimg));
//            img.setImageUrl(""+de.replace(" ","%20"), mImageLoader);
//            img.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent in = new Intent(getActivity(),Photoinneractivity.class);
//                    in.putExtra("position", d);
//                    in.putStringArrayListExtra("list",photos);
//                    startActivity(in);

                    //Toast.makeText(getActivity(), ""+d, Toast.LENGTH_SHORT).show();
//                }
//            });
            img.setImageResource(de);

//            title.setText(de);
//            Picasso.with(getActivity())
//                    .load("http://meetsingh.com/" + d)
//                    .placeholder(R.drawable.reall2) // optional
//                    .error(R.drawable.reaal2222l)         // optional
//                    .into(img);


            return root;
        }


        public static Basefragmentforphotoopen newInstance(int position, int s) {
            Basefragmentforphotoopen f = new Basefragmentforphotoopen();
            Bundle b = new Bundle();
            b.putInt("msg", position);
            b.putInt("msg2", s);
//            b.putStringArrayList("msg3", farray);
            // y=ber;
            f.setArguments(b);

            return f;
        }
    }

