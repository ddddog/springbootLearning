package com.github.ddddog.springbootLearning.jvm.initializationExtends;

public class C extends Super{
    
    static String cName = "cName";
    static {
        System.out.println(" initializing C ");
    }
}