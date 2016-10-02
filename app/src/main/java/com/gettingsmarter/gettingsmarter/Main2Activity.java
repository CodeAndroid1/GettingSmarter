package com.gettingsmarter.gettingsmarter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void p1(View view) {
        Values.index = 0;
        showValues();
    }

    private void showValues() {
        Intent i = new Intent(this, Main3Activity.class);
        Bundle b = new Bundle();
        b.putString("place","Thorrur, Warangal");
        b.putDouble("latitude",17.5923928);
        b.putDouble("longitude",79.6436359);

        b.putInt("litr", 67);
        b.putInt("heal", 58);
        b.putInt("tech", 42);
        i.putExtras(b);
        startActivity(i);
    }

    public void stats(View view) {

        showStats();
    }
    public void showStats(){
        Intent i = new Intent(this, Main4Activity.class);
        startActivity(i);
    }

}
