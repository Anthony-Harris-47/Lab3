package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class TwoKFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("200[0-9]",0);
    }
}