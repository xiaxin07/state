package com.xiaxin;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> store = new ArrayList<>();
    private Random random = new Random(47);

    private void add(T t) {
        store.add(t);
    }

    private T select() {
        return store.get((int) (java.lang.Math.random() * store.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for (String s : "hello ni hao wo".split(" ")) {
            randomList.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(randomList.select());
        }
    }
}
