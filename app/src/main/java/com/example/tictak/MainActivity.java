package com.example.tictak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Player representation
    //0->X
    //1->O
    TextView textView;
    int activePlayer=0,count=0;
    int [] gameState={2,2,2,2,2,2,2,2,2};
    /*if gamestate is 0 then fill the cell with X
                    1 then fill the cell with O
                    2 then cell is empty*/

    int [][] winPositions={  {0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};


    boolean gameActive=true;
    public void playerTap(View view){


        ImageView img=(ImageView)view;
        int tappedImage;
        tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive)
        {
           gameReset(view);
           textView.setText("Tap for start the game");
           gameActive=true;
        }


        else if(gameState[tappedImage]==2 && gameActive)
        {
            gameState[tappedImage]=activePlayer;

            if(activePlayer==0){
                activePlayer=1;
                img.setImageResource(R.drawable.x);
                textView.setText("O's turn");
            }
            else
            {
                activePlayer=0;
                img.setImageResource(R.drawable.o);
                textView.setText("X's turn");
            }

            for(int [] winPosition:winPositions){
                if(gameState[winPosition[0]]==gameState[winPosition[1]]&&gameState[winPosition[1]]==gameState[winPosition[2]]
                        &&gameState[winPosition[0]]!=2)
                {
                    if (gameState[winPosition[0]]==0) {
                        textView.setText("X has won the game \n Tap for reset the game");
                    gameActive=false;
                    }
                    else
                    {textView.setText("O has won the game\n Tap for reset the game ");
                        gameActive=false;
                }
                }


            }

        }


    }

    public void gameReset(View view)
    {

        activePlayer=0;
          for(int i=0;i<9;i++)
          {gameState[i]=2;}
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView1);
    }
}