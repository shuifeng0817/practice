package cn.dfxy.learn;

public class PatientBean {
    private String  name;
    private String sex;
    private int age;
    private  String doctor;
    private String time;

    public PatientBean() {
    }

    public PatientBean(String name, String sex, int age, String doctor, String time) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.doctor = doctor;
        this.time = time;
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
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * 设置
     * @param doctor
     */
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    /**
     * 获取
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    public String toString() {
        return "PatientBean{name = " + name + ", sex = " + sex + ", age = " + age + ", doctor = " + doctor + ", time = " + time + "}";
    }
}
