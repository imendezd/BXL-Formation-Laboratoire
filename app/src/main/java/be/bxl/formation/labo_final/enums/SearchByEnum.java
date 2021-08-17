package be.bxl.formation.labo_final.enums;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import be.bxl.formation.labo_final.R;

public enum SearchByEnum {

        NAME(1, R.string.search_by_name),
        COUNTRY(2, R.string.search_by_country);

        private int category;

        @StringRes
        private int name;

        SearchByEnum(int category, @StringRes int name) {
            this.category = category;
            this.name = name;
        }

        public int getCategory() {
            return category;
        }

        public String getName(@NonNull Context context) {
            return context.getString(this.name);
        }


        public static SearchByEnum fromLevel(int level) {
            SearchByEnum category = null;

            for(SearchByEnum p : SearchByEnum.values()) {
                if(p.getCategory() == level) {
                    category = p;
                }
            }

            if(category == null) {
                throw new RuntimeException("category not found");
            }

            return category;
        }

        public static SearchByEnum parse(@NonNull Context context, @NonNull String name) {
            boolean found = false;
            SearchByEnum[] values = SearchByEnum.values();
            SearchByEnum result = null;

            for(int i = 0; !found && i < values.length ; i++) {
                SearchByEnum v = values[i];

                if(v.getName(context).equals(name)) {
                    found = true;
                    result = v;
                }
            }

            if(!found) {
                throw new RuntimeException("Parse SearchByEnum fail !");
            }

            return result;
        }
    }