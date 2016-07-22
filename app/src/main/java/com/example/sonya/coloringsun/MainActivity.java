package com.example.sonya.coloringsun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

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
    int currentColor = YELLOW_COLOR;
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
    private Button buttonXY;
    private Button buttonColor;

    private LinearLayout borderRed;
    private LinearLayout borderOrange;
    private LinearLayout borderYellow;
    private LinearLayout borderGreen;
    private LinearLayout borderBlue;
    private LinearLayout borderDarkBlue;
    private LinearLayout borderViolet;
    private LinearLayout borderGrey;
    private LinearLayout borderPink;
    private LinearLayout borderBrown;

    private ImageView imageView;
    private float imageViewWidth;
    private float imageViewHeight;
    private float bitmapWidth;
    private float bitmapHeight;
    private Bitmap bitmap;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageView);
        //imageView.set


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                imageViewWidth = imageView.getWidth();
                imageViewHeight = imageView.getHeight();
                float wc = bitmapWidth / imageViewWidth;
                float hc = bitmapHeight / imageViewHeight;

                if (wc > hc) {
                    imageViewHeight = (int) (bitmapHeight / wc);


                } else {
                    imageViewWidth = (int) (bitmapWidth / hc);

                }

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //recreateFiller();
                    float x = event.getX();
                    float y = event.getY();
                    x = x / imageViewWidth * bitmapWidth;
                    y = y / imageViewHeight * bitmapHeight;
                    int xx = (int) x;
                    int yy = (int) y;

                    if (xx < bitmapWidth && yy < bitmapHeight) {
                        Point pt = new Point(xx, yy);
                        buttonXY.setText(String.format("%d %d", xx, yy));
                        buttonColor.setBackgroundColor(bitmap.getPixel(xx, yy));
                        filler.setFillColor(currentColor);
                        filler.floodFill(xx, yy);
                        bitmap = filler.getImage();

                        render();

                    }


                }
                return true;
            }
        });

        buttonXY = (Button) findViewById(R.id.buttonXY);

        buttonColor = (Button) findViewById(R.id.buttonColor);
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //supermanTextView.setBackgroundColor(Color.YELLOW);
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                //intent.putExtra("key", supermanTextView.getText().toString());
                startActivity(intent);
            }
        });

        recreateFiller();


        buttonRed = (Button) findViewById(R.id.buttonRed);
        buttonRed.setBackgroundColor(redColor);
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = redColor;
                resetBorderColors();
                borderRed.setBackgroundColor(Color.BLACK);

                render();
            }
        });

        buttonOrange = (Button) findViewById(R.id.buttonOrange);
        buttonOrange.setBackgroundColor(orangeColor);
        buttonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = orangeColor;
                resetBorderColors();
                borderOrange.setBackgroundColor(Color.BLACK);
                render();
            }
        });

        buttonYellow = (Button) findViewById(R.id.buttonYellow);
        buttonYellow.setBackgroundColor(yellowColor);
        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = yellowColor;
                resetBorderColors();
                borderYellow.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonGreen = (Button) findViewById(R.id.buttonGreen);
        buttonGreen.setBackgroundColor(greenColor);
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = greenColor;
                resetBorderColors();
                borderGreen.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonBlue.setBackgroundColor(blueColor);
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = blueColor;
                resetBorderColors();
                borderBlue.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonDarkBlue = (Button) findViewById(R.id.buttonDarkBlue);
        buttonDarkBlue.setBackgroundColor(darkBlueColor);
        buttonDarkBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = darkBlueColor;
                resetBorderColors();
                borderDarkBlue.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonViolet = (Button) findViewById(R.id.buttonViolet);
        buttonViolet.setBackgroundColor(violetColor);
        buttonViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = violetColor;
                resetBorderColors();
                borderViolet.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonGrey = (Button) findViewById(R.id.buttonGrey);
        buttonGrey.setBackgroundColor(greyColor);
        buttonGrey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = greyColor;
                resetBorderColors();
                borderGrey.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonPink = (Button) findViewById(R.id.buttonPink);
        buttonPink.setBackgroundColor(pinkColor);
        buttonPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = pinkColor;
                resetBorderColors();
                borderPink.setBackgroundColor(Color.BLACK);
                render();
            }
        });
        buttonBrown = (Button) findViewById(R.id.buttonBrown);
        buttonBrown.setBackgroundColor(brownColor);
        buttonBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColor = brownColor;
                resetBorderColors();
                borderBrown.setBackgroundColor(Color.BLACK);
                render();
            }
        });

        borderRed = (LinearLayout) findViewById(R.id.borderRed);
        borderRed.setBackgroundColor(redColor);

        borderOrange = (LinearLayout) findViewById(R.id.borderOrange);
        borderOrange.setBackgroundColor(orangeColor);

        borderYellow = (LinearLayout) findViewById(R.id.borderYellow);
        borderYellow.setBackgroundColor(Color.BLACK);

        borderGreen = (LinearLayout) findViewById(R.id.borderGreen);
        borderGreen.setBackgroundColor(greenColor);

        borderBlue = (LinearLayout) findViewById(R.id.borderBlue);
        borderBlue.setBackgroundColor(blueColor);

        borderDarkBlue = (LinearLayout) findViewById(R.id.borderDarkBlue);
        borderDarkBlue.setBackgroundColor(darkBlueColor);

        borderViolet = (LinearLayout) findViewById(R.id.borderViolet);
        borderViolet.setBackgroundColor(violetColor);

        borderGrey = (LinearLayout) findViewById(R.id.borderGrey);
        borderGrey.setBackgroundColor(greyColor);

        borderPink = (LinearLayout) findViewById(R.id.borderPink);
        borderPink.setBackgroundColor(pinkColor);

        borderBrown = (LinearLayout) findViewById(R.id.borderBrown);
        borderBrown.setBackgroundColor(brownColor);


    }


    private void render() {
        imageView.setImageBitmap(null);
        imageView.setImageBitmap(bitmap);
        imageView.invalidate();

    }

    private void recreateFiller() {
        try {
            bitmap = BitmapFactory.decodeStream(getAssets().open("18789.jpg"));
            bitmapHeight = bitmap.getHeight();
            bitmapWidth = bitmap.getWidth();
            buttonXY.setText(String.format("%d %d", bitmap.getWidth(), bitmap.getHeight()));
            filler = new QueueLinearFloodFiller(bitmap);
            filler.setFillColor(currentColor);
            filler.setTargetColor(targetColor);
            filler.setTolerance(100);
            Point pt = new Point(1, 1);
//            filler.floodFill(1, 1);
            bitmap = filler.getImage();

            render();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetBorderColors() {
        borderRed.setBackgroundColor(redColor);

        borderOrange.setBackgroundColor(orangeColor);

        borderYellow.setBackgroundColor(yellowColor);

        borderGreen.setBackgroundColor(greenColor);

        borderBlue.setBackgroundColor(blueColor);

        borderDarkBlue.setBackgroundColor(darkBlueColor);

        borderViolet.setBackgroundColor(violetColor);

        borderGrey.setBackgroundColor(greyColor);

        borderPink.setBackgroundColor(pinkColor);

        borderBrown.setBackgroundColor(brownColor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        String s = preferences.getString("name", "не найдено");
        //supermanTextView.setText(s);
    }

}
