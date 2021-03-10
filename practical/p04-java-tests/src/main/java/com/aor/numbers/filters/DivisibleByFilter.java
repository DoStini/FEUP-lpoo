package com.aor.numbers.filters;

public class DivisibleByFilter implements IListFilter {

    private int base;

    DivisibleByFilter(int base) {
        this.base = base;
    }
    @Override
    public boolean accept(Integer number) {
        return number % base == 0;
    }
}