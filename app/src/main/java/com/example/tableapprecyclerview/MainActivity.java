package com.example.tableapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    TextView textView1 ;


    public void generateDataInRecclerView(int tableNum)
    {
        ArrayList<String> tables = new ArrayList<>();
        for(int i = 1; i<=100 ;i++)
        {
            tables.add(Integer.toString(i*tableNum));
        }

        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(new TablesRecyclerViewAdapter(tables,this));
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = findViewById(R.id.recyclerview);
        SeekBar seekBar = findViewById(R.id.seekBar);
        int max = 20;
        int min = 1;
        int startingposition= 10;
        seekBar.setMax(max);
        seekBar.setProgress(startingposition);

        generateDataInRecclerView(startingposition);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int tablenum;
                if (progress<min)
                {
                    tablenum = min;
                    seekBar.setProgress(tablenum);
                }
                else
                {
                    tablenum = progress;
                }
                Log.d("Seek", "Value :"+ tablenum);
                textView1= findViewById(R.id.textView) ;
                textView1.setText(Integer.toString(tablenum));
                generateDataInRecclerView(tablenum);
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