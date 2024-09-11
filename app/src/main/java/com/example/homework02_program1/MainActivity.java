package com.example.homework02_program1;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SeekBar sk_j_test;

    TextView tv_j_getTestValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sk_j_test = findViewById(R.id.sb_v_test);
        tv_j_getTestValue = findViewById(R.id.tv_v_getTestValue);

        sk_j_test.setMax(255);

        testEventListener();


    }

    private void testEventListener()
    {
        sk_j_test.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //Log.d("SeekBar Test: " , "SeekBar listener is working");
                tv_j_getTestValue.setText(String.valueOf(i));
                android
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}