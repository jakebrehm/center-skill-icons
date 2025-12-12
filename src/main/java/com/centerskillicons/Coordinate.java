package com.centerskillicons;

import lombok.Getter;

class Coordinate {
    @Getter private final int x;
    @Getter private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
