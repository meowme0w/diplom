package ru.fl.diplom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void AddNewDishes(View view) {
        Intent intent = new Intent(this,AddDishesActivity.class);
        startActivity(intent);
    }

    public void FoundDish(View view) {
        Intent intent = new Intent(this,Search.class);
        startActivity(intent);
    }

    public void ShowCategories(View view) {
        Intent intent = new Intent(this,CategoriesActivity.class);
        startActivity(intent);
    }
}