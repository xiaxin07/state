package com.xiaxin;

public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }
    public <A,B> void f(A a,B b) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
    }
    public <A> void f(A a,Integer integer) {
        System.out.println("---------------------");
        System.out.println(a.getClass().getName());
        System.out.println(integer.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("");
        genericMethods.f(1.0);

        genericMethods.f(1L);
        genericMethods.f('C');
        genericMethods.f(genericMethods);
        genericMethods.f("", 1);
    }
}
