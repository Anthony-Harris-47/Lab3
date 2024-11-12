package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class TensFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("201[0-9]",0);
    }
}