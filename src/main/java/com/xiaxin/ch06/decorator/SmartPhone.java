package com.xiaxin.ch06.decorator;

/**
 * @author 夏心
 * 装饰角色（Decorator）
 */
public abstract class SmartPhone implements Phone {
    /**
     * 包含一个对真实对象的引用
     */
    private Phone phone;

    public SmartPhone(Phone phone) {
        super();
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
