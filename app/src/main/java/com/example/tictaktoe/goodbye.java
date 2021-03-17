package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class goodbye extends AppCompatActivity {
    Animation bottom,top,blink;
    ImageView img;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodbye);
        ImageView img= (ImageView)findViewById(R.id.imageView11);
        img.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        blink = AnimationUtils.loadAnimation(this,R.anim.blink_animation);
        img= (ImageView)findViewById(R.id.imageView10);
        txt1=(TextView)findViewById(R.id.textView4);
        txt2=(TextView)findViewById(R.id.textView5);
        txt3=(TextView)findViewById(R.id.textView6);
        img.setAnimation(bottom);
        txt1.setAnimation(top);
        txt2.setAnimation(top);
        txt3.setAnimation(blink);
    }
}
