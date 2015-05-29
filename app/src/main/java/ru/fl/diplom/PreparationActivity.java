package ru.fl.diplom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PreparationActivity extends Activity {
    String recipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preparation_activity);

        EditText recipe_edit = (EditText) findViewById(R.id.edit_recipe);
        recipe_edit.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                        if (source.toString().matches("[0-9а-яА-ЯёЁ,-.):\\s]+")) {
                            return source;
                        }
                        return "";
                    }
                }
        });
    }
    public void Validation(View view) {
        EditText recipe_edit = (EditText) findViewById(R.id.edit_recipe);
        recipe = recipe_edit.getText().toString();

        if (recipe.equals("")) {
            Toast.makeText(this, "Напишите рецепт", Toast.LENGTH_SHORT).show();
        }
        else PreratationAdded(view);
    }

    public void PreratationAdded(View view) {
        Dish dish = (Dish) getIntent().getParcelableExtra(Dish.class.getCanonicalName());
        dish.set_recipe(recipe);
        Intent intent = new Intent(this,ShowRecipeActivity.class);
        intent.putExtra(Dish.class.getCanonicalName(), dish);
        startActivity(intent);
    }
}