package com.example.code;

import androidx.annotation.NonNull;

/**
* This is a class that defines a City
 * defined by name and province
*/

public class City implements Comparable {
    private String name;
    private String province;

    /**
     * Initializes the city identified by name and province
     * @param name Name of city
     * @param province Name of province
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     * Returns name of city via a String
     * @return name of city
     */
    public String getName() {
        return name;
    }

    /**
     * Updates name of city via a given String
     * @param name new name of city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns province name of city via String
     * @return name of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Updates name of province via a given String
     * @param province new name of province
     */
    public void setProvince(String province) {
        this.province = province;
    }


    /**
     * Allows for sorting of the element via comparison of alphabetical order
     * @param o the city object itself
     */
    @Override
    public int compareTo(Object o) {

        City city = (City) o; //typecasting
        return this.name.compareTo(
                // sort city object based on alphabetic order
                city.getName());
    }
}

