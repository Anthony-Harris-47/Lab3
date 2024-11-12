package StrategyPattern;

import javax.swing.*;

public interface FilterStrat {
    RowFilter<Object, Object> getFilter();
}
