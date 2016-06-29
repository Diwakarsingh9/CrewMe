package com.example.apporio6.crewme.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.apporio6.crewme.Adapter.SampleAdapter;
import com.example.apporio6.crewme.R;
import com.example.apporio6.crewme.SpecificProfileActivity;
import com.example.apporio6.crewme.flingswipe.SwipeFlingAdapterView;
import com.example.apporio6.crewme.networkchecker.NetworkChecker;
import com.example.apporio6.crewme.views.ProgressWheel;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by apporio6 on 27-06-2016.
 */
public class Home_Fragment extends Fragment {
    Context ctc;
    private ArrayList<Integer> al;
    private SampleAdapter arrayAdapter;
    private int i;


    SwipeFlingAdapterView flingContainer;
    LinearLayout llforerror, llforpb,llforcards;
    ImageView home,chat,maps,tickets,unlock,settings,pbimage,searchagain,imagehide,imagehide2,imagehide3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        ctc = getActivity();
        pbimage = (ImageView)v.findViewById(R.id.pbimage);
        imagehide = (ImageView)v.findViewById(R.id.imgh);
        imagehide2 = (ImageView)v.findViewById(R.id.imh2);
        imagehide3 = (ImageView)v.findViewById(R.id.imgh3);
        searchagain = (ImageView)v.findViewById(R.id.searchagain);
        llforerror = (LinearLayout)v.findViewById(R.id.llforerror);
        llforpb = (LinearLayout)v.findViewById(R.id.llforprogress);
        llforcards = (LinearLayout)v.findViewById(R.id.llforcards);
        flingContainer = (SwipeFlingAdapterView)v.findViewById(R.id.frame);
        llforerror.setVisibility(View.GONE);
        llforpb.setVisibility(View.GONE);
        llforcards.setVisibility(View.GONE);

        searchagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread();

            }
        });

        pbimage.startAnimation(
                AnimationUtils.loadAnimation(ctc, R.anim.anima));


        fadeIn();
        fadeIn2();
        fadeIn3();


        al = new ArrayList<>();
        al.add(R.drawable.man);
        al.add(R.drawable.woman);
        al.add(R.drawable.man);
        al.add(R.drawable.woman);
        al.add(R.drawable.man);
        al.add(R.drawable.woman);
        al.add(R.drawable.man);
        al.add(R.drawable.woman);
        al.add(R.drawable.man);
        al.add(R.drawable.woman);
        al.add(R.drawable.man);
        al.add(R.drawable.woman);
        arrayAdapter = new SampleAdapter(ctc,al);

        flingContainer.setAdapter(arrayAdapter);

        flingContainer.setFlingListener(new SwipeFlingAdapterView.OnSwipeListener() {
            @Override
            public Pair<Boolean, Boolean> isEnabled() {
                return new Pair<>(true, true);
            }

            @Override
            public void onTopExited() {
                al.remove(0);
                al.add(R.drawable.woman);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onExitToLeft(View dataObject) {
                makeToast(ctc, "Exit!");
            }

            @Override
            public void onExitToRight(View dataObject) {
                makeToast(ctc, "Boarding!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                al.add(R.drawable.appicon);
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onFlingTopView(float offset) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(offset < 0 ? -offset : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(offset > 0 ? offset : 0);

            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), SpecificProfileActivity.class);
                startActivity(i);
                makeToast(ctc, "Clicked!");
            }
        });


        return v;
    }
    private void startThread() {
        llforpb.setVisibility(View.VISIBLE);
        llforerror.setVisibility(View.GONE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getTheGPS_BRO();
            }
        }, 1000);
    }

    private void getTheGPS_BRO() {
        if(new NetworkChecker().isNetworkConnected(ctc)){
            llforerror.setVisibility(View.GONE);
            llforpb.setVisibility(View.GONE);
            llforcards.setVisibility(View.VISIBLE);
        }
        else
        {
            llforpb.setVisibility(View.GONE);
            llforerror.setVisibility(View.VISIBLE);
            llforcards.setVisibility(View.GONE);
        }
    }

    private void fadeIn() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide, "alpha", 0f, 1f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOut();
            }
        });
        objectAnimator.start();
    }

    private void fadeOut() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide, "alpha", 1f, 0f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeIn();
            }
        });
        objectAnimator.start();
    }

    private void fadeIn2() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide2, "alpha", 0f, 1f);
        objectAnimator.setDuration(1000L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fadeOut2();
                    }
                }, 2000);
            }
        });
        objectAnimator.start();
    }

    private void fadeOut2() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide2, "alpha", 1f, 0f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeIn2();
            }
        });
        objectAnimator.start();
    }
    private void fadeIn3() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide3, "alpha", 0f, 1f);
        objectAnimator.setDuration(500L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOut3();
            }
        });
        objectAnimator.start();
    }

    private void fadeOut3() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imagehide3, "alpha", 1f, 0f);
        objectAnimator.setDuration(1000L);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fadeIn3();

                    }
                }, 2000);
            }
        });

        objectAnimator.start();
    }


    @Override
    public void onResume() {

        super.onResume();
        startThread();
       // parsingforcategories.parsing(ctc);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }
    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.right)
    public void right() {
        /**
         * Trigger the right event manually.
         */
        flingContainer.getTopCardListener().swipeToRight();
    }

    @OnClick(R.id.left)
    public void left() {
        flingContainer.getTopCardListener().swipeToLeft();
    }

}
