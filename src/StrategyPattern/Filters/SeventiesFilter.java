package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class SeventiesFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("197[0-9]",0);
    }
}