package com.gettingsmarter.gettingsmarter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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


    @Override
    //this supports 'back' button
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
