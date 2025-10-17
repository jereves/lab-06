package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class defines the container
 * that contains the sorted array of city objects
 * @see City
 */
public class CityList {
    private List<City> cities;


    /**
     * Constructor method that initializes an empty city list for the container
     */
    public CityList() {
        this.cities = new ArrayList<>();
    }


    /**
     * This adds a city to the list if the city does not exist
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException If city already exists in cityList
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return List the array of  cities (sorted alphabetically)
     */
    public List<City> getCities() {
        Collections.sort(cities);
        return cities;
    }


    /**
     * This returns whether or not a city is in the list of cities
     * @param city the City object that you want to check if it exists in the array
     * @return Boolean The city object is inside the cities
     * @see City
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the city list
     * @param city the city Object you want to delete from the array
     * @throws IllegalArgumentException if city is not in city list
     * @see City
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        else {
            cities.remove(city);
        }   
    }

    /**
     * Return how many cities are in city list
     * @return Integer of how many cities there are in the city list
     */
    public int countCities() {
        return cities.size();
    }
}
