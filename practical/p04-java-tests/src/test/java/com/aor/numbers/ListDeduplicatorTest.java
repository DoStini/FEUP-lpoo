package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> testList;
    private List<Integer> expected;

    @BeforeEach
    public void setupList() {
        testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.add(2);
        testList.add(5);
        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
    }

    class StubListSorter1 implements IListSorter {
        public List<Integer> sort() {
            return Arrays.asList(1,2,2,4);
        }
    }

    class StubListSorter2 implements IListSorter {
        public List<Integer> sort() {
            return Arrays.asList(1,2,2,4,5);
        }
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        Assertions.assertEquals(expected, deduplicator.deduplicate(new StubListSorter1()));
    }

    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator(testList);
        List<Integer> deduplicate = deduplicator.deduplicate(new StubListSorter2());

        Assertions.assertEquals(expected, deduplicate);
    }
}
