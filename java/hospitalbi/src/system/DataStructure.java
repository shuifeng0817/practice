package system;

import java.util.ArrayList;

public class DataStructure {
    //数据源类，通过两个数组分别存放已经录入的科室和医生信息
    public static ArrayList<Department> depArray = new ArrayList<>();
    public static ArrayList<Doctor> drArray = new ArrayList<>();
    public static void listDep(){
        //科室展示方法，用于遍历打印科室数组中的所有科室名
        for (Department department : depArray) {
            System.out.println(department.depName);
        }
    }
    public static void listDr(){
        //医生展示方法，用于遍历打印医生数组中的所有医生名
        for (Doctor doctor : drArray) {
            System.out.println(doctor.drName);
        }
    }
}
