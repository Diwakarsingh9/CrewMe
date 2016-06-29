package com.example.apporio6.crewme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.apporio6.crewme.MainActivity;
import com.example.apporio6.crewme.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by apporio6 on 24-06-2016.
 */
public class SampleAdapter extends BaseAdapter{

    ArrayList<Integer> all = new ArrayList<>();
    Context c;
    final LayoutInflater inflater;

    public SampleAdapter(Context mainActivity, ArrayList<Integer> al) {
        this.c = mainActivity;
        this.all = al;
        inflater = LayoutInflater.from(this.c);

    }

    @Override
    public int getCount() {
        return all.size();
    }

    @Override
    public Object getItem(int position) {
        return all.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class Holder {
    public CircularImageView imageperson;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;

        if(convertView==null) {
            convertView = inflater.inflate(R.layout.items, null);
            holder = new Holder();
            convertView.setTag(holder);


        }
        else {
            holder = (Holder)convertView.getTag();
        }

        holder.imageperson = (CircularImageView)convertView.findViewById(R.id.helloText);
        holder.imageperson.setImageResource(all.get(position));

        return convertView;
    }

}
