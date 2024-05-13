package com.liuDay007;

class Order {
    private String name;
    private double price;
    private int amount;

    public Order() {
    }

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 设置
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString() {
        return "Order{name = " + name + ", price = " + price + ", amount = " + amount + "}";
    }
}
