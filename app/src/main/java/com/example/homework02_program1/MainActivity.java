//=====================================================
//Author: Mason McLaughlin
//Date: 09/14/24
//Desc: HW02 RGB
//=====================================================
package com.example.homework02_program1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //create seekbar, textview, button and listview
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hexRep;

    Button btn_j_saveColor;

    ListView lv_j_listOfColors;

    //global variables to track RGB
    int red = 255;
    int green = 255;
    int blue = 255;

    String hex = String.format("#%02X%02X%02X", 255,255,255);
    //used to change background color;
    View background;

    ArrayList<ColorInfo> listOfColors;


    ColorListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        tv_j_red            = findViewById(R.id.tv_v_red);
        tv_j_green          = findViewById(R.id.tv_v_green);
        tv_j_blue           = findViewById(R.id.tv_v_blue);
        tv_j_hexRep         = findViewById(R.id.tv_v_hexRep);

        sb_j_red            = findViewById(R.id.sb_v_red);
        sb_j_green          = findViewById(R.id.sb_v_green);
        sb_j_blue           = findViewById(R.id.sb_v_blue);

        btn_j_saveColor     = findViewById(R.id.btn_v_saveColor);

        lv_j_listOfColors   = findViewById(R.id.lv_v_listOfColors);

        background          = findViewById(R.id.main);

        sb_j_red.setMax(255);
        sb_j_green.setMax(255);
        sb_j_blue.setMax(255);

        tv_j_red.setText("Red: 255");
        tv_j_green.setText("Green: 255");
        tv_j_blue.setText("Blue: 255");
        tv_j_hexRep.setText("Hex representation: " + hex);

        //event listeners
        redSeekBarEventListener();
        greenSeekBarEventListener();
        blueSeekBarEventListener();
        saveColorButtonEvent();
        lvOnClickListener();

        listOfColors = new ArrayList<ColorInfo>();

        fillListView();


    }


    private void redSeekBarEventListener()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_red.setText("Red: " + String.valueOf(i));
                red = i;
                changeBackground();
                if(red <= 100 && green <= 100 && blue <= 100)
                {
                    tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else
                {
                    tv_j_red.setTextColor(Color.parseColor("#000000"));
                    tv_j_blue.setTextColor(Color.parseColor("#000000"));
                    tv_j_green.setTextColor(Color.parseColor("#000000"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#000000"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    private void greenSeekBarEventListener()
    {
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_green.setText("Green: " + String.valueOf(i));
                green = i;
                changeBackground();
                if(red <= 100 && green <= 100 && blue <= 100)
                {
                    tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else
                {
                    tv_j_red.setTextColor(Color.parseColor("#000000"));
                    tv_j_blue.setTextColor(Color.parseColor("#000000"));
                    tv_j_green.setTextColor(Color.parseColor("#000000"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#000000"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void blueSeekBarEventListener()
    {
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_blue.setText("Blue: " + String.valueOf(i));
                blue = i;
                changeBackground();
                if(red <= 100 && green <= 100 && blue <= 100)
                {
                    tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else
                {
                    tv_j_red.setTextColor(Color.parseColor("#000000"));
                    tv_j_blue.setTextColor(Color.parseColor("#000000"));
                    tv_j_green.setTextColor(Color.parseColor("#000000"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#000000"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
    }

    private void changeBackground()
    {
        hex = String.format("#%02X%02X%02X", red,green,blue);

        background.setBackgroundColor(Color.parseColor(hex));

        tv_j_hexRep.setText("Hex Representation: " + hex);
    }

    private void saveColorButtonEvent()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                addColorToList();

                //listColorData();
            }
        });
    }

    private void addColorToList()
    {
        ColorInfo colorToAdd = new ColorInfo(red,green,blue,hex);

        listOfColors.add(colorToAdd);
        Log.d("Color Added", "Color was added to the list");

        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);

        tv_j_red.setText("Red: 255");
        tv_j_green.setText("Green: 255");
        tv_j_blue.setText("Blue: 255");
        tv_j_hexRep.setText("Hex representation: " + hex);

        adapter.notifyDataSetChanged();
    }

    private void fillListView ()
    {
        adapter = new ColorListAdapter(this, listOfColors);


        lv_j_listOfColors.setAdapter(adapter);


    }

    private void listColorData()
    {
        for (int i = 0; i < listOfColors.size();i++)
        {
            Log.d("red: ", listOfColors.get(i).getRed() + "");
        }
    }

    private void lvOnClickListener()
    {
        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Log.d("onItemClick: ", "You Clicked Item: " + l + " at position " + position);

                background.setBackgroundColor(Color.parseColor(listOfColors.get(position).getHex()));

                tv_j_red.setText("Red: " + String.valueOf(listOfColors.get(position).getRed()));
                red = listOfColors.get(position).getRed();
                sb_j_red.setProgress(red);
                tv_j_green.setText("Green: " + String.valueOf(listOfColors.get(position).getGreen()));
                green = listOfColors.get(position).getGreen();
                sb_j_green.setProgress(green);
                tv_j_blue.setText("Blue: " + String.valueOf(listOfColors.get(position).getBlue()));
                blue = listOfColors.get(position).getBlue();
                sb_j_blue.setProgress(blue);
                if(red <= 100 && green <= 100 && blue <= 100)
                {
                    tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else
                {
                    tv_j_red.setTextColor(Color.parseColor("#000000"));
                    tv_j_blue.setTextColor(Color.parseColor("#000000"));
                    tv_j_green.setTextColor(Color.parseColor("#000000"));
                    tv_j_hexRep.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
    }
}