package system;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class DailySchedule {
    //单日坐诊计划类，包含上下午是否坐诊，坐诊时间段，总可预约数，已预约数及患者数组成员变量
    public boolean isMorning = false;
    public boolean isAfternoon = false;
    public int morningCount = 0;
    public int afternoonCount = 0;
    public int morningBooked = 0;
    public int afternoonBooked = 0;
    public LocalTime[] morningTime = new LocalTime[2];
    public LocalTime[] afternoonTime = new LocalTime[2];
    public ArrayList<String> morningPat = new ArrayList<>();
    public ArrayList<String> afternoonPat = new ArrayList<>();

    public static boolean setCountMorning(Scanner sc, DailySchedule curDay) {
        //设置上午坐诊时间方法，若设置成功返回true并修订单日计划,否则返回false
        LocalTime[] timeFlag = new LocalTime[2];
        int flagCount;
        System.out.println("请设置坐诊起始时间(01:00-12:00中选择输入)");
        timeFlag[0] = LocalTime.parse(sc.next());
        if (timeFlag[0].isBefore(LocalTime.parse("12:01"))) {
            System.out.println("请设置坐诊结束时间(01:00-12:00中选择输入)");
            timeFlag[1] = LocalTime.parse(sc.next());
            if (timeFlag[1].isBefore(LocalTime.parse("12:01")) &&
                    timeFlag[1].isAfter(timeFlag[0])) {
                System.out.println("请设置可预约人数");
                flagCount = Integer.parseInt(sc.next());
                if (flagCount > 0) {
                    curDay.isMorning = true;
                    curDay.morningTime = timeFlag;
                    curDay.morningCount = flagCount;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean setCountAfternoon(Scanner sc, DailySchedule curDay) {
        //设置下午坐诊时间方法，若设置成功返回true并修订单日计划,否则返回false
        LocalTime[] timeFlag = new LocalTime[2];
        int flagCount;
        System.out.println("请设置坐诊起始时间(13:00-00:00中选择输入)");
        timeFlag[0] = LocalTime.parse(sc.next());
        if (timeFlag[0].isAfter(LocalTime.parse("12:59"))) {
            System.out.println("请设置坐诊结束时间(13:00-00:00中选择输入)");
            timeFlag[1] = LocalTime.parse(sc.next());
            if (timeFlag[1].isAfter(LocalTime.parse("12:59")) &&
                    timeFlag[1].isAfter(timeFlag[0])) {
                System.out.println("请设置可预约人数");
                flagCount = Integer.parseInt(sc.next());
                if (flagCount > 0) {
                    curDay.isAfternoon = true;
                    curDay.afternoonTime = timeFlag;
                    curDay.afternoonCount = flagCount;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean bookMorning(Scanner sc, DailySchedule curDay) {
        //上午预约方法，若预约成功返回true并修订单日计划,否则返回false
        if (!curDay.isMorning) {
            System.out.println("该医生上午没有坐诊计划");
            return false;
        }
        LocalTime[] timeFlag = new LocalTime[2];
        System.out.println("请输入预约起始时间");
        timeFlag[0] = LocalTime.parse(sc.next());
        if (timeFlag[0].isAfter(curDay.morningTime[0])) {
            System.out.println("请输入预约结束时间");
            timeFlag[1] = LocalTime.parse(sc.next());
            if (timeFlag[1].isBefore(curDay.morningTime[1]) &&
                    timeFlag[1].isAfter(timeFlag[0])) {
                System.out.println("请输入患者的姓名");
                curDay.morningPat.add(sc.next());
                curDay.morningCount--;
                curDay.morningBooked++;
                return true;
            }
            System.out.println("该医生在该时间段没有坐诊计划");
            return false;
        }
        System.out.println("该医生在该时间段没有坐诊计划");
        return false;
    }

    public static boolean bookAfternoon(Scanner sc, DailySchedule curDay) {
        //下午预约方法，若预约成功返回true并修订单日计划,否则返回false
        if (!curDay.isAfternoon) {
            System.out.println("该医生下午没有坐诊计划");
            return false;
        }
        LocalTime[] timeFlag = new LocalTime[2];
        System.out.println("请输入预约起始时间");
        timeFlag[0] = LocalTime.parse(sc.next());
        if (timeFlag[0].isAfter(curDay.afternoonTime[0])) {
            System.out.println("请输入预约结束时间");
            timeFlag[1] = LocalTime.parse(sc.next());
            if (timeFlag[1].isBefore(curDay.afternoonTime[1]) &&
                    timeFlag[1].isAfter(timeFlag[0])) {
                System.out.println("请输入患者的姓名");
                curDay.afternoonPat.add(sc.next());
                curDay.afternoonCount--;
                curDay.afternoonBooked++;
                return true;
            }
            System.out.println("该医生在该时间段没有坐诊计划");
            return false;
        }
        System.out.println("该医生在该时间段没有坐诊计划");
        return false;
    }

    public static boolean getDoctor(DailySchedule curDay, LocalTime[] timeFlag) {
        //时间段匹配方法，检查一个医生对象的坐诊时间段是否包含控制台输入的时间段
        if (curDay.isMorning) {
            if (timeFlag[0].isAfter(curDay.morningTime[0])) {
                if (timeFlag[1].isBefore(curDay.morningTime[1]) &&
                        timeFlag[1].isAfter(timeFlag[0])) {
                    System.out.println("匹配到上午的坐诊");
                    return true;
                }
            }
        }
        if (curDay.isAfternoon) {
            if (timeFlag[0].isAfter(curDay.afternoonTime[0])) {
                if (timeFlag[1].isBefore(curDay.afternoonTime[1]) &&
                        timeFlag[1].isAfter(timeFlag[0])) {
                    System.out.println("匹配到下午的坐诊");
                    return true;
                }
            }
        }
        return false;
    }
}