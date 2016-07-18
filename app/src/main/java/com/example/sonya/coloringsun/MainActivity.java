package com.example.sonya.coloringsun;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    int targetColor = Color.WHITE;
    int newColor = Color.BLUE;
    QueueLinearFloodFiller filler;
    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageView);
        try {
            bitmap = BitmapFactory.decodeStream(getAssets().open("18789.jpg"));
            filler = new QueueLinearFloodFiller(bitmap);
            filler.setFillColor(newColor);
            filler.setTargetColor(targetColor);
            filler.setTolerance(100);
            Point pt = new Point(1, 1);
            filler.floodFill(1, 1);
            bitmap = filler.getImage();

            render();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void render() {
        imageView.setImageBitmap(bitmap);

    }


}
