package areatool;

public class AreaStringOutputter extends AreaOutputter {

    public AreaStringOutputter(SumProvider aggr) {
        super(aggr);
    }

    @Override
    public String output() {
        return "Sum of areas: " + aggr.sum();
    }
}
