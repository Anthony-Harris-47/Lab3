package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class TwentiesFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("202[0-9]",0);
    }
}