package StrategyPattern.Filters;

import StrategyPattern.FilterStrat;

import javax.swing.*;

public class EightiesFilter implements FilterStrat {

    @Override
    public RowFilter<Object, Object> getFilter() {
        return RowFilter.regexFilter("198[0-9]",0);
    }
}