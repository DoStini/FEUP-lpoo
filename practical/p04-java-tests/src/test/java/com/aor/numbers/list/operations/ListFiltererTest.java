package com.aor.numbers.list.operations;

import com.aor.numbers.filters.IListFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFiltererTest {

    static List<Integer> list;

    @BeforeAll
    public static void setupList() {
        list = Arrays.asList(1,2,3,4);
    }

    @Test
    void filterTrue() {
        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(true);
        ListFilterer listFilterer = new ListFilterer(list);
        Assertions.assertEquals(list, listFilterer.filter(filter));
    }

    @Test
    void filterFalse() {
        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(false);
        ListFilterer listFilterer = new ListFilterer(list);
        Assertions.assertEquals(0, listFilterer.filter(filter).size());
    }

    @Test
    void filterOther() {
        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt()))
                .thenAnswer(f -> (int)(f.getArgument(0)) == 2);
        ListFilterer listFilterer = new ListFilterer(list);
        Assertions.assertEquals(Arrays.asList(2), listFilterer.filter(filter));
    }
}