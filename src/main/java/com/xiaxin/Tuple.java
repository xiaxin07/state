package com.xiaxin;

/**
 * @author 夏心
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class Tuple<A, B, C> {
    public final A code;
    public final B data;
    public final C count;

    public Tuple(A a, B b, C c) {
        this.code = a;
        this.data = b;
        this.count = c;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "code=" + code +
                ", data=" + data +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        Tuple<String, String, Integer> tuple = new Tuple<>("code", "data", 5);
        System.out.println(tuple);
        System.out.println(tuple.code);
        System.out.println(tuple.data);
        System.out.println(tuple.count);
    }
}
