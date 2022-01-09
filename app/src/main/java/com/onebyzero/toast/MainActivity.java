package com.onebyzero.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.onebyzero.customtoast.CustomToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.warning(MainActivity.this,"Warning Toast", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.success(MainActivity.this,"Success Toast",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.allCustom(MainActivity.this,"Fully custom toast. Ugly as ... :)",R.drawable.ic_info_black_36dp,
                        R.color.infoColor,100,100,25, Typeface.SANS_SERIF, Gravity.TOP, 0,4,Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.allCustom(MainActivity.this)
                        .setTypeFace(Typeface.DEFAULT_BOLD)
                        .setTextSize(16)
                        .setCardRadius(25)
                        .setCardElevation(10)
                        .setIcon(R.drawable.ic_error_black_24dp)
                        .setCardBackgroundColor(R.color.colorAccent)
                        .setMessage("Fully customizable toast. But in a different way.")
                        .setGravity(Gravity.CENTER,5,5)
                        .createToast(Toast.LENGTH_LONG)
                        .show();

            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.error(MainActivity.this,"Error Toast.",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.error(MainActivity.this,"Error Toast.",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomToast.error(MainActivity.this,"Error Toast.",Toast.LENGTH_LONG).show();
            }
        });
    }
}