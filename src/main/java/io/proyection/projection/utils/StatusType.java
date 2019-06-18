package io.proyection.projection.utils;

public enum StatusType {

    TO_DO(1),
    DOING(2),
    DONE(3);

    private int numVal;

    StatusType(int i) {
        this.numVal = i;
    }

    public int getNumVal() {
        return numVal;
    }
}
