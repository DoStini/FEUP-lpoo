package areatool;

public abstract class AreaOutputter {
    protected SumProvider aggr;

    public AreaOutputter(SumProvider aggr) {
        this.aggr = aggr;
    }

    public abstract String output();
}
