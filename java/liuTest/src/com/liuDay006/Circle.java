package com.liuDay006;

public class Circle {
    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    /**
     * 获取
     * @return r
     */
    public double getR() {
        return r;
    }

    /**
     * 设置
     * @param r
     */
    public void setR(double r) {
        this.r = r;
    }

    public String toString() {
        return "Circle{r = " + r + "}";
    }
    public double area() {
        return Math.PI * r * r;
    }
}
