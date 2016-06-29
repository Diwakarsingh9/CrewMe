package com.example.apporio6.crewme;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.apporio6.crewme.Fragments.Settings_Fragment;

public class CountryActivity extends Activity {
    ListView lv;
    LinearLayout back;
    String data[]={"Afghanistan","India","Pakistan","Indonesia","China"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        statusbar.setStatusBarColor(CountryActivity.this,R.color.backgroundcolor);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        lv=(ListView)findViewById(R.id.listView2);
        back = (LinearLayout) findViewById(R.id.llforbck);
        lv.setAdapter(new ArrayAdapter(CountryActivity.this,R.layout.itemlayoutforcountry,
                R.id.shw,data));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Settings_Fragment.countrytext.setText(""+data[position]);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
