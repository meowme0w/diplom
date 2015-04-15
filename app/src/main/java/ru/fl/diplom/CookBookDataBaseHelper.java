package ru.fl.diplom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        db.execSQL("create table categories ("
                + "category_id unsigned int primary key autoincrement, "
                + "category_name TINYTEXT, "
                + ");"
        );
        db.execSQL("create table difficults ("
                        + "difficult_id unsigned int primary key autoincrement, "
                        + "difficult TINYTEXT, "
                        + ");"
        );
        db.execSQL("create table dishes ("
                + "dish_id unsigned int primary key autoincrement, "
                + "name TINYTEXT, "
                + "category_id unsigned TINYINT,"
                + "difficult_id unsigned TINYINT, "
                + "cooking_time unsigned SMALLINT, "
                + "num_of_servings unsigned TINYINT, "
                + "image_path TINYTEXT, "
                + "recipe TEXT, "
                + "FOREIGN KEY (category_id) REFERENCES categories (category_id), "
                + "FOREIGN KEY (difficult_id) REFERENCES difficults (difficult_id), "
                + ");"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
