package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> testList;

    @BeforeEach
    public void setupList() {
        testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.add(2);
        testList.add(5);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator(testList);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(testList);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> list = Arrays.asList(-1,-4,-5);
        ListAggregator aggregator = new ListAggregator(list);
        Assertions.assertEquals(-1, aggregator.max());
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(testList);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    class StubListDeduplicator implements IListDeduplicator {
        @Override
        public List<Integer> deduplicate(IListSorter sorter) {
            return Arrays.asList(1, 2, 4, 5);
        }
    }

    class StubListDeduplicator2 implements IListDeduplicator {
        @Override
        public List<Integer> deduplicate(IListSorter sorter) {
            return Arrays.asList(1, 2, 4);
        }
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(testList);

        int distinct = aggregator.distinct(new StubListDeduplicator(), new ListSorter(testList));

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        ListAggregator aggregator = new ListAggregator(list);
        Assertions.assertEquals(3, aggregator.distinct(new StubListDeduplicator2(), new ListSorter(list)));
    }
}
