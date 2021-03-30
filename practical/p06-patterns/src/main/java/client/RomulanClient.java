package client;

import strategy.ImpatientStrategy;
import strategy.OrderingStrategy;

public class RomulanClient extends AlienClient {
    @Override
    protected OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();
    }
}
