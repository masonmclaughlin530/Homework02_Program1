package com.example.homework02_program1;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;


    public ColorListAdapter(Context c, ArrayList<ColorInfo> lc)
    {
        context = c;
        listOfColors = lc;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
            //Log.d("GETVIEW IF STATEMENT", "In IF statement");
        }

        TextView red = view.findViewById(R.id.tv_v_cc_red);
        TextView green = view.findViewById(R.id.tv_v_cc_green);
        TextView blue = view.findViewById(R.id.tv_v_cc_blue);
        TextView hex = view.findViewById(R.id.tv_v_cc_hex);

        ColorInfo color = listOfColors.get(i);

        red.setText("Red: " + color.getRed());
        blue.setText("Blue: " + color.getBlue());
        green.setText("Green: " + color.getGreen());
        hex.setText("Hex: " + color.getHex());

        if(color.getRed() <= 100 && color.getGreen() <= 100 && color.getBlue() <= 100)
        {
            red.setTextColor(Color.parseColor("#FFFFFF"));
            blue.setTextColor(Color.parseColor("#FFFFFF"));
            green.setTextColor(Color.parseColor("#FFFFFF"));
            hex.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            red.setTextColor(Color.parseColor("#000000"));
            blue.setTextColor(Color.parseColor("#000000"));
            green.setTextColor(Color.parseColor("#000000"));
            hex.setTextColor(Color.parseColor("#000000"));
        }

        view.setBackgroundColor(Color.parseColor(color.getHex()));
        //Log.d("Get View", "In get view past the if statement");

        return view;
    }
}
