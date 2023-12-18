package com.zjx;

public class Student {
    private String name;
    private int idcard;

    public Student() {
    }

    public Student(String name, int idcard) {
        this.name = name;
        this.idcard = idcard;
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
     * @return idcard
     */
    public int getIdcard() {
        return idcard;
    }

    /**
     * 设置
     * @param idcard
     */
    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public String toString() {
        return "Student{name = " + name + ", idcard = " + idcard + "}";
    }
}
