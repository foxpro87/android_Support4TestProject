package com.sbwoo.support4test.others;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sbwoo.support4test.R;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView selectedText = (TextView) findViewById(R.id.selectedText);


        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < 100; i++) {
            final Button myButton = new Button(this);
            myButton.setText("Button - " + i);
            ll.addView(myButton, lp);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Random rnd = new Random();
                    int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                    int inverseColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                    selectedText.setBackgroundColor(color);
                    //selectedText.setTextColor(Color.WHITE);
                    selectedText.setTextColor(inverseColor);
                    selectedText.setText(myButton.getText().toString());

                }
            });
        }
    }

    private int getInverseColor(int color){
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = Color.alpha(color);
        return Color.argb(alpha, 255-red, 255-green, 255-blue);
    }
}
