package com.example.sonya.coloringsun;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    final int RED_COLOR = Color.parseColor("#fb0303");
    final int ORANGE_COLOR = Color.parseColor("#fb8b03");
    final int YELLOW_COLOR = Color.parseColor("#fbe603");
    final int GREEN_COLOR = Color.parseColor("#49fb03");
    final int BLUE_COLOR = Color.parseColor("#03a8fb");
    final int DARKBLUE_COLOR = Color.parseColor("#0328fb");
    final int VIOLET_COLOR = Color.parseColor("#7b03fb");
    final int GREY_COLOR = Color.parseColor("#7e7e7e");
    final int PINK_COLOR = Color.parseColor("#f99ef0");
    final int BROWN_COLOR = Color.parseColor("#9f551f");

    int redColor = RED_COLOR;
    int orangeColor = ORANGE_COLOR;
    int yellowColor = YELLOW_COLOR;
    int greenColor = GREEN_COLOR;
    int blueColor = BLUE_COLOR;
    int darkBlueColor = DARKBLUE_COLOR;
    int violetColor = VIOLET_COLOR;
    int greyColor = GREY_COLOR;
    int pinkColor = PINK_COLOR;
    int brownColor = BROWN_COLOR;
    // #fb0303

    int targetColor = Color.WHITE;
    int newColor = Color.BLUE;


    QueueLinearFloodFiller filler;
    private Button buttonRed;
    private Button buttonOrange;
    private Button buttonYellow;
    private Button buttonGreen;
    private Button buttonBlue;
    private Button buttonDarkBlue;
    private Button buttonViolet;
    private Button buttonGrey;
    private Button buttonPink;
    private Button buttonBrown;
    private ImageView imageView;
    private Bitmap bitmap;

    public MainActivity() {
    }

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

        buttonRed = (Button) findViewById(R.id.buttonRed);
        buttonRed.setBackgroundColor(redColor);
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });

        buttonOrange = (Button) findViewById(R.id.buttonOrange);
        buttonOrange.setBackgroundColor(orangeColor);
        buttonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });

        buttonYellow = (Button) findViewById(R.id.buttonYellow);
        buttonYellow.setBackgroundColor(yellowColor);
        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
        buttonGreen = (Button) findViewById(R.id.buttonGreen);
        buttonGreen.setBackgroundColor(greenColor);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
        buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonBlue.setBackgroundColor(blueColor);
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
        buttonDarkBlue = (Button) findViewById(R.id.buttonDarkBlue);
        buttonDarkBlue.setBackgroundColor(darkBlueColor);
        buttonDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
        buttonViolet = (Button) findViewById(R.id.buttonViolet);
        buttonViolet.setBackgroundColor(violetColor);
        buttonViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
        buttonGrey = (Button) findViewById(R.id.buttonGrey);
        buttonGrey.setBackgroundColor(greyColor);
        buttonGrey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
        buttonPink = (Button) findViewById(R.id.buttonPink);
        buttonPink.setBackgroundColor(pinkColor);
        buttonPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        }); buttonBrown = (Button) findViewById(R.id.buttonBrown);
        buttonBrown.setBackgroundColor(brownColor);
        buttonBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //a = a * 10 + 2;
                render();
            }
        });
    }


    private void render() {
        imageView.setImageBitmap(bitmap);

    }


}
