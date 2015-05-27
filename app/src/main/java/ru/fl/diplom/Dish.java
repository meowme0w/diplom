package ru.fl.diplom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by adm on 25.05.2015.
 */
public class Dish implements Parcelable{
    public  int dish_id;
    public  String dish_name;
    public  String category;
    public  String difficult;
    public  int time;
    public ArrayList<Ingredient> IngredientsList;
    public String recipe;



    public Dish(String dish_name, String category, String difficult, int time){
        this.dish_name = dish_name;
        this.category = category;
        this. difficult = difficult;
        this.time = time;
    }

    public Dish(Parcel parcel){
        this.dish_id = parcel.readInt();
        this.dish_name = parcel.readString();
        this.category = parcel.readString();
        this. difficult = parcel.readString();
        this.time = parcel.readInt();
        this.IngredientsList = parcel.readArrayList(null);
        this.recipe = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(dish_id);
        parcel.writeString(dish_name);
        parcel.writeString(category);
        parcel.writeString(difficult);
        parcel.writeInt(time);
        parcel.writeList(IngredientsList);
        parcel.writeString(recipe);
    }

    public static Parcelable.Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel source) {
            return new Dish(source);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };
}
