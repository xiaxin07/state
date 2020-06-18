package com.xiaxin;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Math {
    int add(int m, int n);
}

interface Math1 {
    int add(int m);
}

public class Test {

    public static void main(String[] args) {
        Math math = new Math() {
            @Override
            public int add(int m, int n) {
                return m + n;
            }
        };

        System.out.println(math.add(5, 5));

        Math lambdaMath = (int m, int n) -> {
            return m + n;
        };
        Math lambdaMath1 = (m, n) -> {
            return m + n;
        };
        Math lambdaMath2 = Integer::sum;

        Math1 math2 = new Math1() {
            @Override
            public int add(int m) {
                return m + 1;
            }
        };
        Math1 lambdaMath3 = (m) -> {
            return m + 1;
        };
        Math1 lambdaMath4 = (m) -> m + 1;

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("消费：" + s);
            }
        };
        consumer.accept("你好呀");
        Consumer<String> consumer1 = s -> System.out.println("lambda消费：" + s);
        consumer1.accept("你好呀");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (java.lang.Math.random() * 9000 + 1000);
            }
        };
        System.out.println("提供:" + supplier.get());
        Supplier<Integer> supplier1 = () -> (int) (java.lang.Math.random() * 9000 + 1000);
        System.out.println("lambda提供:" + supplier1.get());

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        Function<String, Integer> functionTest = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        };
        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = String::toUpperCase;
        System.out.println(function.apply("你好 xiaxin"));
        System.out.println(function1.apply("你好 xiaxin"));

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 8;
            }
        };

        Predicate<Integer> predicate1 = x -> x > 8;
        System.out.println("predicate:" + predicate.test(9));
        System.out.println("predicate lambda:" + predicate1.test(7));


        System.out.println(upper(s -> s.toUpperCase(), "你好 xiaoxia"));
        predicateFu(x -> x > 8, 9);


        IntConsumer intConsumer = x -> System.out.println("intConsumer:" + x);
        intConsumer.accept(89);

        Consumer<String> consumer2 = x -> System.out.println("String:" + x);
        consumer2.accept("hello");

        BiFunction<Integer, Integer, Integer> biFunction = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return java.lang.Math.max(integer, integer2);
            }
        };

        BiFunction<Integer, Integer, Integer> biFunction1 = java.lang.Math::max;

        List<String> list = new ArrayList<>();
        Predicate<String> predicate2 = x -> list.add(x);
        Predicate<String> predicate3 = list::add;

        IntStream ints = new Random().ints();
        DoubleStream doubles = new Random().doubles();
        IntStream stream = new BitSet().stream();
        CharSequence charSequence = new CharSequence() {
            @Override
            public int length() {
                return 0;
            }

            @Override
            public char charAt(int index) {
                return 0;
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return null;
            }
        };
        Stream<String> stringStream = Pattern.compile("").splitAsStream(charSequence);
    }

    public static String upper(Function<String, String> fun, String str) {
        return fun.apply(str);
    }

    public static void predicateFu(Predicate<Integer> predicate, Integer num) {
        System.out.println(predicate.test(num));
    }


}
