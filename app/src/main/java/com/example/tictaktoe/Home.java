package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {
    private Button btn_start;
    Animation topanim,bottomanim;
    ImageView image;
    Button btn;
    public void OnButtonClickLintener(){
        btn_start = (Button)findViewById(R.id.button_start);
        btn_start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("MainActivity");
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        OnButtonClickLintener();

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image =(ImageView)findViewById(R.id.imageView_home);
        btn= (Button)findViewById(R.id.button_start);
        image.setAnimation(topanim);
        btn.setAnimation(bottomanim);
    }
}
