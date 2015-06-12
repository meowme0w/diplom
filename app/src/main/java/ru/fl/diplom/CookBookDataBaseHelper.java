package ru.fl.diplom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        db.execSQL("create table dishes ("
                + "dish_id unsigned int primary key autoincrement, "
                + "name TINYTEXT, "
                + "category TINYTEXT,"
                + "difficult TINYTEXT, "
                + "cooking_time unsigned SMALLINT, "
                + "num_of_servings unsigned TINYINT, "
                + "recipe TEXT, "
                + "PRIMARY KEY (dish_id)"
                + ");"
        );

        db.execSQL("create table dishes_ingredients ("
                + "dish_id unsigned int,"
                + "ingredient_name TINYTEXT, "
                + "value TINYTEXT, "
                + "FOREIGN KEY (dish_id) references dishes(dish_id), "
                + "FOREIGN KEY (ingredient_id) references ingredients(ingredient_id)"
                + ");"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int old_ver, int new_ver) {
        Log.w("LOG_TAG", "Обновление базы данных с версии " + old_ver
                + " до версии " + new_ver + ", которое удалит все старые данные");
        // Удаляем предыдущую таблицу при апгрейде
        db.execSQL("DROP TABLE IF EXISTS dishes_ingredients");
        db.execSQL("DROP TABLE IF EXISTS ingredients");
        db.execSQL("DROP TABLE IF EXISTS dishes");
        // Создаём новый экземпляр таблицы
        onCreate(db);
    }
}
