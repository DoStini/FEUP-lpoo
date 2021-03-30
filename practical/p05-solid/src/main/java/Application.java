import areatool.AreaAggregator;
import areatool.AreaOutputter;
import areatool.AreaStringOutputter;
import areatool.AreaXMLOutputter;
import shape.*;
import world.City;
import world.House;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addAreaObj(new Square(10));
        aggregator.addAreaObj(new Circle(5));
        aggregator.addAreaObj(new Circle(2));
        aggregator.addAreaObj(new Ellipse(2, 3));
        aggregator.addAreaObj(new Rectangle(10, 5));
        aggregator.addAreaObj(new Triangle(10, 2));
        aggregator.addAreaObj(new House(100));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        List<House> houses = new ArrayList<>();
        houses.add(new House(50));
        houses.add(new House(150));

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());
    }
}
