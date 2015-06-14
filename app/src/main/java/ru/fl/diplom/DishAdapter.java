package ru.fl.diplom;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adm on 14.06.2015.
 */
public class DishAdapter {


        private List<Dish> data;
        private int size = 0;

        public DishAdapter(List<Dish> data) {
            super();
            this.data = data;
            size = data.size();
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public Dish getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Context context = parent.getContext();
            ViewHolder holder;
            if(convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.custom_dish_layout, parent, false);
                holder = new ViewHolder();
                holder.fName = (TextView) convertView.findViewById(android.R.id.);
                holder.sName = (TextView) convertView.findViewById(android.R.id.text2);
                convertView.setTag(holder);
            }
            holder = (ViewHolder) convertView.getTag();
            DataEntity item = data.get(position);
            holder.fName.setText(item.getmFirstName());
            holder.sName.setText(item.getmSecondName());
            if(item.isWasAssingned()){
                holder.fName.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
                holder.sName.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
            }
            return convertView;
        }

        static class ViewHolder{
            TextView fName;
            TextView sName;
        }


}
