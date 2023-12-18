package cn.dfxy.learn;

public class DoctorBean {
    private String name;
    private String sex;
    private String departmentName;

    public DoctorBean() {
    }

    public DoctorBean(String name, String sex, String departmentName) {
        this.name = name;
        this.sex = sex;
        this.departmentName = departmentName;
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
     * @return departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String toString() {
        return "doctorBean{name = " + name + ", sex = " + sex + ", departmentName = " + departmentName + "}";
    }
}
