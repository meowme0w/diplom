package ru.fl.diplom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Елена on 09.05.2015.
 */
public class CategoriesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);
    }

    public void ShowCategoryRecipies (View view) {
        Intent intent = new Intent(this,ResultActivity.class);
        startActivity(intent);
    }
}
