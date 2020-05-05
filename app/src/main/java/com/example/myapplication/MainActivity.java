package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SeekBar rücken;
    private EditText rücken1;
    private SeekBar sitzt;
    private EditText sitzt1;
    private SeekBar fuß;
    private EditText fuß1;
    private Button button0;
    private Button button15;
    private Button button30;


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        rücken.setProgress(rücken.getProgress());
        sitzt.setProgress(sitzt.getProgress());
        fuß.setProgress(fuß.getProgress());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rücken = (SeekBar)findViewById(R.id.red_Seek_Bar);
        rücken1 = (EditText) findViewById(R.id.red_Edit_Text);
        rücken1.setText("" + rücken.getProgress());


        rücken.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
              rücken1.setText("" + progress);

          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });


        sitzt = (SeekBar)findViewById(R.id.green_Seek_Bar);
        sitzt1 = (EditText)findViewById(R.id.green_Edit_Text);
        sitzt1.setText("" + sitzt.getProgress());

        sitzt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                sitzt1.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fuß = (SeekBar)findViewById(R.id.blue_Seek_Bar);
        fuß1 = (EditText)findViewById(R.id.blue_Edit_Text);
        fuß1.setText("" + fuß.getProgress());

        fuß.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                fuß1.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rücken1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String in = rücken1.getText().toString();
                int grad = Integer.parseInt(in);
                rücken.setProgress(grad);
                if (grad < 0){
                    rücken1.setText(0);
                }
                int  limit = 0;
                if (grad > 87){
                    rücken1.setText((""+limit));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sitzt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String in = sitzt1.getText().toString();
                int grad = Integer.parseInt(in);
                sitzt.setProgress(grad);
                int  limit = 0;
                if (grad > 30){
                    sitzt1.setText((""+limit));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fuß1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String in = fuß1.getText().toString();
                int grad = Integer.parseInt(in);
                fuß.setProgress(grad);
                int  limit = 0;
                if (grad > 90){
                    fuß1.setText((""+limit));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button0 = (Button)findViewById(R.id.R0);
        button15 = (Button)findViewById(R.id.G15);
        button30 = (Button)findViewById(R.id.B30);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rücken.setProgress(0);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sitzt.setProgress(15);
            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuß.setProgress(30);
            }
        });
    }

}
