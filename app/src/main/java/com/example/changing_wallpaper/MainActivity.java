// API 22 (Pixel 2 XL API 22)
package com.example.changing_wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b;
    boolean r;
    int[] ia = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //we will check whether application is running
        if(!r){
            //schedule a timer
            new Timer().schedule(new MyTimer(),0,3000);
            r = true;
        }
    }
    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try{
                //Extaract a Wallpaper, setting A new wallpaper, changing Wallpaper----> all these handled by wallpaper manager
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                //Calling random class and creating a object
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
            }
             catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}