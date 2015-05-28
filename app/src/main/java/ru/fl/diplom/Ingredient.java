package ru.fl.diplom;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adm on 25.05.2015.
 */
public class Ingredient implements Parcelable{
    String ingredient_name;
    String num_of;
    String value;

    public Ingredient(String ingredient_name,String num_of,String value){
        this.ingredient_name = ingredient_name;
        this.num_of = num_of;
        this.value = value;
    }
    public String get_ingredient_name(){
        return ingredient_name;
    }
    public Ingredient(Parcel parcel){
        this.ingredient_name = parcel.readString();
        this.num_of = parcel.readString();
        this.value = parcel.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ingredient_name);
        dest.writeString(num_of);
        dest.writeString(value);
    }
    public static Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
