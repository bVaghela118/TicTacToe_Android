package com.example.tictaktoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
        boolean gameactive = true;
        Button btn;
        // 0 - X
        // 1 - O
        int activeplayer = 0;
        int[] gamestate = {2,2,2,2,2,2,2,2,2};
        // state meanings;
        //0 - X
        //1 - O
        //2 - NULL
        int[][] winposition = {{0,1,2}, {3,4,5}, {6,7,8},
                                {0,3,6}, {1,4,7}, {2,5,8},
                                {0,4,8},  {2,4,6}};
        public void playerTap(final View view) throws InterruptedException {
            ImageView img= (ImageView)view;
            int tappedImage = Integer.parseInt(img.getTag().toString());
            if(!gameactive){
                gameReset(view);
            }
            if(gamestate[tappedImage]==2)
            {
                gamestate[tappedImage]=activeplayer;
                img.setTranslationY(-1000f);
                if(activeplayer ==0)
                {
                    img.setImageResource(R.drawable.x);
                    activeplayer =1;
                    TextView status =findViewById(R.id.textView2);
                    status.setText("O's Turn - Tap to Play");
                }else{
                    img.setImageResource(R.drawable.o);
                    activeplayer =0;
                    TextView status =findViewById(R.id.textView2);
                    status.setText("X's Turn - Tap to Play");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            for(int[] winposition: winposition){
                  if (gamestate[winposition[0]] == gamestate[winposition[1]] && gamestate[winposition[1]] == gamestate[winposition[2]] && gamestate[winposition[0]]!=2)
                  {
                    //Somebody has won !
                    String winner;
                    gameactive =false;
                    if(gamestate[winposition[0]]==0){
                        winner = "X has Won :)";
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setIcon(R.drawable.hurrah);
                        a_builder.setMessage("X has Won!!! " +
                                "Do you want to play again?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        gameReset(view);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent intent= new Intent("goodbye");
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getApplicationContext(), "You clicked on Cancel", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                    }else{
                        winner = "O has Won :)";
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setIcon(R.drawable.hurrah);
                        a_builder.setMessage("O has Won!!!" +
                                " Do you want to play again?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        gameReset(view);
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                        Intent intent= new Intent("goodbye");
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You clicked on Cancel", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Alert");
                        alert.show();
                    }
                    TextView status =findViewById(R.id.textView2);
                    status.setText(winner);
                  }
            }
        }
    public void gameReset(View view)
    {
        gameactive=true;
        activeplayer =0;
        Arrays.fill(gamestate, 2);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.textView2);
        status.setText("X's Turn - Tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnButtonClickListener();
    }
    public void OnButtonClickListener()
    {
        btn =(Button)findViewById(R.id.button_restart);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gameReset(v);
                    }
                }
        );
    }
}
