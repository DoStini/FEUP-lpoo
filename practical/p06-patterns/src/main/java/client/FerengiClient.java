package client;

import strategy.OrderingStrategy;
import strategy.SmartStrategy;

public class FerengiClient extends AlienClient {
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }
}
