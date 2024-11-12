package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class NinetiesFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("199[0-9]",0);
    }
}