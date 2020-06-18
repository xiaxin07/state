package com.xiaxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewUtil {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = NewUtil.map();
        map.put("cui", 1);
        System.out.println(map.get("cui"));
        Map<String, Integer> map1 = NewUtil.<String, Integer>map();

        Map<String, List<? extends Person>> map2 = NewUtil.map();
        List<Person> students = new ArrayList<>();
        students.add(new Person());
        students.add(new Student());
        map2.put("xia", students);
        System.out.println(map2.get("xia"));



    }
}
