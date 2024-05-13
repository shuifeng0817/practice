package com.liuDay007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) throws Exception {
        List<Integer> all = new ArrayList<>();
        Collections.addAll(all, 2,1,3,5,4,6,7,0,8);
        System.out.println(all);
        Collections.reverse(all);
        System.out.println(all);
        Collections.sort(all);
        System.out.println(all);
    }
}
