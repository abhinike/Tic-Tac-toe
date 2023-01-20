package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    public TextView status = findViewById(R.id.statusview);



    int startgame;

    int[] gridarray = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int activeplayer = 1;

    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};

    public void taptap(View view) {
        ImageView img = (ImageView)view;
        int tappedview = Integer.parseInt(img.getTag().toString());


        if (gridarray[tappedview]== 2 && startgame==101  ){
            if (activeplayer==1){
                activeplayer=0;
                img.setImageResource(R.drawable.x);
                gridarray[tappedview]=1;
                TextView status = findViewById(R.id.statusview);
                status.setText("'O' turn");
            }
            else {
                activeplayer = 1;
                img.setImageResource(R.drawable.o);
                gridarray[tappedview]=0;
                TextView status = findViewById(R.id.statusview);
                status.setText("'X' turn");
            }

        }

        for (int[] winposition:winPositions) {
            if (gridarray[winposition[0]]==gridarray[winposition[1]]
                    && gridarray[winposition[1]] == gridarray[winposition[2]]
                    && gridarray[winposition[0]]!=2){
                String winnerStr;

                if(gridarray[winposition[0]] == 0){
                    winnerStr = "O has won";
                    startgame=100;
                }
                else{
                    winnerStr = "X has won";
                    startgame = 100;

                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.statusview);
                status.setText(winnerStr);
                }
            }
            
        }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void reset(View view) {
        for (int i = 0; i < 9; i++) {
            gridarray[i]=2;
        }
        ((ImageView)findViewById(R.id.textview0)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview1)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview2)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview3)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview4)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview5)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview6)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview7)).setImageResource(0);
        ((ImageView)findViewById(R.id.textview8)).setImageResource(0);

        TextView status = findViewById(R.id.statusview);
        status.setText("press start to play");
        startgame = 100;

        activeplayer=1;

    }

    public void start(View view) {
        startgame=101;
       TextView status = findViewById(R.id.statusview);
        status.setText("'X' turn");
    }
}