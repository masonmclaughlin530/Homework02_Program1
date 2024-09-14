package com.example.homework02_program1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hexRep;

    int red = 255;
    int green = 255;
    int blue = 255;

    String hex = String.format("#%02X%02X%02X", 255,255,255);

    View background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        tv_j_red        = findViewById(R.id.tv_v_red);
        tv_j_green      = findViewById(R.id.tv_v_green);
        tv_j_blue       = findViewById(R.id.tv_v_blue);
        tv_j_hexRep     = findViewById(R.id.tv_v_hexRep);

        sb_j_red        = findViewById(R.id.sb_v_red);
        sb_j_green      = findViewById(R.id.sb_v_green);
        sb_j_blue       = findViewById(R.id.sb_v_blue);

        background      = findViewById(R.id.main);

        sb_j_red.setMax(255);
        sb_j_green.setMax(255);
        sb_j_blue.setMax(255);

        tv_j_red.setText("255");
        tv_j_green.setText("255");
        tv_j_blue.setText("255");
        tv_j_hexRep.setText("Hex representation: " + hex);

        redSeekBarEventListener();
        greenSeekBarEventListener();
        blueSeekBarEventListener();



    }


    private void redSeekBarEventListener()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_red.setText(String.valueOf(i));
                red = i;
                changeBackground();
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
                tv_j_green.setText(String.valueOf(i));
                green = i;
                changeBackground();
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
                tv_j_blue.setText(String.valueOf(i));
                blue = i;
                changeBackground();
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
}