package com.liuDay006;

public class Circular {
    private Circle c1;
    private double h;

    public Circular() {
    }

    public Circular(Circle c1, double h) {
        this.c1 = c1;
        this.h = h;
    }


    /**
     * 获取
     * @return c1
     */
    public Circle getC1() {
        return c1;
    }

    /**
     * 设置
     * @param c1
     */
    public void setC1(Circle c1) {
        this.c1 = c1;
    }

    /**
     * 获取
     * @return h
     */
    public double getH() {
        return h;
    }

    /**
     * 设置
     * @param h
     */
    public void setH(double h) {
        this.h = h;
    }

    public String toString() {
        return "Circular{c1 = " + c1 + ", h = " + h + "}";
    }

    public double TiJi() {
        double v = (c1.area() * h) / 3;
        return v;
    }
}
