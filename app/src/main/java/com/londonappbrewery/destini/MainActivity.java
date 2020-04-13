package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mTextView;
    private Button mButtonTop, mButtonBot;
    private int mStatus, mStep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBot = findViewById(R.id.buttonBottom);
        mStatus = 1;
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStep = 0;
                move();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStep = 1;
                move();
            }
        });

    }

    public void move(){
        switch (mStatus){
            case 1:
                if(1 == mStep){
                    mTextView.setText(R.string.T2_Story);
                    mButtonBot.setText(R.string.T2_Ans2);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mStatus = 2;
                }
                else {
                    mTextView.setText(R.string.T3_Story);
                    mButtonBot.setText(R.string.T3_Ans2);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mStatus = 3;
                }
                break;
            case 2:
                if(1 == mStep){
                    mTextView.setText(R.string.T4_End);
                    mButtonTop.setVisibility(GONE);
                    mButtonBot.setVisibility(GONE);
                }
                else {
                    mTextView.setText(R.string.T3_Story);
                    mButtonBot.setText(R.string.T3_Ans2);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mStatus = 3;
                }
                break;
            case 3:
                if(1 == mStep){
                    mTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(GONE);
                    mButtonBot.setVisibility(GONE);
                }
                else {
                    mTextView.setText(R.string.T6_End);
                    mButtonTop.setVisibility(GONE);
                    mButtonBot.setVisibility(GONE);
                }
                break;
            default:
        }
    }
}
