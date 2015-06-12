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
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

   public class AddIngridientsActivity extends Activity {
       private List<View> allEds;
    // private int counter = 0;
        final String LOG_TAG = "Dish";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.ingredients);


            Button addButton = (Button) findViewById(R.id.add_ingredient_button);
            allEds = new ArrayList<View>();
            final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
            addButton.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {
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
        }
        });
   }


             public void IngridientsAdded(View view) {
                 //преобразуем наш ArrayList в просто String Array
                 Dish dish = (Dish) getIntent().getParcelableExtra(Dish.class.getCanonicalName());
                 //запускаем чтение всех елементов этого списка и запись в массив
                 for(int i=0; i < allEds.size(); i++) {
                     Ingredient ingredient = new Ingredient(
                             ((EditText) allEds.get(i).findViewById(R.id.edit_name_ingredient)).getText().toString(),
                             ((EditText) allEds.get(i).findViewById(R.id.edit_number_ingredient)).getText().toString(),
                             ((Spinner) allEds.get(i).findViewById(R.id.spinner_measure_unit)).getSelectedItem().toString());
                     dish.put_Ingredient(ingredient);

                 }
                Intent intent = new Intent(this,PreparationActivity.class);
                intent.putExtra(Dish.class.getCanonicalName(), dish);
                startActivity(intent);
           }
}