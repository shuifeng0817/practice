package system;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Functions {
    //系统功能类，用于存放该系统操作的各种方法

    public static void addDep() {
        //添加科室方法，向科室数组添加一个科室对象
        ArrayList<Department> depArray = DataStructure.depArray;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加的科室名称");
        String depName = sc.next();
        for (Department department : depArray) {
            if (depName.equals(department.depName)) {
                System.out.println("已有该科室，请重新输入");
                addDep();
            }
        }
        Department newDep = new Department(depName);
        depArray.add(newDep);
        System.out.println("新增科室成功");
    }

    public static void deleteDep() {
        //删除科室方法，从科室数组里删除一个科室对象
        ArrayList<Department> depArray = DataStructure.depArray;
        Scanner sc = new Scanner(System.in);
        if (depArray.isEmpty()) {
            System.out.println("无法删除科室，因为没有可用的科室");
            return;
        }
        System.out.println("现有科室如下");
        DataStructure.listDep();
        System.out.println("请输入要删除的科室名称");
        String depName = sc.next();
        for (Department department : depArray) {
            if (depName.equals(department.depName)) {
                depArray.remove(department);
                System.out.println("删除科室成功");
                return;
            }
        }
        System.out.println("操作失败:没有该科室");
        deleteDep();
    }

    public static void modifyDep() {
        //修改科室方法，修改科室数组中一个科室对象的信息
        ArrayList<Department> depArray = DataStructure.depArray;
        Scanner sc = new Scanner(System.in);
        if (depArray.isEmpty()) {
            System.out.println("无法修改科室，因为没有可用的科室");
            return;
        }
        System.out.println("现有科室如下");
        DataStructure.listDep();
        System.out.println("请输入要修改的科室名称");
        String searchName = sc.next();
        for (Department department : depArray) {
            if (searchName.equals(department.depName)) {
                System.out.println("请输入该科室的新名称");
                String depName = sc.next();
                for (Department department2 : depArray) {
                    if (depName.equals(department2.depName)) {
                        System.out.println("操作失败:存在同名科室");
                        modifyDep();
                        return;
                    }
                }
                department.depName = depName;
                System.out.println("修改科室成功");
                return;
            }
        }
        System.out.println("操作失败:没有该科室");
        modifyDep();
    }

    public static void addDr() {
        //录入医生信息方法，向医生数组中添加一个医生对象
        ArrayList<Doctor> drArray = DataStructure.drArray;
        ArrayList<Department> depArray = DataStructure.depArray;
        Scanner sc = new Scanner(System.in);
        if (depArray.isEmpty()) {
            System.out.println("无法录入医生信息，因为没有可用的科室");
            return;
        }
        System.out.println("请输入要录入的医生姓名");
        String drName = sc.next();
        for (Doctor doctor : drArray) {
            if (drName.equals(doctor.drName)) {
                System.out.println("已有该医生，请重新输入");
                addDr();
                return;
            }
        }
        System.out.println("现有科室如下");
        DataStructure.listDep();
        System.out.println("请设置该医生所属的科室");
        String depName = sc.next();
        for (Department department : depArray) {
            if (depName.equals(department.depName)) {
                Doctor newDr = new Doctor(drName, department);
                drArray.add(newDr);
                System.out.println("录入医生信息成功");
                return;
            }
        }
        System.out.println("医生信息录入失败，没有找到科室");
        addDr();
    }

    public static void modifyDr() {
        //修改医生信息方法，修改医生数组中一个医生对象的姓名和科室信息
        ArrayList<Doctor> drArray = DataStructure.drArray;
        ArrayList<Department> depArray = DataStructure.depArray;
        Scanner sc = new Scanner(System.in);
        if (drArray.isEmpty()) {
            System.out.println("无法修改医生信息，因为没有在档的医生");
            return;
        } else if (depArray.isEmpty()) {
            System.out.println("无法修改医生信息，因为没有可用的科室");
            return;
        }
        System.out.println("现有医生如下");
        DataStructure.listDr();
        System.out.println("请输入要修改的医生姓名");
        String searchName = sc.next();
        for (Doctor doctor : drArray) {
            if (searchName.equals(doctor.drName)) {
                System.out.println("请输入该医生要修改的姓名");
                String drName = sc.next();
                for (Doctor doctor1 : drArray) {
                    if (drName.equals(doctor1.drName)) {
                        System.out.println("操作失败:已有该医生");
                        modifyDr();
                        return;
                    }
                }
                System.out.println("现有科室如下");
                DataStructure.listDep();
                System.out.println("请输入该医生的所属科室");
                String depName = sc.next();
                for (Department department : depArray) {
                    if (depName.equals(department.depName)) {
                        doctor.drName = drName;
                        doctor.department = department;
                        System.out.println("修改医生信息成功");
                        return;
                    }
                }
                System.out.println("医生信息修改失败，没有找到科室");
                modifyDr();
                return;
            }
        }
        System.out.println("操作失败:找不到医生");
        modifyDr();
    }

    public static void setSchedule() {
        //设置坐诊信息方法，修改医生数组中一个医生对象某天的坐诊计划信息
        ArrayList<Doctor> drArray = DataStructure.drArray;
        Scanner sc = new Scanner(System.in);
        if (drArray.isEmpty()) {
            System.out.println("无法设置坐诊计划，因为没有在档的医生");
            return;
        }
        System.out.println("现有医生如下");
        DataStructure.listDr();
        System.out.println("请输入要设置坐诊信息的医生姓名");
        String drName = sc.next();
        for (Doctor doctor : drArray) {
            if (drName.equals(doctor.drName)){
                System.out.println("可设置该医生的坐诊日期列表如下");
                doctor.listSchedule(doctor.schedule);
                System.out.println("请输入要设置坐诊计划的日期");
                String date = sc.next();
                Set<String> keySet = doctor.schedule.keySet();
                for (String s : keySet) {
                    DailySchedule curDay = doctor.schedule.get(s);
                    if(date.equals(s)){
                        System.out.println("该医生上午是否需要坐诊?(y/n)");
                        String chooseMorning = sc.next();
                        if(chooseMorning.equals("y")){
                            while(!DailySchedule.setCountMorning(sc,curDay)){
                                System.out.println("操作错误，请重新设置");
                            }
                        }
                        System.out.println("该医生下午是否需要坐诊?(y/n)");
                        String chooseAfternoon = sc.next();
                        if(chooseAfternoon.equals("y")){
                            while(!DailySchedule.setCountAfternoon(sc,curDay)){
                                System.out.println("操作错误，请重新设置");
                            }
                        }
                        System.out.println("医生坐诊信息设置完成");
                        return;
                    }
                }
                System.out.println("操作失败:日期不合法");
                setSchedule();
                return;
            }
        }
        System.out.println("操作失败:找不到医生");
        setSchedule();
    }

    public static void showAll() {
        //展示全部信息方法，通过遍历展示科室数组，医生数组以及医生坐诊信息Map中所有的有效对象
        ArrayList<Doctor> drArray = DataStructure.drArray;
        ArrayList<Department> depArray = DataStructure.depArray;
        if (depArray.isEmpty()) {
            System.out.println("无法陈列信息，因为没有可用的科室");
            return;
        }
        System.out.println("本医院全部科室、医生及医生坐诊信息如下");
        for (Department department : depArray) {
            System.out.println("科室:"+department.depName);
            for (Doctor doctor : drArray) {
                if(doctor.department.equals(department)){
                    System.out.println("\t"+doctor.drName+"\t|\t坐诊情况:");
                    Set<String> keySet = doctor.schedule.keySet();
                    for (String s : keySet) {
                        DailySchedule curDay = doctor.schedule.get(s);
                        if(curDay.isMorning){
                            System.out.println("\t\t"+s+"上午\t"+curDay.morningTime[0]+
                                    "-"+curDay.morningTime[1]+"\t可预约数:"+curDay.morningCount+
                                    "/"+(curDay.morningCount+curDay.morningBooked)+"(可预约/总预约数)");
                        }
                        if(curDay.isAfternoon){
                            System.out.println("\t\t"+s+"下午\t"+curDay.afternoonTime[0]+
                                    "-"+curDay.afternoonTime[1]+"\t可预约数:"+curDay.afternoonCount+
                                    "/"+(curDay.afternoonCount+curDay.afternoonBooked)+"(可预约/总预约数)");
                        }
                    }
                }
            }
        }
    }

    public static void drBook() {
        //预约方法，修改医生数组中一个医生对象的单日坐诊计划信息
        ArrayList<Doctor> drArray = DataStructure.drArray;
        ArrayList<Department> depArray = DataStructure.depArray;
        ArrayList<Doctor> drArrayFlag = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        if (drArray.isEmpty()) {
            System.out.println("无法进行预约，因为没有在档的医生");
            return;
        } else if (depArray.isEmpty()) {
            System.out.println("无法进行预约，因为没有可用的科室");
            return;
        }
        System.out.println("现有科室如下");
        DataStructure.listDep();
        System.out.println("请选择需要挂号的科室");
        String depName = sc.next();
        for (Department department : depArray) {
            if(depName.equals(department.depName)){
                System.out.println("该科室的医生列表如下");
                for (Doctor doctor : drArray) {
                    if(doctor.department.equals(department)){
                        System.out.println(doctor.drName);
                        drArrayFlag.add(doctor);
                    }
                }
                if(drArrayFlag.isEmpty()){
                    System.out.println("错误:该科室没有医生");
                    return;
                }
                System.out.println("请选择需要预约的医生");
                String drName = sc.next();
                for (Doctor doctor : drArrayFlag) {
                    if(drName.equals(doctor.drName)){
                        Set<String> keySet = doctor.schedule.keySet();
                        System.out.println("计划内的日期如下");
                        doctor.listSchedule(doctor.schedule);
                        System.out.println("请选择要预约的日期");
                        String date = sc.next();
                        for (String s : keySet) {
                            DailySchedule curDay = doctor.schedule.get(s);
                            if(date.equals(s)){
                                System.out.println("上午或下午预约?(m/a)");
                                switch (sc.next()){
                                    case "m":{
                                        if(DailySchedule.bookMorning(sc,curDay)){
                                            System.out.println("预约成功");
                                        }else {
                                            drBook();
                                        }
                                        return;
                                    }
                                    case "a":{
                                        if(DailySchedule.bookAfternoon(sc,curDay)){
                                            System.out.println("预约成功");
                                        }else {
                                            drBook();
                                        }
                                        return;
                                    }
                                    default:{
                                        System.out.println("操作失败:输入有误");
                                        drBook();
                                        return;
                                    }
                                }
                            }
                        }
                        System.out.println("操作失败:日期不合法");
                        drBook();
                        return;
                    }
                    System.out.println("操作失败:找不到医生");
                    drBook();
                    return;
                }
                System.out.println("操作失败:找不到医生");
                drBook();
                return;
            }
        }
        System.out.println("操作失败:找不到科室");
        drBook();
    }

    public static void searchTime() {
        //搜索功能，输入一个日期，生成一个日期数组，通过遍历查找比对展示有关的科室、医生及单日坐诊计划对象
        ArrayList<Doctor> drArray = DataStructure.drArray;
        ArrayList<Department> depArray = DataStructure.depArray;
        ArrayList<Doctor> drArrayFlag = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        if (drArray.isEmpty()) {
            System.out.println("无法搜索，因为没有在档的医生");
            return;
        } else if (depArray.isEmpty()) {
            System.out.println("无法搜索，因为没有可用的科室");
            return;
        }
        System.out.println("请输入一个日期(xxxx-xx-xx)");
        LocalDate day = LocalDate.parse(sc.next());
        LocalTime[] timeFlag = new LocalTime[2];
        System.out.println("请输入起始时间");
        timeFlag[0] = LocalTime.parse(sc.next());
        System.out.println("请输入结束时间");
        timeFlag[1] = LocalTime.parse(sc.next());
        ArrayList<String> dateArray = Doctor.getSchedule(day);
        for (Doctor doctor : drArray) {
            Set<String> keySet = doctor.schedule.keySet();
            for (String s : keySet) {
                DailySchedule curDay = doctor.schedule.get(s);
                for (String date : dateArray) {
                    if(date.equals(s)){
                        if(DailySchedule.getDoctor(curDay,timeFlag)){
                            drArrayFlag.add(doctor);
                        }
                    }
                }
            }
        }
        if (drArrayFlag.isEmpty()) {
            System.out.println("该时间段内没有医生坐诊");
            return;
        }
        System.out.println("该时间段内坐诊的医生信息如下");
        for (Department department : depArray) {
            System.out.println("科室:"+department.depName);
            for (Doctor doctor : drArrayFlag) {
                if(doctor.department.equals(department)){
                    System.out.println("\t"+doctor.drName+"\t|\t坐诊情况:");
                    Set<String> keySet = doctor.schedule.keySet();
                    for (String s : keySet) {
                        DailySchedule curDay = doctor.schedule.get(s);
                        if(curDay.isMorning){
                            System.out.println("\t\t"+s+"上午\t"+curDay.morningTime[0]+
                                    "-"+curDay.morningTime[1]+"\t可预约数:"+curDay.morningCount+
                                    "/"+(curDay.morningCount+curDay.morningBooked)+"(可预约/总预约数)");
                        }
                        if(curDay.isAfternoon){
                            System.out.println("\t\t"+s+"下午\t"+curDay.afternoonTime[0]+
                                    "-"+curDay.afternoonTime[1]+"\t可预约数:"+curDay.afternoonCount+
                                    "/"+(curDay.afternoonCount+curDay.afternoonBooked)+"(可预约/总预约数)");
                        }
                    }
                }
            }
        }
    }

    public static void searchDr() {
        //查询方法，列出一个医生对象的全部坐诊信息
        ArrayList<Doctor> drArray = DataStructure.drArray;
        Scanner sc = new Scanner(System.in);
        if (drArray.isEmpty()) {
            System.out.println("无法查询，因为没有在档的医生");
            return;
        }
        System.out.println("现有医生如下");
        DataStructure.listDr();
        System.out.println("请输入要查询的医生");
        String drName = sc.next();
        for (Doctor doctor : drArray) {
            if(drName.equals(doctor.drName)){
                System.out.println("该医生的坐诊及预约信息如下");
                System.out.println("\t"+doctor.drName+"\t|\t坐诊情况:");
                Set<String> keySet = doctor.schedule.keySet();
                for (String s : keySet) {
                    DailySchedule curDay = doctor.schedule.get(s);
                    if(curDay.isMorning){
                        System.out.println("\t\t"+s+"上午\t"+curDay.morningTime[0]+
                                "-"+curDay.morningTime[1]+"\t可预约数:"+curDay.morningCount+
                                "/"+(curDay.morningCount+curDay.morningBooked)+"(可预约/总预约数)");
                        if(!curDay.morningPat.isEmpty()){
                            System.out.println("\t\t患者:"+curDay.morningPat);
                        }
                    }
                    if(curDay.isAfternoon){
                        System.out.println("\t\t"+s+"下午\t"+curDay.afternoonTime[0]+
                                "-"+curDay.afternoonTime[1]+"\t可预约数:"+curDay.afternoonCount+
                                "/"+(curDay.afternoonCount+curDay.afternoonBooked)+"(可预约/总预约数)");
                        if(!curDay.afternoonPat.isEmpty()){
                            System.out.println("\t\t患者:"+curDay.afternoonPat);
                        }
                    }
                }
                return;
            }
        }
        System.out.println("操作失败:找不到医生");
        searchDr();
    }
}
