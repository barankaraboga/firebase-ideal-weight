package com.rankend.barankaraboa.vkeproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Baran on 26.03.2017.
 */

public class SonucActivity extends AppCompatActivity {

    TextView textViewVKE,ideal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonuc);
        Bundle bundle =getIntent().getExtras();
        double sonuc = (double)bundle.get("sonuc");
        textViewVKE=(TextView)(findViewById(R.id.textViewKitleEndex));
        textViewVKE.setText("Kitle Endexi:" +sonuc);
        ideal=(TextView)(findViewById(R.id.textViewİdealKilo));
        if(sonuc<18)
        {
            ideal.setText("zayıf");
        }
        else if(sonuc>17 && sonuc<26){
            ideal.setText("normal kilolu");

        }
        else if(sonuc>25 && sonuc<30){

            ideal.setText("fazla kilolu");

        }
        else if(sonuc>29 && sonuc<35)
        {
            ideal.setText("1.derece obez");

        }
        else if(sonuc>34 && sonuc<40){
            ideal.setText("2.derece obez");
        }
        else{
            ideal.setText("ölmüşsün ağlayanın yok :)");
        }
    }
}
