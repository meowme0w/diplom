package ru.fl.diplom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Елена on 08.05.2015.
 */
public class Search extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_dish);

        EditText name_search = (EditText) findViewById(R.id.search_name);
        name_search.setFilters(new InputFilter[]{
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
}