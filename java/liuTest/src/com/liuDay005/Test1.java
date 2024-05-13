package com.liuDay005;

public class Test1 {
    private String ename;
    private String job;

    public Test1() {
    }

    public Test1(String ename, String job) {
        this.ename = ename;
        this.job = job;
    }

    /**
     * 获取
     * @return ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * 设置
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return "Test1{ename = " + ename + ", job = " + job + "}";
    }
}
