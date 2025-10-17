package com.example.code;

import androidx.annotation.NonNull;

/**
* This is a class that defines a City
 * defined by name and province
*/

public class City implements Comparable {
    private String name;
    private String province;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public int compareTo(Object o) {

        City city = (City) o; //typecasting
        return this.name.compareTo(
                // sort city object based on alphabetic order
                city.getName());
    }
}

