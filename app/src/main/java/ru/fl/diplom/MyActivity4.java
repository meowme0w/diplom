package ru.fl.diplom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity4 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preparation_activity);
    }

    public void AddPreratation(View view) {
        Intent intent = new Intent(this,MyActivity5.class);
        startActivity(intent);
    }
}