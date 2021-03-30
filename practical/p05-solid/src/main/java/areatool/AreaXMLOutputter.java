package areatool;

public class AreaXMLOutputter extends AreaOutputter{
    public AreaXMLOutputter(SumProvider aggr) {
        super(aggr);
    }

    @Override
    public String output() {
        return "<area>" + aggr.sum() + "</area>";
    }
}
