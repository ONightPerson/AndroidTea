package com.android.liubz.androidtea.java.concurrent.pairtest;

/**
 * Created by liubaozhu on 2019-08-27
 */
class CustomPair {

    private int x;
    private int y;

    public CustomPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CustomPair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public class PairNotEqualException extends RuntimeException {

        public PairNotEqualException() {
            super("Pair values not equal: " + CustomPair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairNotEqualException();
        }
    }
}
