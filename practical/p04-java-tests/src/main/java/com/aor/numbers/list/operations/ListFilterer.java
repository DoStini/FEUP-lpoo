package com.aor.numbers.list.operations;

import com.aor.numbers.filters.IListFilter;

import java.util.List;
import java.util.stream.Collectors;

public class ListFilterer {
    private List<Integer> list;

    public ListFilterer(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter) {
        return list
                .stream()
                .filter(filter::accept)
                .collect(Collectors.toList());
    }

}
