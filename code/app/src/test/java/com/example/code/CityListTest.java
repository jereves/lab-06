package com.example.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This tests all methods of CityList class
 */
public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());

        // initialized list will only have mock city size 1
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "AB");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "NWT");
        cityList.add(city);

        // assert that you cannot add a duplicate
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(
                cityList.getCities().get(0)
        ));

        City city = new City("Charlottetown", "PEI");
        cityList.add(city);

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
        assertEquals(
                // charlottetown is alphabetically first on 0 index
                0, city.compareTo(cityList.getCities().get(0)));
    }

    // test if city is removed from list
    // assert false get cities contains cities
    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        // add calgary as city to delete
        City city = new City("Calgary", "AB");
        cityList.add(city);

        // delete city
        cityList.deleteCity(city);

        // assert that there is only one city
        assertEquals(1, cityList.getCities().size());

        // get actual array and assert that there is no calgary in the city list
        assertFalse(cityList.getCities().contains(city));
    }

    // test exception if city that is not in the list on delete
    @Test
    void testDeleteException() {

        CityList cityList = mockCityList();

        // add calgary as city to delete
        City city = new City("Calgary", "AB");
        cityList.add(city);

        // delete city
        cityList.deleteCity(city);

        // assert that there is only one city
        assertEquals(1, cityList.getCities().size());

        // delete calgary again, exception should be thrown
        assertThrows(IllegalArgumentException.class,() ->
        {
            cityList.deleteCity(city);
        });
    }

    // test count cities
    @Test
    void testCountCities() {

        CityList cityList = mockCityList();

        // city count should be one
        assertEquals(1, cityList.getCities().size());


        // add calgary as city to add then delete
        City city = new City("Calgary", "AB");

        // add city
        cityList.add(city);

        // assert that there should be two cities
        assertEquals(2, cityList.getCities().size());

        // delete one city
        cityList.deleteCity(city);

        // city should be 1
        assertEquals(1, cityList.getCities().size());
    }


    // test hasCity

    @Test
    void testHasCity( ) {
        CityList cityList = mockCityList();

        // victoria will be added
        City inList = new City("Victoria", "BC");
        cityList.add(inList);

        // calgary will not be added
        City notInList = new City("Calgary", "AB");

        // True that Victoria is in list
        assertTrue(cityList.hasCity(inList));

        // False that Calgary is in the list
        assertFalse(cityList.hasCity(notInList));

    }

}
