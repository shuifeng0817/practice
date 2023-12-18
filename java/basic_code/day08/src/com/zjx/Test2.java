package com.zjx;

import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        ArrayList list1 = new ArrayList();
        list.add("stu1");
        list.add("stu2");
        list.add("stu3");
        list.add("stu4");
        list2.addAll(list);
        //list2.clear();
        Iterator iterator =list.iterator();
      /* while (iterator.hasNext()){
           Object obj =iterator.next();
           System.out.println(obj);
       }*/
        for (Object student : list) {
            System.out.println(student);
        }

        System.out.println(list2.size());
        System.out.println(list.get(1));

    }
}
