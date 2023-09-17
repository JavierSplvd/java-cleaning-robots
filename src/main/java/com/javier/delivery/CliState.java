package com.javier.delivery;

import com.javier.entities.Grid;

public interface CliState {
    CliState input(String input);
    Grid getGrid();
}
