package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class SixtiesFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("196[0-9]",0);
    }
}
