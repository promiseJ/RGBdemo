package com.mydemo.rgb;

public class RGB {

    private int r;
    private int g;
    private int b;

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + Integer.toString(this.getR()) + "," + Integer.toString(this.getG()) + "," + Integer.toString(this.getB()) + ")";
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof RGB)) return false;
        RGB rbg = (RGB) other;
        if ((this.getR() != rbg.getR()) || (this.getG() != rbg.getG()) || (this.getB() != rbg.getB())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = new Integer(this.getR() + this.getG() + this.getB()).hashCode();
        return result;
    }

    public int getR() {
        return r;
    }


    public int getG() {
        return g;
    }


    public int getB() {
        return b;
    }

}
