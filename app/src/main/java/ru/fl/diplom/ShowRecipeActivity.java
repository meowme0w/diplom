package ru.fl.diplom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Елена on 15.04.2015.
 */
public class ShowRecipeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_recipe_activity);
        Dish dish = getIntent().getParcelableExtra(Dish.class.getCanonicalName());
        ((TextView)findViewById(R.id.name_recipe)).setText(dish.get_dish_name());
        ((TextView)findViewById(R.id.category_choose)).setText(dish.get_category());
        ((TextView)findViewById(R.id.preparation_choose)).setText(dish.get_difficult());
        ((TextView)findViewById(R.id.time_choose)).setText(dish.get_time());
        ((TextView)findViewById(R.id.number_of_servings_choose)).setText(dish.get_num_servs());
        String ingredients = new String();
        for(int i=0 ; i< dish.get_Ingredients().size() ; i++) {
            ingredients += (dish.get_Ingredients().get(i).get_ingredient_name() + "  "
                    + dish.get_Ingredients().get(i).get_num_of() + dish.get_Ingredients().get(i).get_value() + "\n");
        }
        ((TextView)findViewById(R.id.edit_ingridient)).setText(ingredients);
        ((TextView)findViewById(R.id.edit_recipe)).setText(dish.get_recipe());

    }

    public void OnMain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}