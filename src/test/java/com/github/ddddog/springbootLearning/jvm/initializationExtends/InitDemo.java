package com.github.ddddog.springbootLearning.jvm.initializationExtends;

public class InitDemo {
	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args){
    	/**
    	 * 类继承的初始化：通过引用 static 字段，触发某个类的初始化，则声明该字段的类，以及该类的父类被初始化。
	     * 根据初始化可见，只有 static 字段的声明类 C ，以及其父类 Super 被初始化了，输出代码中 Sub 类没有被初始化。
    	 */
        System.out.println(Sub.cName);
        /**
         * 接口继承的初始化：通过引用 static 字段，触发某个接口的初始化，则声明该字段的接口会被初始化，但该接口的父接口不会被初始化。
         */
        System.out.println(SubI.iField);
    }
}