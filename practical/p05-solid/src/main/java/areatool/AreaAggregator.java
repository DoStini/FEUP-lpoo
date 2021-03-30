package areatool;

import shape.*;

import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private List<HasArea> areaObjs = new ArrayList<>();

    public void addAreaObj(HasArea areaShape) {
        areaObjs.add(areaShape);
    }

    @Override
    public double sum() {
        double sum = 0;
        for (HasArea hasArea : areaObjs) {
            sum += hasArea.getArea();
        }
        return sum;
    }
}
