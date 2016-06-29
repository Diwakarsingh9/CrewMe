package com.example.apporio6.crewme.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apporio6.crewme.R;
import com.example.apporio6.crewme.networkchecker.ConnectionDetector;
import com.example.apporio6.crewme.views.ProgressWheel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by apporio6 on 27-06-2016.
 */
public class Maps_fragment extends Fragment {
    Context ctc;
    MapView mapView;
    Bitmap bmImg;
    public static Boolean isInternetPresent = false;
    public static GoogleMap map;
    public static ProgressWheel pb;
    public static ConnectionDetector cd;
    public static Double currentlat, currentlong;
    public static  String lat2 []={"28.595520","28.5465205","28.5655205","28.5555205","28.5455205"};
    public static  String long2 []={"77.23195220000001","77.25195220000001","77.26195220000001","77.22195220000001","77.27195220000001"};

    TextView mile,km,man,woman;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.maps_fragment, container, false);
        ctc = getActivity();
        mapView = (MapView)v.findViewById(R.id.mapgh);
        mapView.onCreate(savedInstanceState);
        cd = new ConnectionDetector(ctc);
        currentlat= 28.555520;
        currentlong= 77.23195220000001;
        return v;
    }
    public void getthetracker(String clientLatitude, String clientLongitude) {

        MapsInitializer.initialize(getActivity());
        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())) {
            case ConnectionResult.SUCCESS:
                isInternetPresent =cd.isConnectingToInternet();

                // check for Internet status
                if (isInternetPresent) {
                    //Toast.makeText(ctc, "tracker", Toast.LENGTH_SHORT).show();
                    // Gets to GoogleMap from the MapView and does initialization stuff
                    if (mapView != null) {
                        map = mapView.getMap();
                        map.clear();
                        map.getUiSettings().setMyLocationButtonEnabled(false);
                        LatLng curentpoint = new LatLng(Double.parseDouble(clientLatitude),
                                Double.parseDouble(clientLongitude));
                        map.addMarker(new MarkerOptions()
                                .position(curentpoint)
                                .title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.markerforcurrent)));

                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(curentpoint).zoom(13).build();

                        map.animateCamera(CameraUpdateFactory
                                .newCameraPosition(cameraPosition));
                        new LongOperation().execute("");


                    }





                } else {
                    // Internet connection is not present
                    // Ask user to connect to Internet
                    Toast.makeText(ctc, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }



                break;
            case ConnectionResult.SERVICE_MISSING:
                Toast.makeText(ctc, "SERVICE MISSING", Toast.LENGTH_SHORT).show();
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                Toast.makeText(ctc, "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(ctc, GooglePlayServicesUtil.isGooglePlayServicesAvailable(ctc), Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
        getthetracker(""+currentlat,""+currentlong);
//        parsing(ctc);


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
    private class LongOperation extends AsyncTask<String, Void, String> {
        Bitmap bmp;
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL("http://gnubiff.sourceforge.net/images/tux-sit-small.png");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);
            }
            catch (Exception e){
                Log.e("err",""+e);
            }
            Bitmap.Config conf = Bitmap.Config.ARGB_8888;
             bmp = Bitmap.createBitmap(80, 80, conf);
            Canvas canvas1 = new Canvas(bmp);

// paint defines the text color, stroke width and size
            Paint color = new Paint();
            color.setTextSize(35);
            color.setColor(Color.BLACK);

// modify canvas
            canvas1.drawBitmap((bmImg), 0, 0, color);
//            canvas1.drawText("", 30, 40, color);
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
            for(int i=0;i<lat2.length;i++) {
                map.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(lat2[i]),
                        Double.parseDouble(long2[i])))
                        .icon(BitmapDescriptorFactory.fromBitmap(bmp))
                                // Specifies the anchor to be at a particular point in the marker image.
                        .anchor(0.5f, 1));
            }

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}
