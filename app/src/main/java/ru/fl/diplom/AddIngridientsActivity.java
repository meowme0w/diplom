package ru.fl.diplom;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

   public class AddIngridientsActivity extends Activity {
       private List<View> allEds;
    // private int counter = 0;

<<<<<<< HEAD
        String dish_name = getIntent().getExtras().getString("dish_name");
        String cooking_time = getIntent().getExtras().getString("cooking_time");
        String num_of_servings = getIntent().getExtras().getString("num_of_servings");
        @Override
        protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.ingridients);
=======
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.ingredients);
>>>>>>> 8ccdb6c27933ecaf0467f1e5b3b057013bffa6db

             Button addButton = (Button) findViewById(R.id.add_ingredient_button);
             allEds = new ArrayList<View>();
             final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
             addButton.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {

             //    counter++;
                 final View view = getLayoutInflater().inflate(R.layout.custom_edittext_layout, null);
                 Button deleteField = (Button) view.findViewById(R.id.delete_button);

                 deleteField.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         try {
                             ((LinearLayout) view.getParent()).removeView(view);
                             allEds.remove(view);
                         }
                         catch(IndexOutOfBoundsException ex) {
                             ex.printStackTrace();
                         }
                     }
                 });

                 allEds.add(view);
                 linear.addView(view);

                 EditText name_ingredient = (EditText) view.findViewById(R.id.edit_name_ingredient);
                 name_ingredient.setFilters(new InputFilter[]{
                         new InputFilter() {
                             @Override
                             public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                                 if (source.toString().matches("[а-яА-ЯёЁ ]+")) {
                                     return source;
                                 }
                                 return "";
                             }
                         }
                 });

                 EditText number_ingredient = (EditText) view.findViewById(R.id.edit_number_ingredient);
                 number_ingredient.setFilters(new InputFilter[]{
                         new InputFilter() {
                             @Override
                             public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                                 if (source.toString().matches("[0-9а-яёА-ЯЁ .]+")) {
                                     return source;
                                 }
                                 return "";
                             }
                         }
                 });
             }
             });
        }

             public void IngridientsAdded(View view) {
                 //преобразуем наш ArrayList в просто String Array
                 Ingredient [] items = new Ingredient[allEds.size()];

                 //запускаем чтение всех елементов этого списка и запись в массив
                 for(int i=0; i < allEds.size(); i++) {
                     items[i].name = ((EditText) allEds.get(i).findViewById(R.id.edit_name_ingredient)).getText().toString();
                     items[i].numof = ((EditText) allEds.get(i).findViewById(R.id.edit_number_ingredient)).getText().toString();
                     //ну и можно сразу же здесь вывести
                     Log.e("", ((EditText) allEds.get(i).findViewById(R.id.edit_name_ingredient)).getText().toString());
                     Log.e("", ((EditText) allEds.get(i).findViewById(R.id.edit_number_ingredient)).getText().toString());
                 }
                Intent intent = new Intent(this,PreparationActivity.class);
                intent.putExtra("items", items);
                startActivity(intent);
           }
}