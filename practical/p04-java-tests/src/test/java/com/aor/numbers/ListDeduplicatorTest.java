package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);
        ListDeduplicator deduplicator = new ListDeduplicator(list);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(Arrays.asList(1,2,2,4));

        Assertions.assertEquals(expected, deduplicator.deduplicate(sorter));
    }

    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator(testList);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(Arrays.asList(1,2,2,4,5));

        List<Integer> deduplicate = deduplicator.deduplicate(sorter);

        Assertions.assertEquals(expected, deduplicate);
    }
}
