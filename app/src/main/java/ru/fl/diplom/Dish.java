package ru.fl.diplom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by adm on 25.05.2015.
 */
public class Dish implements Parcelable{
    int dish_id;
    String dish_name;
    String category;
    String difficult;
    String time;
    String num_servs;
    ArrayList<Ingredient> IngredientsList = new ArrayList<Ingredient>();
    String recipe;

    public void set_dish_id(int dish_id){
        this.dish_id = dish_id;
    }

    public int get_dish_id(){
        return dish_id;
    }

    public void set_dish_name(String dish_name){
        this.dish_name = dish_name;
    }

    public String get_dish_name(){
        return dish_name;
    }

    public void set_category(String category){
        this.category = category;
    }

    public String get_category(){
        return category;
    }

    public void set_difficult(String difficult){
        this.difficult = difficult;
    }

    public String get_difficult(){
        return difficult;
    }

    public void set_time(String time){
        this.time = time;
    }

    public String get_time(){
        return time;
    }

    public void set_num_servs(String num_servs){
        this.num_servs = num_servs;
    }

    public String get_num_servs(){
        return num_servs;
    }

    public void set_recipe(String recipe){
        this.recipe = recipe;
    }

    public String get_recipe(){
        return recipe;
    }

    public void put_Ingredient(Ingredient ingredient) {
        this.IngredientsList.add(ingredient);
    }

    public void set_Ingredients(ArrayList<Ingredient> IngredientsList){
        this.IngredientsList = IngredientsList;
    }

    public ArrayList<Ingredient> get_Ingredients(){
        return IngredientsList;
    }
    public Dish(){}
    public Dish(String dish_name, String category, String difficult, String time, String num_servs){
        this.dish_name = dish_name;
        this.category = category;
        this. difficult = difficult;
        this.time = time;
        this.num_servs = num_servs;
        this.IngredientsList = new ArrayList<Ingredient>();
    }

    public Dish(Parcel parcel){
        this.dish_id = parcel.readInt();
        this.dish_name = parcel.readString();
        this.category = parcel.readString();
        this. difficult = parcel.readString();
        this.time = parcel.readString();
        this.num_servs = parcel.readString();
        parcel.readTypedList(IngredientsList, Ingredient.CREATOR);
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
        parcel.writeString(time);
        parcel.writeString(num_servs);
        parcel.writeTypedList(IngredientsList);
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
