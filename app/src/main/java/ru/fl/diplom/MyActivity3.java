package ru.fl.diplom;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

   public class MyActivity3 extends Activity {
     private List<View> allEds;
    // private int counter = 0;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.ingridients);

         Button addButton = (Button) findViewById(R.id.button);
         allEds = new ArrayList<View>();
         final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
         addButton.setOnClickListener(new View.OnClickListener() {
         @Override

         public void onClick(View v) {

         //    counter++;
             final View view = getLayoutInflater().inflate(R.layout.custom_edittext_layout, null);
             Button deleteField = (Button) view.findViewById(R.id.button2);

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

             EditText text = (EditText) view.findViewById(R.id.editText);
             text.setFilters(new InputFilter[]{
                     new InputFilter() {
                         @Override
                         public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                             if (source.toString().matches("[а-яА-ЯёЁ\\s]+")) {
                                 return source;
                             }
                             return "";
                         }
                     }
             });

             EditText numb = (EditText) view.findViewById(R.id.editText4);
             numb.setFilters(new InputFilter[]{
                     new InputFilter() {
                         @Override
                         public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                             if (source.toString().matches("[0-9а-яёА-ЯЁ\\s]+")) {
                                 return source;
                             }
                             return "";
                         }
                     }
             });
         }
         });
     }

}