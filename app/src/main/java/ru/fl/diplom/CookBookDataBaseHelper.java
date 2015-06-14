package ru.fl.diplom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Кирилл on 14.04.2015.
 */
public class CookBookDataBaseHelper extends SQLiteOpenHelper  {

    private static final String DATABASE_NAME = "CookBook_database.db";
    private static final int DATABASE_VERSION = 1;

    public CookBookDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table dish ("
                + "dish_id INTEGER PRIMARY KEY autoincrement, "
                + "name text, "
                + "category text,"
                + "difficult text, "
                + "cook_time integer, "
                + "recipe text"
                + ");"
        );

        db.execSQL("create table ingredient ("
                + "ingredient_id INTEGER PRIMARY KEY,"
                + "dish_id integer, "
                + "ingredient_name text, "
                + "numof integer, "
                + "value text, "
                + "FOREIGN KEY (dish_id) references dishes(dish_id)"
                + ");"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int old_ver, int new_ver) {
        Log.w("LOG_TAG", "Обновление базы данных с версии " + old_ver
                + " до версии " + new_ver + ", которое удалит все старые данные");
        // Удаляем предыдущую таблицу при апгрейде
        db.execSQL("DROP TABLE IF EXISTS ingredient");
        db.execSQL("DROP TABLE IF EXISTS dish");
        // Создаём новый экземпляр таблицы
        onCreate(db);
    }

    //добавление рецепта в базу
    public Dish addDish(Dish dish){
        Cursor c;
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.clear();
        values.put("name", dish.get_dish_name()); // Contact Name
        values.put("category", dish.get_category()); // Contact Phone Number
        values.put("difficult", dish.get_difficult());
        values.put("cook_time", dish.get_time());
        values.put("recipe", dish.get_recipe());

        // Inserting Row

        db.insert("dish", null, values);
        columns = new String[]{"MAX('id')"};
        c = db.query("dish",columns, null, null, null, null, null);
        if(c.moveToFirst());
        dish.set_dish_id(c.getInt(0));
        for(int i=0; i < dish.get_Ingredients().size(); i++){
            values.clear();
            values.put("dish_id", dish.get_dish_id());
            values.put("ingredient_name", dish.get_Ingredients().get(i).get_ingredient_name());
            values.put("numof", dish.get_Ingredients().get(i).get_num_of());
            values.put("value", dish.get_Ingredients().get(i).get_value());
            db.insert("ingredient", null, values);
        }
        return dish;
    }

    //поиск рецептов
/*    public ArrayList<Dish> getDishes(String dish_name, String dish_time, String dish_difficult ){}

    //поиск рецепта по id
    public Dish getDishes(int dish_id ){}

    //поиск рецепта по категории
    public ArrayList<Dish> getDishes(String dish_category){}

    //редактирование рецепта
    public void updateDish(Dish dish){}*/




}
