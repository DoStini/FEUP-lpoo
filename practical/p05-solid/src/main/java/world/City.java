package world;

import areatool.SumProvider;

import java.util.List;

public class City implements SumProvider {
    List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    public double sum() {
        double val = 0;
        for (House house: houses) {
            val += house.getArea();
        }
        return val;
    }
}
