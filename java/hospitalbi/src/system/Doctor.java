package system;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;

public class Doctor {
    //医生类，用于存放医生成员变量和医生有关方法
    public String drName;
    public Department department;
    public LinkedHashMap<String, DailySchedule> schedule = new LinkedHashMap<>();

    public Doctor(String drName, Department department) {
        //医生类的构造方法，会为drName和department变量赋值，同时生成一个空的7天坐诊计划
        this.drName = drName;
        this.department = department;
        newSchedule(this.schedule);
    }

    private void newSchedule(LinkedHashMap<String, DailySchedule> schedule) {
        //为一个Doctor对象生成一个空的7天坐诊计划
        Calendar cal;
        Date date;
        DateFormat dateFormat = DateFormat.getDateInstance();
        for (int i = 0; i < 7; i++) {
            DailySchedule dailySchedule = new DailySchedule();
            cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            date = cal.getTime();
            String dateStr = dateFormat.format(date);
            schedule.put(dateStr, dailySchedule);
        }
    }

    public static ArrayList<String> getSchedule(LocalDate day){
        //被Functions类的searchTime方法调用，返回一个连续的7天日期数组
        ArrayList<String> dateArray = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            LocalDate newDay = day.plusDays(i);
            String dayStr = newDay.toString();
            dateArray.add(dayStr);
        }
        return dateArray;
    }

    public void listSchedule(LinkedHashMap<String, DailySchedule> schedule) {
        //用于遍历打印一个医生的坐诊日期
        Set<String> keySet = schedule.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }
    }
}
